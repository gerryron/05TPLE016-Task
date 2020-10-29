package com.gerryron.pertemuan11.DiskusiKetiga.DAO;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.gerryron.pertemuan11.DiskusiKetiga.Entity.Product;
import com.gerryron.pertemuan11.DiskusiKetiga.Entity.Transaction;

public class TransaksiPenjualanDAO {
	private Connection myConn;
	
	public TransaksiPenjualanDAO() throws Exception{
		
		// Get DB Properties
		Properties props = new Properties();
		props.load(new FileInputStream("Config.properties"));
		
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dbUrl = props.getProperty("dbTransactionUrl");
		
		// Create connection to database
		myConn = DriverManager.getConnection(dbUrl, user, password);
	}
	
	public List<Product> getAllProduct() throws Exception {
		List<Product> listProduct = new ArrayList<Product>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("SELECT * FROM product");
			
			while (myRs.next()) {
				Product product = new Product();
				product.setIdProduct(myRs.getInt("id_product"));
				product.setKodeBarang(myRs.getString("kode_barang"));
				product.setNamaBarang(myRs.getString("nama_barang"));
				product.setHargaBarang(myRs.getBigDecimal("harga_barang"));
				
				listProduct.add(product);
			}
		} finally {
			close(myStmt, myRs);
		}
		return listProduct;
	}
	
	public void saveTransaction(Transaction transaksi) throws Exception{
		PreparedStatement preStat = null;
		Date transactionDate = new Date(transaksi.getTanggal().getTime());
		
		try {
			// prepared Statement
			preStat = myConn.prepareStatement("INSERT INTO transaction"
					+ " (no_jual, tanggal, kode_barang, nama_barang, harga_barang, jumlah_barang, total_harga_barang)"
					+ " values (?, ?, ?, ?, ?, ?, ?)");
			
			//set params
			preStat.setString(1, transaksi.getNoJual());
			preStat.setDate(2, transactionDate);
			preStat.setString(3, transaksi.getKodeBarang());
			preStat.setString(4, transaksi.getNamaBarang());
			preStat.setBigDecimal(5, transaksi.getHargaBarang());
			preStat.setInt(6, transaksi.getJumlahBarang());
			preStat.setBigDecimal(7, transaksi.getTotalHargaBarang());
			
			preStat.executeUpdate();
		} finally {
			preStat.close();
		}	
	}
	
	private static void close(Connection myConn, Statement myStmt, ResultSet myRs)
			throws SQLException {

		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {
			myStmt.close();
		}
		
		if (myConn != null) {
			myConn.close();
		}
	}

	private void close(Statement myStmt, ResultSet myRs) throws SQLException {
		close(null, myStmt, myRs);		
	}
	
}
