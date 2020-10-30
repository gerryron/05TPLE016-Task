package com.gerryron.pertemuan9.DiskusiKeempat;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BarangDAO {

private Connection myConn;
	
	public BarangDAO() throws Exception{
		
		// Get DB Properties
		Properties props = new Properties();
		props.load(new FileInputStream("Config.properties"));
		
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dbUrl = props.getProperty("dbUrl");
		
		// Create connection to database
		myConn = DriverManager.getConnection(dbUrl, user, password);
	}
	
	public List<Barang> getAllBarang() throws Exception {
		List<Barang> listBarang = new ArrayList<Barang>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("SELECT * FROM mahasiswa2");
			
			while (myRs.next()) {
				int idBarang = myRs.getInt("id_barang");
				String kategori = myRs.getString("kategori");
				String namaBarang = myRs.getString("nama_barang");
				
				Barang barang = new Barang(idBarang, kategori, namaBarang);
				listBarang.add(barang);
			}
		} finally {
			close(myStmt, myRs);
		}
		return listBarang;
	}
	
	public void saveBarang(Barang barang) throws Exception{
		PreparedStatement preStat = null;
		
		try {
			// prepared Statement
			preStat = myConn.prepareStatement("INSERT INTO barang"
					+ " (id_barang, kategori, nama_barang)"
					+ " values (?, ?, ?)");
			
			//set params
			preStat.setInt(1, barang.getIdBarang());
			preStat.setString(2, barang.getKategori());
			preStat.setString(3, barang.getNamaBarang());
			
			preStat.executeUpdate();
		} finally {
			preStat.close();
		}	
	}
	
	public void updateMahasiswa(Barang barang) throws Exception{
		PreparedStatement preStat = null;
		
		try {
			// prepared Statement
			preStat = myConn.prepareStatement("UPDATE barang"
					+ " SET id_barang=?, kategori=?, nama_barang=?"
					+ " WHERE id_barang=?");
			
			//set params
			preStat.setInt(1, barang.getIdBarang());
			preStat.setString(2, barang.getKategori());
			preStat.setString(3, barang.getNamaBarang());
			preStat.setInt(4, barang.getIdBarang());
			
			preStat.executeUpdate();
		} finally {
			preStat.close();
		}	
	}
	
	public void deleteMahasiswa(String idBarang) throws Exception{
		PreparedStatement preStat = null;
		
		try {
			preStat = myConn.prepareStatement("DELETE FROM barang WHERE id_barang=?");
			
			preStat.setString(1, idBarang);
			
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
