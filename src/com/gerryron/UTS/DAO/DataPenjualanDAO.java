package com.gerryron.UTS.DAO;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import com.gerryron.UTS.Entity.DataPenjualan;

public class DataPenjualanDAO {

private Connection myConn;
	
	public DataPenjualanDAO() throws Exception{
		
		// Get DB Properties
		Properties props = new Properties();
		props.load(new FileInputStream("Config.properties"));
		
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dbUrl = props.getProperty("dbUTS");
		
		// Create connection to database
		myConn = DriverManager.getConnection(dbUrl, user, password);
	}

	public void saveDataPenjualan(DataPenjualan dataPenjualan) throws Exception{
		PreparedStatement preStat = null;
		
		try {
			// prepared Statement
			preStat = myConn.prepareStatement("INSERT INTO dtpjl"
					+ " (kd_brg,tgl,ttl_byr,byr,jml_beli,ptng)"
					+ " values (?,?,?,?,?,?)");
			
			//set param
			preStat.setString(1, dataPenjualan.getKodeBarang());
			preStat.setTimestamp(2, dataPenjualan.getTanggal());
			preStat.setBigDecimal(3, dataPenjualan.getTotalBayar());
			preStat.setBigDecimal(4, dataPenjualan.getBayar());
			preStat.setBigDecimal(5, dataPenjualan.getJumlahBeli());
			preStat.setBigDecimal(6, dataPenjualan.getPotongan());
			
			preStat.executeUpdate();
		} finally {
			preStat.close();
		}	
	}
	
}
