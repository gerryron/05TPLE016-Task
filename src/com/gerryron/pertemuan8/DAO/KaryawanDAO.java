package com.gerryron.pertemuan8.DAO;

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

import com.gerryron.pertemuan8.Entity.Karyawan;

public class KaryawanDAO {
	private Connection myConn;
	
	public KaryawanDAO() throws Exception{
		
		// Get DB Properties
		Properties props = new Properties();
		props.load(new FileInputStream("Config.properties"));
		
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dbUrl = props.getProperty("dbUrl");
		
		// Create connection to database
		myConn = DriverManager.getConnection(dbUrl, user, password);
	}
	
	public List<Karyawan> getAllKaryawan() throws Exception {
		List<Karyawan> list = new ArrayList<Karyawan>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("SELECT * FROM karyawan");
			
			while (myRs.next()) {
				Karyawan karyawan = convertRowToKaryawan(myRs);
				list.add(karyawan);
			}
		} finally {
			close(myStmt, myRs);
		}
		return list;
	}
	
	public List<Karyawan> searchKaryawanByNIK (Integer nik) throws Exception {
		List<Karyawan> listKaryawan = new ArrayList<Karyawan>();
		
		PreparedStatement preStat = null;
		ResultSet rs = null;
		
		try {
			preStat = myConn.prepareStatement("SELECT * FROM karyawan WHERE nik = ?");
			preStat.setInt(1, nik);
			
			rs = preStat.executeQuery();
			
			while (rs.next()) {
				Karyawan karyawan = convertRowToKaryawan(rs);
				listKaryawan.add(karyawan);
			}
		} finally {
			close(preStat, rs);
		}
		
		return listKaryawan;
	}
	
	public void addKaryawan(Karyawan karyawan) throws Exception{
		PreparedStatement preStat = null;
		
		try {
			// prepared Statement
			preStat = myConn.prepareStatement("INSERT INTO karyawan"
					+ " (nik, nama_karyawan, jenis_kelamin, jabatan,"
					+ " gaji_pokok, jam_lembur, upah_lembur, total_gaji)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?)");
			
			//set params
			preStat.setString(1, karyawan.getNik());
			preStat.setString(2, karyawan.getNamaKaryawan());
			preStat.setString(3, karyawan.getJenisKelamin());
			preStat.setString(4, karyawan.getJabatan());
			preStat.setBigDecimal(5, karyawan.getGajiPokok());
			preStat.setShort(6, karyawan.getJamLembur());
			preStat.setBigDecimal(7, karyawan.getUpahLembur());
			preStat.setBigDecimal(8, karyawan.getTotalGaji());
			
			preStat.executeUpdate();
		} finally {
			preStat.close();
		}	
	}
	
	public void updateKaryawan(Karyawan karyawan) throws Exception{
		PreparedStatement preStat = null;
		
		try {
			// prepared Statement
			preStat = myConn.prepareStatement("UPDATE karyawan"
					+ " SET nik=?, nama_karyawan=?, jenis_kelamin=?, jabatan=?,"
					+ " gaji_pokok=?, jam_lembur=?, upah_lembur=?, total_gaji=?"
					+ " WHERE nik=?");
			
			//set params
			preStat.setString(1, karyawan.getNik());
			preStat.setString(2, karyawan.getNamaKaryawan());
			preStat.setString(3, karyawan.getJenisKelamin());
			preStat.setString(4, karyawan.getJabatan());
			preStat.setBigDecimal(5, karyawan.getGajiPokok());
			preStat.setShort(6, karyawan.getJamLembur());
			preStat.setBigDecimal(7, karyawan.getUpahLembur());
			preStat.setBigDecimal(8, karyawan.getTotalGaji());
			preStat.setString(9, karyawan.getNik());
			
			preStat.executeUpdate();
		} finally {
			preStat.close();
		}	
	}
	
	public void deleteKaryawan(Integer nik) throws Exception{
		PreparedStatement preStat = null;
		
		try {
			preStat = myConn.prepareStatement("DELETE FROM karyawan WHERE nik=?");
			
			preStat.setInt(1, nik);
			
			preStat.executeUpdate();
		} finally {
			preStat.close();
		}
	}
	
	private Karyawan convertRowToKaryawan(ResultSet rs) throws SQLException{
	
		Karyawan karyawan = new Karyawan();
		karyawan.setNik(rs.getString("nik"));
		karyawan.setNamaKaryawan(rs.getString("nama_karyawan"));
		karyawan.setJenisKelamin(rs.getString("jenis_kelamin"));
		karyawan.setJabatan(rs.getString("jabatan"));
		karyawan.setGajiPokok(rs.getBigDecimal("gaji_pokok"));
		karyawan.setJamLembur(rs.getShort("jam_lembur"));
		karyawan.setUpahLembur(rs.getBigDecimal("upah_lembur"));
		karyawan.setTotalGaji(rs.getBigDecimal("total_gaji"));
		
		return karyawan;
		
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
