package com.gerryron.pertemuan9.DiskusiKelima;

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

public class DataNilaiMahasiswaDAO {

private Connection myConn;
	
	public DataNilaiMahasiswaDAO() throws Exception{
		
		// Get DB Properties
		Properties props = new Properties();
		props.load(new FileInputStream("Config.properties"));
		
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dbUrl = props.getProperty("dbUrl");
		
		// Create connection to database
		myConn = DriverManager.getConnection(dbUrl, user, password);
	}
	
	public List<DataNilaiMahasiswa> getAllNilaiMahasiswa() throws Exception {
		List<DataNilaiMahasiswa> listNilai = new ArrayList<DataNilaiMahasiswa>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("SELECT * FROM datanilai");
			
			while (myRs.next()) {
				String nim = myRs.getString("nim");
				String namaMahasiswa = myRs.getString("nama_mahasiswa");
				int semester = myRs.getInt("semester");
				String matkul = myRs.getString("mata_kuliah");
				int kehadiran = myRs.getInt("kehadiran");
				int tugas = myRs.getInt("tugas");
				int uts = myRs.getInt("uts");
				int uas = myRs.getInt("uas");
				
				DataNilaiMahasiswa dataNilai = new DataNilaiMahasiswa(nim, namaMahasiswa, semester, matkul, kehadiran, tugas, uts, uas);
				listNilai.add(dataNilai);
			}
		} finally {
			close(myStmt, myRs);
		}
		return listNilai;
	}
	
	public List<DataNilaiMahasiswa> getDataNilaiMahasiswaByNIM(String nimMahasiswa) throws Exception {
		List<DataNilaiMahasiswa> listNilai = new ArrayList<DataNilaiMahasiswa>();
		
		PreparedStatement preStat = null;
		ResultSet rs = null;
		
		try {
			preStat = myConn.prepareStatement("SELECT * FROM datanilai where nim= ?");
			preStat.setString(1, nimMahasiswa);
			
			rs = preStat.executeQuery();
			
			while (rs.next()) {
				String nim = rs.getString("nim");
				String namaMahasiswa = rs.getString("nama_mahasiswa");
				int semester = rs.getInt("semester");
				String matkul = rs.getString("mata_kuliah");
				int kehadiran = rs.getInt("kehadiran");
				int tugas = rs.getInt("tugas");
				int uts = rs.getInt("uts");
				int uas = rs.getInt("uas");
				
				DataNilaiMahasiswa dataNilai = new DataNilaiMahasiswa(nim, namaMahasiswa, semester, matkul, kehadiran, tugas, uts, uas);
				listNilai.add(dataNilai);
			}
		} finally {
			close(preStat, rs);
		}
		return listNilai;
	}
	
	public void saveDataNilaiMahasiswa(DataNilaiMahasiswa dataNilai) throws Exception{
		PreparedStatement preStat = null;
		
		try {
			// prepared Statement
			preStat = myConn.prepareStatement("INSERT INTO dataNilai"
					+ " (nim, nama_mahasiswa, semester, mata_kuliah, kehadiran, tugas, uts, uas)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?)");
			
			//set params
			preStat.setString(1, dataNilai.getNim());
			preStat.setString(2, dataNilai.getNamaMahasiswa());
			preStat.setInt(3, dataNilai.getSemester());
			preStat.setString(4, dataNilai.getMatkul());
			preStat.setInt(5, dataNilai.getKehadiran());
			preStat.setInt(6, dataNilai.getTugas());
			preStat.setInt(7, dataNilai.getUts());
			preStat.setInt(8, dataNilai.getUas());
			
			preStat.executeUpdate();
		} finally {
			preStat.close();
		}	
	}
	
	public void updateDataNilaiMahasiswa(DataNilaiMahasiswa dataNilai) throws Exception{
		PreparedStatement preStat = null;
		
		try {
			// prepared Statement
			preStat = myConn.prepareStatement("UPDATE dataNilai"
					+ " SET nim=?, nama_mahasiswa=?, semester=?, mata_kuliah=?, kehadiran=?, tugas=?, uts=?, uas=?"
					+ " WHERE nim=?");
			
			//set params
			preStat.setString(1, dataNilai.getNim());
			preStat.setString(2, dataNilai.getNamaMahasiswa());
			preStat.setInt(3, dataNilai.getSemester());
			preStat.setString(4, dataNilai.getMatkul());
			preStat.setInt(5, dataNilai.getKehadiran());
			preStat.setInt(6, dataNilai.getTugas());
			preStat.setInt(7, dataNilai.getUts());
			preStat.setInt(8, dataNilai.getUas());
			preStat.setString(9, dataNilai.getNim());
			
			preStat.executeUpdate();
		} finally {
			preStat.close();
		}	
	}
	
	public void deleteDataNilaiMahasiswa(String nim) throws Exception{
		PreparedStatement preStat = null;
		
		try {
			preStat = myConn.prepareStatement("DELETE FROM dataNiali WHERE nim=?");
			
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
