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

import com.gerryron.UTS.Entity.DataSupplier;

public class DataSupplierDAO {

	private Connection myConn;
	
	public DataSupplierDAO() throws Exception{
		
		// Get DB Properties
		Properties props = new Properties();
		props.load(new FileInputStream("Config.properties"));
		
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dbUrl = props.getProperty("dbUTS");
		
		// Create connection to database
		myConn = DriverManager.getConnection(dbUrl, user, password);
	}
	
	public List<DataSupplier> getAllDataSupplier() throws Exception {
		List<DataSupplier> listSupplier = new ArrayList<DataSupplier>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("SELECT * FROM dtsplr");
			
			while (myRs.next()) {
				String kodeSupplier = myRs.getString("kdsplr");
				String namaSupplier = myRs.getString("nm_splr");
				String namaBarang = myRs.getString("nm_brg");
				BigDecimal banyakBarang = myRs.getBigDecimal("bynk_brg");
				
				DataSupplier dataSupplier = new DataSupplier(kodeSupplier, namaSupplier, namaBarang, banyakBarang);
				listSupplier.add(dataSupplier);
			}
		} finally {
			close(myStmt, myRs);
		}
		return listSupplier;
	}
	
	public List<DataSupplier> getDataSupplierByNama(String namaSupplierParam) throws Exception {
		List<DataSupplier> listSupplier = new ArrayList<DataSupplier>();
		
		PreparedStatement preStat = null;
		ResultSet rs = null;
		namaSupplierParam += "%";
		
		try {
			preStat = myConn.prepareStatement("SELECT * FROM dtsplr where nm_splr like ?");
			preStat.setString(1, namaSupplierParam);
			
			rs = preStat.executeQuery();
			
			while (rs.next()) {
				String kodeSupplier = rs.getString("kdsplr");
				String namaSupplier = rs.getString("nm_splr");
				String namaBarang = rs.getString("nm_brg");
				BigDecimal banyakBarang = rs.getBigDecimal("bynk_brg");
				
				DataSupplier dataSupplier = new DataSupplier(kodeSupplier, namaSupplier, namaBarang, banyakBarang);
				listSupplier.add(dataSupplier);
			}
		} finally {
			close(preStat, rs);
		}
		return listSupplier;
	}
	
	public void saveDataSupplier(DataSupplier dataSupplier) throws Exception{
		PreparedStatement preStat = null;
		
		try {
			// prepared Statement
			preStat = myConn.prepareStatement("INSERT INTO dtsplr"
					+ " (kdsplr,nm_splr,nm_brg,bynk_brg)"
					+ " values (?,?,?,?)");
			
			//set param
			preStat.setString(1, dataSupplier.getKodeSupplier());
			preStat.setString(2, dataSupplier.getNamaSupplier());
			preStat.setString(3, dataSupplier.getNamaBarang());
			preStat.setBigDecimal(4, dataSupplier.getBanyakBarang());
			
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
