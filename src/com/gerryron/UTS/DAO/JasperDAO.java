package com.gerryron.UTS.DAO;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Properties;

import com.gerryron.UTS.Model.TransaksiPenjualan;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class JasperDAO {

private Connection myConn;
	
	public JasperDAO() throws Exception{
		
		// Get DB Properties
		Properties props = new Properties();
		props.load(new FileInputStream("Config.properties"));
		
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dbUrl = props.getProperty("dbUTS");
		
		// Create connection to database
		myConn = DriverManager.getConnection(dbUrl, user, password);
	}
	
	public void showJasperPDF(String jrxmlPath) {
		try {
			JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlPath);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, myConn);
			JasperViewer.viewReport(jasperPrint, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showJasperPDFTransaksiPenjualan(String jrxmlPath, List<TransaksiPenjualan> listTransaksi) {
		try {
			JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlPath);
			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listTransaksi);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);
			JasperViewer.viewReport(jasperPrint, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
