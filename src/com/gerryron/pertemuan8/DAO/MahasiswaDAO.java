package com.gerryron.pertemuan8.DAO;

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

import com.gerryron.pertemuan8.Entity.Mahasiswa;

public class MahasiswaDAO {
	private Connection myConn;
	
	public MahasiswaDAO() throws Exception{
		
		// Get DB Properties
		Properties props = new Properties();
		props.load(new FileInputStream("Config.properties"));
		
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dbUrl = props.getProperty("dbUrl");
		
		// Create connection to database
		myConn = DriverManager.getConnection(dbUrl, user, password);
	}
	
	public List<Mahasiswa> getAllMahasiswa() throws Exception {
		List<Mahasiswa> list = new ArrayList<Mahasiswa>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("SELECT * FROM mahasiswa");
			
			while (myRs.next()) {
				Mahasiswa mahasiswa = convertRowToMahasiswa(myRs);
				list.add(mahasiswa);
			}
		} finally {
			close(myStmt, myRs);
		}
		return list;
	}
	
	public List<Mahasiswa> searchMahasiswaByNIM (String NIM) throws Exception {
		List<Mahasiswa> listMahasiswa = new ArrayList<Mahasiswa>();
		
		PreparedStatement preStat = null;
		ResultSet rs = null;
		
		try {
			preStat = myConn.prepareStatement("SELECT * FROM mahasiswa WHERE nim = ?");
			preStat.setString(1, NIM);
			
			rs = preStat.executeQuery();
			
			while (rs.next()) {
				Mahasiswa mahasiswa = convertRowToMahasiswa(rs);
				listMahasiswa.add(mahasiswa);
			}
		} finally {
			close(preStat, rs);
		}
		
		return listMahasiswa;
	}
	
	public String searchMahasiswaByNIMResult (String NIM) throws Exception {
		List<Mahasiswa> listMahasiswa = new ArrayList<Mahasiswa>();
		String result = "Data Mahasiswa Tidak Ditemukan";
		
		PreparedStatement preStat = null;
		ResultSet rs = null;
		
		try {
			preStat = myConn.prepareStatement("SELECT * FROM mahasiswa WHERE nim = ?");
			preStat.setString(1, NIM);
			
			rs = preStat.executeQuery();
			
			while (rs.next()) {
				Mahasiswa mahasiswa = convertRowToMahasiswa(rs);
				listMahasiswa.add(mahasiswa);
			}
			
			if (listMahasiswa.size()>0) result = "Data Mahasiswa Berhasil Ditemukan";
			
			return result;
		} finally {
			close(preStat, rs);
		}
	}
	
	public void addMahasiswa(Mahasiswa mahasiswa) throws Exception{
		PreparedStatement preStat = null;
		
		try {
			// prepared Statement
			preStat = myConn.prepareStatement("INSERT INTO mahasiswa"
					+ " (nim, nama, prodi)"
					+ " values (?, ?, ?)");
			
			//set params
			preStat.setString(1, mahasiswa.getNim());
			preStat.setString(2, mahasiswa.getNama());
			preStat.setString(3, mahasiswa.getProdi());
			
			preStat.executeUpdate();
		} finally {
			preStat.close();
		}	
	}
	
	public void updateMahasiswa(Mahasiswa mahasiswa) throws Exception{
		PreparedStatement preStat = null;
		
		try {
			// prepared Statement
			preStat = myConn.prepareStatement("UPDATE mahasiswa"
					+ " SET nim=?, nama=?, prodi=?"
					+ " WHERE nim=?");
			
			//set params
			preStat.setString(1, mahasiswa.getNim());
			preStat.setString(2, mahasiswa.getNama());
			preStat.setString(3, mahasiswa.getProdi());
			preStat.setString(3, mahasiswa.getNim());
			
			preStat.executeUpdate();
		} finally {
			preStat.close();
		}	
	}
	
	public void deleteMahasiswa(String NIM) throws Exception{
		PreparedStatement preStat = null;
		
		try {
			preStat = myConn.prepareStatement("DELETE FROM mahasiswa WHERE nim=?");
			
			preStat.setString(1, NIM);
			
			preStat.executeUpdate();
		} finally {
			preStat.close();
		}
	}
	
	private Mahasiswa convertRowToMahasiswa(ResultSet rs) throws SQLException{
		
		String nim = rs.getString("nim");
		String nama = rs.getString("nama");
		String prodi = rs.getString("prodi");
		
		Mahasiswa mahasiswa = new Mahasiswa(nim,nama,prodi);
		
		return mahasiswa;
		
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
