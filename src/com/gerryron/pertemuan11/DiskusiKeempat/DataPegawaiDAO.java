package com.gerryron.pertemuan11.DiskusiKeempat;

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

public class DataPegawaiDAO {

private Connection myConn;
	
	public DataPegawaiDAO() throws Exception{
		
		// Get DB Properties
		Properties props = new Properties();
		props.load(new FileInputStream("Config.properties"));
		
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dbUrl = props.getProperty("dbUrl");
		
		// Create connection to database
		myConn = DriverManager.getConnection(dbUrl, user, password);
	}
	
	public List<DataPegawai> getAllDataPegawai() throws Exception {
		List<DataPegawai> listPegawai = new ArrayList<DataPegawai>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("SELECT * FROM pegawai");
			
			while (myRs.next()) {
				int idPegawai = myRs.getInt("id_pegawai");
				String namaPegawai = myRs.getString("nama_pegawai");
				char jenisKelamin = myRs.getString("jenis_kelamin").charAt(0);
				
				DataPegawai dataPegawai = new DataPegawai(idPegawai, namaPegawai, jenisKelamin);
				listPegawai.add(dataPegawai);
			}
		} finally {
			close(myStmt, myRs);
		}
		return listPegawai;
	}
	
	public List<DataPegawai> getDataPegawaiByNama(String namaPegawaiParam) throws Exception {
		List<DataPegawai> listPegawai = new ArrayList<DataPegawai>();
		
		PreparedStatement preStat = null;
		ResultSet rs = null;
		
		try {
			preStat = myConn.prepareStatement("SELECT * FROM pegawai where nama_pegawai = ?");
			preStat.setString(1, namaPegawaiParam);
			
			rs = preStat.executeQuery();
			
			while (rs.next()) {
				int idPegawai = rs.getInt("id_pegawai");
				String namaPegawai = rs.getString("nama_pegawai");
				char jenisKelamin = rs.getString("jenis_kelamin").charAt(0);
				
				DataPegawai dataPegawai = new DataPegawai(idPegawai, namaPegawai, jenisKelamin);
				listPegawai.add(dataPegawai);
			}
		} finally {
			close(preStat, rs);
		}
		return listPegawai;
	}
	
	public void saveDataPegawai(DataPegawai dataPegawai) throws Exception{
		PreparedStatement preStat = null;
		
		try {
			// prepared Statement
			preStat = myConn.prepareStatement("INSERT INTO pegawai"
					+ " (id_pegawai,nama_pegawai, jenis_kelamin)"
					+ " values (?, ?, ?)");
			
			//set params
			preStat.setInt(1, dataPegawai.getIdPegawai());
			preStat.setString(2, dataPegawai.getNamaPegawai());
			preStat.setString(3, String.valueOf(dataPegawai.getJenisKelamin()));
			
			preStat.executeUpdate();
		} finally {
			preStat.close();
		}	
	}
	
	public void updateDataPegawai(DataPegawai dataPegawai) throws Exception{
		PreparedStatement preStat = null;
		
		try {
			// prepared Statement
			preStat = myConn.prepareStatement("UPDATE pegawai"
					+ " SET id_pegawai=?, nama_pegawai=?, jenis_kelamin=?"
					+ " WHERE id_pegawai=?");
			
			//set params
			preStat.setInt(1, dataPegawai.getIdPegawai());
			preStat.setString(2, dataPegawai.getNamaPegawai());
			preStat.setString(3, String.valueOf(dataPegawai.getJenisKelamin()));
			preStat.setInt(4, dataPegawai.getIdPegawai());
			
			preStat.executeUpdate();
		} finally {
			preStat.close();
		}	
	}
	
	public void deleteDataPegawai(int idPegawaiParam) throws Exception{
		PreparedStatement preStat = null;
		
		try {
			preStat = myConn.prepareStatement("DELETE FROM pegawai WHERE id_pegawai=?");
			
			preStat.setInt(1, idPegawaiParam);
			
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
