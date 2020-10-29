package com.gerryron.pertemuan9.DiskusiKetiga;

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

import com.gerryron.pertemuan9.DiskusiKetiga.Mahasiswa;

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
			myRs = myStmt.executeQuery("SELECT * FROM mahasiswa2");
			
			while (myRs.next()) {
				Mahasiswa mahasiswa = convertRowToMahasiswa(myRs);
				list.add(mahasiswa);
			}
		} finally {
			close(myStmt, myRs);
		}
		return list;
	}
	
	public void saveMahasiswa(Mahasiswa mahasiswa) throws Exception{
		PreparedStatement preStat = null;
		
		try {
			// prepared Statement
			preStat = myConn.prepareStatement("INSERT INTO mahasiswa2"
					+ " (nim, nama, prodi, matkul, nilai)"
					+ " values (?, ?, ?, ?, ?)");
			
			//set params
			preStat.setString(1, mahasiswa.getNim());
			preStat.setString(2, mahasiswa.getNama());
			preStat.setString(3, mahasiswa.getProdi());
			preStat.setString(4, mahasiswa.getMatkul());
			preStat.setInt(5, mahasiswa.getNilai());
			
			preStat.executeUpdate();
		} finally {
			preStat.close();
		}	
	}
	
	public void updateMahasiswa(Mahasiswa mahasiswa) throws Exception{
		PreparedStatement preStat = null;
		
		try {
			// prepared Statement
			preStat = myConn.prepareStatement("UPDATE mahasiswa2"
					+ " SET nim=?, nama=?, prodi=?, matkul=?, nilai=?"
					+ " WHERE nim=?");
			
			//set params
			preStat.setString(1, mahasiswa.getNim());
			preStat.setString(2, mahasiswa.getNama());
			preStat.setString(3, mahasiswa.getProdi());
			preStat.setString(4, mahasiswa.getMatkul());
			preStat.setInt(5, mahasiswa.getNilai());
			preStat.setString(6, mahasiswa.getNim());
			
			preStat.executeUpdate();
		} finally {
			preStat.close();
		}	
	}
	
	public void deleteMahasiswa(String NIM) throws Exception{
		PreparedStatement preStat = null;
		
		try {
			preStat = myConn.prepareStatement("DELETE FROM mahasiswa2 WHERE nim=?");
			
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
		String matkul = rs.getString("matkul");
		int nilai = rs.getInt("nilai");
		
		Mahasiswa mahasiswa = new Mahasiswa(nim,nama,prodi, matkul, nilai);
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
