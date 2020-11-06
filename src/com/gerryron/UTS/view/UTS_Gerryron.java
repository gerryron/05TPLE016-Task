package com.gerryron.UTS.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.gerryron.UTS.DAO.JasperDAO;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UTS_Gerryron {

	private JFrame frmUtsGerryron;
	private JasperDAO jasperDao;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UTS_Gerryron window = new UTS_Gerryron();
					window.frmUtsGerryron.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UTS_Gerryron() {
		frmUtsGerryron = new JFrame();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			jasperDao = new JasperDAO();
		} catch (Exception e){
			JOptionPane.showMessageDialog(null, "Error : " + e, "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		frmUtsGerryron.setTitle("UTS Gerryron");
		frmUtsGerryron.setBounds(100, 100, 562, 333);
		frmUtsGerryron.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmUtsGerryron.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TOKO");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(60, 90, 77, 41);
		panel.add(lblNewLabel);
		
		JLabel lbljayaAbadi = new JLabel("\"JAYA ABADI\"");
		lbljayaAbadi.setForeground(Color.RED);
		lbljayaAbadi.setFont(new Font("Arial", Font.BOLD, 20));
		lbljayaAbadi.setBounds(133, 90, 152, 41);
		panel.add(lbljayaAbadi);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEEE, dd MMMM yyyy        hh:mm:ss", new Locale("id", "ID"));
		String currDate = dateFormat.format(new Date());
		JLabel lblNewLabel_1 = new JLabel(currDate);
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(308, 233, 228, 14);
		panel.add(lblNewLabel_1);
		
		JMenuBar menuBar = new JMenuBar();
		frmUtsGerryron.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Data");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Data Barang");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataBarangView.main();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem2 = new JMenuItem("Data Supplier");
		mntmNewMenuItem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataSupplierView.main();
			}
		});
		mnNewMenu.add(mntmNewMenuItem2);
		
		
		JMenu mnNewMenu_1 = new JMenu("Transaksi");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Penjualan");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransaksiPenjualanView.main();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_2 = new JMenu("Laporan");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Laporan Data Barang");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jrxmlPath = UTS_Gerryron.class.getResource("/RekapitulasiDataBarang.jrxml").getPath();
				jasperDao.showJasperPDF(jrxmlPath);	
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Laporan Penjualan");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jrxmlPath = UTS_Gerryron.class.getResource("/LaporanPenjualan.jrxml").getPath();
				jasperDao.showJasperPDF(jrxmlPath);	
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_3);
	}
}
