package com.gerryron.pertemuan7.DiskusiKeempat;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class DetailMenu {

	private JFrame frame;
	private JTextField keterangan;
	private JTextField nama;
	private JTextField nim;
	private JTextField tugas;
	private JTextField uts;
	private JTextField uas;
	private JTextField hasil;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetailMenu window = new DetailMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DetailMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 469, 547);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nama");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(50, 57, 100, 25);
		panel.add(lblNewLabel);
		
		JLabel lblNim = new JLabel("NIM");
		lblNim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNim.setBounds(50, 97, 100, 25);
		panel.add(lblNim);
		
		JLabel lblNilaiTugas = new JLabel("Nilai Tugas");
		lblNilaiTugas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNilaiTugas.setBounds(50, 137, 100, 25);
		panel.add(lblNilaiTugas);
		
		JLabel lblNewLabel_3 = new JLabel("Nilai UTS");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(50, 177, 100, 25);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nilai UAS");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(50, 217, 100, 25);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Hasil");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1.setBounds(50, 267, 100, 25);
		panel.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Keterangan");
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1_1.setBounds(50, 341, 100, 25);
		panel.add(lblNewLabel_4_1_1);
		
		keterangan = new JTextField();
		keterangan.setHorizontalAlignment(SwingConstants.CENTER);
		keterangan.setEditable(false);
		keterangan.setBounds(50, 370, 352, 25);
		panel.add(keterangan);
		keterangan.setColumns(10);
		
		nama = new JTextField();
		nama.setBounds(155, 61, 247, 20);
		panel.add(nama);
		nama.setColumns(10);
		
		nim = new JTextField();
		nim.setColumns(10);
		nim.setBounds(155, 101, 247, 20);
		panel.add(nim);
		
		tugas = new JTextField();
		tugas.setBounds(155, 141, 86, 20);
		panel.add(tugas);
		tugas.setColumns(10);
		
		uts = new JTextField();
		uts.setColumns(10);
		uts.setBounds(155, 181, 86, 20);
		panel.add(uts);
		
		uas = new JTextField();
		uas.setColumns(10);
		uas.setBounds(155, 221, 86, 20);
		panel.add(uas);
		
		hasil = new JTextField();
		hasil.setEditable(false);
		hasil.setColumns(10);
		hasil.setBounds(155, 271, 86, 20);
		panel.add(hasil);
		
		JButton btnNewButton = new JButton("OKE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int nilai1 = Integer.parseInt(tugas.getText());
				int nilai2 = Integer.parseInt(uts.getText());
				int nilai3 = Integer.parseInt(uas.getText());
				float numHasil = (nilai1+nilai2+nilai3)/3;
				
				NumberFormat formatter = new DecimalFormat("#0.00");     
				hasil.setText(formatter.format(numHasil));
				
				if (numHasil >= 80) {
					keterangan.setText("Lanjut");
				}else if (numHasil >=70) {
					keterangan.setText("Melakukan Pengulangan");
				}else keterangan.setText("Belum Lulus");
			}
		});
		btnNewButton.setBounds(297, 220, 67, 35);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Keluar");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(83, 428, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Bersih");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nama.setText("");
				nim.setText("");
				tugas.setText("");
				uts.setText("");
				uas.setText("");
				hasil.setText("");
				keterangan.setText("");
			}
		});
		btnNewButton_2.setBounds(251, 428, 89, 23);
		panel.add(btnNewButton_2);
		frame.setVisible(true);
	}
}
