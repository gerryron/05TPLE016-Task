package com.gerryron.UTS.DAO;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.gerryron.UTS.Entity.DataBarang;

public class DataBarangDAO {

	private Connection myConn;
	
	public DataBarangDAO() throws Exception{
		
		// Get DB Properties
		Properties props = new Properties();
		props.load(new FileInputStream("Config.properties"));
		
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dbUrl = props.getProperty("dbUTS");
		
		// Create connection to database
		myConn = DriverManager.getConnection(dbUrl, user, password);
	}
	
	public List<DataBarang> getAllDataBarang() throws Exception {
		List<DataBarang> listBarang = new ArrayList<DataBarang>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("SELECT * FROM dtbrg");
			
			while (myRs.next()) {
				String kodeBarang = myRs.getString("kd_brg");
				String namaBarang = myRs.getString("nm_brg");
				String jenisBarang = myRs.getString("jns");
				BigDecimal jumlah = myRs.getBigDecimal("jml");
				BigDecimal pembelian = myRs.getBigDecimal("pbl");
				BigDecimal penjualan = myRs.getBigDecimal("pjl");
				
				DataBarang dataBarang = new DataBarang(kodeBarang, namaBarang, jenisBarang, jumlah, pembelian, penjualan);
				listBarang.add(dataBarang);
			}
		} finally {
			close(myStmt, myRs);
		}
		return listBarang;
	}
	
	public List<DataBarang> getDataBarangByNama(String namaBarangParam) throws Exception {
		List<DataBarang> listBarang = new ArrayList<DataBarang>();
		
		PreparedStatement preStat = null;
		ResultSet rs = null;
		namaBarangParam += "%";
		
		try {
			preStat = myConn.prepareStatement("SELECT * FROM dtbrg where nm_brg like ?");
			preStat.setString(1, namaBarangParam);
			
			rs = preStat.executeQuery();
			
			while (rs.next()) {
				String kodeBarang = rs.getString("kd_brg");
				String namaBarang = rs.getString("nm_brg");
				String jenisBarang = rs.getString("jns");
				BigDecimal jumlah = rs.getBigDecimal("jml");
				BigDecimal pembelian = rs.getBigDecimal("pbl");
				BigDecimal penjualan = rs.getBigDecimal("pjl");
				
				DataBarang dataBarang = new DataBarang(kodeBarang, namaBarang, jenisBarang, jumlah, pembelian, penjualan);
				listBarang.add(dataBarang);
			}
		} finally {
			close(preStat, rs);
		}
		return listBarang;
	}
	
	public DataBarang getDataBarangByKode(String kodeBarangParam) throws Exception {
		DataBarang dataBarang = new DataBarang();
		
		PreparedStatement preStat = null;
		ResultSet rs = null;
		
		try {
			preStat = myConn.prepareStatement("SELECT * FROM dtbrg where kd_brg = ?");
			preStat.setString(1, kodeBarangParam);
			
			rs = preStat.executeQuery();
			
			while (rs.next()) {
				String kodeBarang = rs.getString("kd_brg");
				String namaBarang = rs.getString("nm_brg");
				String jenisBarang = rs.getString("jns");
				BigDecimal jumlah = rs.getBigDecimal("jml");
				BigDecimal pembelian = rs.getBigDecimal("pbl");
				BigDecimal penjualan = rs.getBigDecimal("pjl");
				
				dataBarang = new DataBarang(kodeBarang, namaBarang, jenisBarang, jumlah, pembelian, penjualan);
			}
		} finally {
			close(preStat, rs);
		}
		return dataBarang;
	}
	
	public void saveDataBarang(DataBarang dataBarang) throws Exception{
		PreparedStatement preStat = null;
		
		try {
			// prepared Statement
			preStat = myConn.prepareStatement("INSERT INTO dtbrg"
					+ " (kd_brg,nm_brg,jns,jml,pbl,pjl)"
					+ " values (?,?,?,?,?,?)");
			
			//set param
			preStat.setString(1, dataBarang.getKodeBarang());
			preStat.setString(2, dataBarang.getNamaBarang());
			preStat.setString(3, dataBarang.getJenisBarang());
			preStat.setBigDecimal(4, dataBarang.getJumlah());
			preStat.setBigDecimal(5, dataBarang.getPembelian());
			preStat.setBigDecimal(6, dataBarang.getPenjualan());
			
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
