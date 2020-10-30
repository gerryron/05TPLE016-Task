package com.gerryron.pertemuan11.DiskusiPertama;

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

public class DataIPMahasiswaDAO {

private Connection myConn;
	
	public DataIPMahasiswaDAO() throws Exception{
		
		// Get DB Properties
		Properties props = new Properties();
		props.load(new FileInputStream("Config.properties"));
		
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dbUrl = props.getProperty("dbUrl");
		
		// Create connection to database
		myConn = DriverManager.getConnection(dbUrl, user, password);
	}
	
	public List<DataIPMahasiswa> getAllNilaiMahasiswa() throws Exception {
		List<DataIPMahasiswa> listIndex = new ArrayList<DataIPMahasiswa>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("SELECT * FROM datanilai");
			
			while (myRs.next()) {
				String nim = myRs.getString("nim");
				String nama = myRs.getString("nama");
				String prodi = myRs.getString("prodi");
				String indexPrestasi = myRs.getString("index_prestasi");
				String email = myRs.getString("email");
				String telp = myRs.getString("telp");
				
				DataIPMahasiswa dataIndex = new DataIPMahasiswa(nim, nama, prodi, indexPrestasi, email, telp);
				listIndex.add(dataIndex);
			}
		} finally {
			close(myStmt, myRs);
		}
		return listIndex;
	}
	
	public void saveDataIPMahasiswa(DataIPMahasiswa dataIndex) throws Exception{
		PreparedStatement preStat = null;
		
		try {
			// prepared Statement
			preStat = myConn.prepareStatement("INSERT INTO mahasiswa3"
					+ " (nim, nama, prodi, index_prestasi, email, telp)"
					+ " values (?, ?, ?, ?, ?, ?)");
			
			//set params
			preStat.setString(1, dataIndex.getNim());
			preStat.setString(2, dataIndex.getNama());
			preStat.setString(3, dataIndex.getProdi());
			preStat.setString(4, dataIndex.getIndexPrestasi());
			preStat.setString(5, dataIndex.getEmail());
			preStat.setString(6, dataIndex.getTelp());
			
			preStat.executeUpdate();
		} finally {
			preStat.close();
		}	
	}
	
	public void updateDataIPMahasiswa(DataIPMahasiswa dataIndex) throws Exception{
		PreparedStatement preStat = null;
		
		try {
			// prepared Statement
			preStat = myConn.prepareStatement("UPDATE mahasiswa3"
					+ " SET nim=?, nama=?, prodi=?, index_prestasi=?, email=?, telp=?"
					+ " WHERE nim=?");
			
			//set params
			preStat.setString(1, dataIndex.getNim());
			preStat.setString(2, dataIndex.getNama());
			preStat.setString(3, dataIndex.getProdi());
			preStat.setString(4, dataIndex.getIndexPrestasi());
			preStat.setString(5, dataIndex.getEmail());
			preStat.setString(6, dataIndex.getTelp());
			preStat.setString(7, dataIndex.getNim());
			
			preStat.executeUpdate();
		} finally {
			preStat.close();
		}	
	}
	
	public void deleteDataIPMahasiswa(String nim) throws Exception{
		PreparedStatement preStat = null;
		
		try {
			preStat = myConn.prepareStatement("DELETE FROM mahasiswa3 WHERE nim=?");
			
			preStat.setString(1, nim);
			
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
