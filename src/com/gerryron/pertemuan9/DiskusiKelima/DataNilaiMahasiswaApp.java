package com.gerryron.pertemuan9.DiskusiKelima;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DataNilaiMahasiswaApp {

	private JFrame frmDataNilaiMahasiswa;
	private JTextField nimField;
	private JTextField namaMahasiswaField;
	private JTextField semesterField;
	private JTextField kehadiranField;
	private JTextField tugasField;
	private JTextField utsField;
	private JTextField uasField;
	private JTable table;
	private JTextField cariField;
	private JComboBox<String> matkulCombo;
	
	private List<DataNilaiMahasiswa> listNilai = new ArrayList<DataNilaiMahasiswa>();
	private DataNilaiMahasiswaTableModel tableModel;
	private DataNilaiMahasiswaDAO dataNilaiDao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataNilaiMahasiswaApp window = new DataNilaiMahasiswaApp();
					window.frmDataNilaiMahasiswa.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DataNilaiMahasiswaApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			dataNilaiDao = new DataNilaiMahasiswaDAO();
		} catch (Exception e){
			JOptionPane.showMessageDialog(null, "Error : " + e, "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		frmDataNilaiMahasiswa = new JFrame();
		frmDataNilaiMahasiswa.setTitle("Data Nilai Mahasiswa App - Gerryron");
		frmDataNilaiMahasiswa.setBounds(100, 100, 678, 500);
		frmDataNilaiMahasiswa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmDataNilaiMahasiswa.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NIM");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(59, 50, 130, 20);
		panel.add(lblNewLabel);
		
		JLabel lblNamaMahasiswa = new JLabel("Nama Mahasiswa");
		lblNamaMahasiswa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNamaMahasiswa.setBounds(59, 80, 130, 20);
		panel.add(lblNamaMahasiswa);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSemester.setBounds(59, 110, 130, 20);
		panel.add(lblSemester);
		
		JLabel lblMataKuliah = new JLabel("Mata Kuliah");
		lblMataKuliah.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMataKuliah.setBounds(59, 140, 130, 20);
		panel.add(lblMataKuliah);
		
		JLabel lblKehadiran = new JLabel("Kehadiran");
		lblKehadiran.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKehadiran.setBounds(59, 170, 130, 20);
		panel.add(lblKehadiran);
		
		nimField = new JTextField();
		nimField.setBounds(196, 52, 170, 20);
		panel.add(nimField);
		nimField.setColumns(10);
		
		namaMahasiswaField = new JTextField();
		namaMahasiswaField.setColumns(10);
		namaMahasiswaField.setBounds(196, 82, 170, 20);
		panel.add(namaMahasiswaField);
		
		semesterField = new JTextField();
		semesterField.setColumns(10);
		semesterField.setBounds(196, 112, 50, 20);
		panel.add(semesterField);
		
		kehadiranField = new JTextField();
		kehadiranField.setColumns(10);
		kehadiranField.setBounds(196, 172, 50, 20);
		panel.add(kehadiranField);
		
		matkulCombo = new JComboBox<String>();
		matkulCombo.setBounds(196, 142, 170, 20);
		matkulCombo.addItem("- Pilih Mata Kuliah");
		matkulCombo.addItem("Arsitektur dan Organisasi");
		matkulCombo.addItem("Pemrograman 2");
		matkulCombo.addItem("Basis Data 2");
		matkulCombo.addItem("Praktikum Basis Data");
		panel.add(matkulCombo);
		
		JLabel lblNilai = new JLabel("Nilai");
		lblNilai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNilai.setBounds(441, 85, 130, 20);
		panel.add(lblNilai);
		
		JLabel lblTugas = new JLabel("Tugas");
		lblTugas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTugas.setBounds(466, 115, 67, 20);
		panel.add(lblTugas);
		
		JLabel lblNilai_1_1 = new JLabel("UTS");
		lblNilai_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNilai_1_1.setBounds(466, 145, 67, 20);
		panel.add(lblNilai_1_1);
		
		JLabel lblNilai_1_2 = new JLabel("UAS");
		lblNilai_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNilai_1_2.setBounds(466, 175, 67, 20);
		panel.add(lblNilai_1_2);
		
		tugasField = new JTextField();
		tugasField.setColumns(10);
		tugasField.setBounds(540, 117, 50, 20);
		panel.add(tugasField);
		
		utsField = new JTextField();
		utsField.setColumns(10);
		utsField.setBounds(540, 145, 50, 20);
		panel.add(utsField);
		
		uasField = new JTextField();
		uasField.setColumns(10);
		uasField.setBounds(540, 175, 50, 20);
		panel.add(uasField);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 215, 642, 124);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				nimField.setText(tableModel.getValueAt(i, 0).toString());
				namaMahasiswaField.setText(tableModel.getValueAt(i, 1).toString());
				semesterField.setText(tableModel.getValueAt(i, 2).toString());
				matkulCombo.setSelectedItem(tableModel.getValueAt(i, 3).toString());
				kehadiranField.setText(tableModel.getValueAt(i, 4).toString());
				tugasField.setText(tableModel.getValueAt(i, 5).toString());
				utsField.setText(tableModel.getValueAt(i, 6).toString());
				uasField.setText(tableModel.getValueAt(i, 7).toString());
			}
		});
		showTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Tambah");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nim = nimField.getText();
					String namaMahasiswa = namaMahasiswaField.getText();
					int semester = Integer.parseInt(semesterField.getText());
					String matkul = matkulCombo.getSelectedItem().toString();
					int kehadiran = Integer.parseInt(kehadiranField.getText());
					int tugas = Integer.parseInt(tugasField.getText());
					int uts = Integer.parseInt(utsField.getText());
					int uas = Integer.parseInt(uasField.getText());
					
					DataNilaiMahasiswa dataNilai = new DataNilaiMahasiswa(nim, namaMahasiswa, semester, matkul, kehadiran, tugas, uts, uas);
					listNilai.add(dataNilai);
					showTable();
					clearForm();
					JOptionPane.showMessageDialog(null, "Success Tambah Data Nilai Mahasiswa", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error : " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(10, 350, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnHapus = new JButton("Hapus");
		btnHapus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				listNilai.remove(i);
				clearForm();
				showTable();
				JOptionPane.showMessageDialog(null, "Success Hapus Data Nilai Mahasiswa", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnHapus.setBounds(109, 350, 77, 23);
		panel.add(btnHapus);
		
		JButton btnUbah = new JButton("Ubah");
		btnUbah.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				String nim = nimField.getText();
				String namaMahasiswa = namaMahasiswaField.getText();
				int semester = Integer.parseInt(semesterField.getText());
				String matkul = matkulCombo.getSelectedItem().toString();
				int kehadiran = Integer.parseInt(kehadiranField.getText());
				int tugas = Integer.parseInt(tugasField.getText());
				int uts = Integer.parseInt(utsField.getText());
				int uas = Integer.parseInt(uasField.getText());
				
				DataNilaiMahasiswa dataNilai = new DataNilaiMahasiswa(nim, namaMahasiswa, semester, matkul, kehadiran, tugas, uts, uas);
				listNilai.set(i,dataNilai);
				showTable();
				clearForm();
				JOptionPane.showMessageDialog(null, "Success Ubah Data Nilai Mahasiswa", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnUbah.setBounds(196, 350, 67, 23);
		panel.add(btnUbah);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					for (DataNilaiMahasiswa dataNilai : listNilai) {
						dataNilaiDao.saveDataNilaiMahasiswa(dataNilai);
					}
					listNilai.clear();
					clearForm();
					showTable();
					JOptionPane.showMessageDialog(null, "Success Insert Data Nilai Mahasiswa", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error Insert Data Nilai Mahasiswa : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnInsert.setBounds(273, 350, 77, 23);
		panel.add(btnInsert);
		
		JButton btnCari = new JButton("Cari");
		btnCari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String pencarian = cariField.getText();
					List<DataNilaiMahasiswa> dataNilai = dataNilaiDao.getDataNilaiMahasiswaByNIM(pencarian);
					if (dataNilai.isEmpty() || dataNilai == null) {
						JOptionPane.showMessageDialog(null, "Data yang dicari tidak ada, tolong masukkan NIM", "INFO", JOptionPane.INFORMATION_MESSAGE);
					}
					tableModel = new DataNilaiMahasiswaTableModel(dataNilai);
					table.setModel(tableModel);
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error Cari Data Nilai Mahasiswa : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCari.setBounds(423, 350, 67, 23);
		panel.add(btnCari);
		
		cariField = new JTextField();
		cariField.setColumns(10);
		cariField.setBounds(500, 351, 152, 20);
		panel.add(cariField);
		
		JButton btnKeluar = new JButton("KELUAR");
		btnKeluar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pilihan = JOptionPane.showConfirmDialog(null, "Apakah anda ingin keluar ?", "EXIT", JOptionPane.YES_NO_OPTION);
				if (pilihan == 0) {
					System.exit(0);
				}
			}
		});
		btnKeluar.setBounds(10, 395, 642, 38);
		panel.add(btnKeluar);
	}
	
	private void showTable() {
		tableModel = new DataNilaiMahasiswaTableModel(listNilai);
		table.setModel(tableModel);
	}
	
	private void clearForm() {
		nimField.setText("");
		namaMahasiswaField.setText("");
		semesterField.setText("");
		matkulCombo.setSelectedIndex(0);
		kehadiranField.setText("");
		tugasField.setText("");
		utsField.setText("");
		uasField.setText("");
	}
	
}
