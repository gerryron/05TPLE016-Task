package com.gerryron.pertemuan11.DiskusiPertama;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;

public class DataIPMahasiswa {

	private JFrame frmDiskusiPertama;
	private JTextField nimField;
	private JTextField namaField;
	private JTextField ipField;
	private JTextField emailField;
	private JTextField telpField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataIPMahasiswa window = new DataIPMahasiswa();
					window.frmDiskusiPertama.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DataIPMahasiswa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDiskusiPertama = new JFrame();
		frmDiskusiPertama.setTitle("Diskusi Pertama - Gerryron");
		frmDiskusiPertama.setBounds(100, 100, 799, 552);
		frmDiskusiPertama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmDiskusiPertama.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DATA INDEX PRESTASI MAHASISWA");
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 22, 763, 27);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NIM");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(161, 73, 134, 27);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("NAMA");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(161, 116, 134, 27);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("PRODI");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(161, 156, 134, 27);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("INDEX PRESTASI");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(161, 196, 134, 27);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("EMAIL");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_4.setBounds(161, 236, 134, 27);
		panel.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("TELP.");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_5.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_5.setBounds(161, 276, 134, 27);
		panel.add(lblNewLabel_1_5);
		
		nimField = new JTextField();
		nimField.setBounds(324, 76, 189, 23);
		panel.add(nimField);
		nimField.setColumns(10);
		
		namaField = new JTextField();
		namaField.setColumns(10);
		namaField.setBounds(324, 120, 189, 23);
		panel.add(namaField);
		
		ipField = new JTextField();
		ipField.setColumns(10);
		ipField.setBounds(324, 200, 189, 23);
		panel.add(ipField);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(324, 240, 189, 23);
		panel.add(emailField);
		
		telpField = new JTextField();
		telpField.setColumns(10);
		telpField.setBounds(324, 280, 189, 23);
		panel.add(telpField);
		
		JComboBox prodiCombo = new JComboBox();
		prodiCombo.setBounds(324, 160, 189, 23);
		panel.add(prodiCombo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 354, 717, 148);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("TAMBAH DATA");
		btnNewButton.setBounds(63, 320, 119, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SIMPAN DATA");
		btnNewButton_1.setBounds(192, 320, 113, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("EDIT");
		btnNewButton_2.setBounds(315, 320, 65, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("HAPUS");
		btnNewButton_3.setBounds(390, 320, 77, 23);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("KELUAR");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pilihan = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin keluar ?");
				if (pilihan == 0) {
					System.exit(0);
				}	
			}
		});
		btnNewButton_4.setBounds(668, 320, 83, 23);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("BATAL");
		btnNewButton_5.setBounds(477, 320, 77, 23);
		panel.add(btnNewButton_5);
	}
}
