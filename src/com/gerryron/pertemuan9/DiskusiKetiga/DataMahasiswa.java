package com.gerryron.pertemuan9.DiskusiKetiga;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import com.gerryron.pertemuan9.DiskusiKetiga.MahasiswaDAO;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class DataMahasiswa {

	private JFrame frmDataMahasiswa;
	private JTextField nimField;
	private JTextField namaField;
	private JTextField nilaiField;
	private JComboBox<String> prodiCombo;
	private JComboBox<String> matkulCombo;
	private JTable table;
	
	private List<Mahasiswa> listMahasiswa = new ArrayList<Mahasiswa>();
	private MahasiswaTableModel tableModel;
	private MahasiswaDAO mahasiswaDao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataMahasiswa window = new DataMahasiswa();
					window.frmDataMahasiswa.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DataMahasiswa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			mahasiswaDao = new MahasiswaDAO();
		} catch (Exception e){
			JOptionPane.showMessageDialog(null, "Error : " + e, "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		frmDataMahasiswa = new JFrame();
		frmDataMahasiswa.setTitle("Data Mahasiswa - Gerryron");
		frmDataMahasiswa.setBounds(100, 100, 732, 414);
		frmDataMahasiswa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmDataMahasiswa.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NIM");
		lblNewLabel.setFont(new Font("Cambria", Font.PLAIN, 16));
		lblNewLabel.setBounds(45, 24, 100, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNama = new JLabel("NAMA");
		lblNama.setFont(new Font("Cambria", Font.PLAIN, 16));
		lblNama.setBounds(45, 54, 100, 14);
		panel.add(lblNama);
		
		JLabel lblProdi = new JLabel("Prodi");
		lblProdi.setFont(new Font("Cambria", Font.PLAIN, 16));
		lblProdi.setBounds(45, 84, 100, 14);
		panel.add(lblProdi);
		
		JLabel lblMataKuliah = new JLabel("Mata Kuliah");
		lblMataKuliah.setFont(new Font("Cambria", Font.PLAIN, 16));
		lblMataKuliah.setBounds(45, 114, 100, 14);
		panel.add(lblMataKuliah);
		
		JLabel lblNilai = new JLabel("Nilai");
		lblNilai.setFont(new Font("Cambria", Font.PLAIN, 16));
		lblNilai.setBounds(45, 144, 100, 14);
		panel.add(lblNilai);
		
		nimField = new JTextField();
		nimField.setBounds(155, 23, 100, 20);
		panel.add(nimField);
		nimField.setColumns(10);
		
		namaField = new JTextField();
		namaField.setColumns(10);
		namaField.setBounds(155, 53, 200, 20);
		panel.add(namaField);
		
		prodiCombo = new JComboBox<String>();
		prodiCombo.setBounds(155, 83, 200, 20);
		prodiCombo.addItem("- Pilih Prodi");
		prodiCombo.addItem("Teknik Informatika");
		prodiCombo.addItem("Sastra Inggris");
		prodiCombo.addItem("Kedokteran");
		prodiCombo.addItem("Ilmu Pemerintahan");
		panel.add(prodiCombo);
		
		matkulCombo = new JComboBox<String>();
		matkulCombo.setBounds(155, 113, 200, 20);
		matkulCombo.addItem("- Pilih Mata Kuliah Wajib");
		matkulCombo.addItem("Bahasa Inggris");
		matkulCombo.addItem("Agama");
		matkulCombo.addItem("Pendidikan Pancasila");
		panel.add(matkulCombo);
		
		nilaiField = new JTextField();
		nilaiField.setColumns(10);
		nilaiField.setBounds(155, 143, 50, 20);
		panel.add(nilaiField);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 186, 562, 118);
		panel.add(scrollPane);
		
		table = new JTable();
		showTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				nimField.setText(tableModel.getValueAt(i, 0).toString());
				namaField.setText(tableModel.getValueAt(i, 1).toString());
				prodiCombo.setSelectedItem(tableModel.getValueAt(i, 2).toString());
				matkulCombo.setSelectedItem(tableModel.getValueAt(i, 3).toString());
				nilaiField.setText(tableModel.getValueAt(i, 4).toString());
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Cari");
		btnNewButton.setBounds(531, 142, 69, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Simpan");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					for(Mahasiswa mahasiswa : listMahasiswa) {
						mahasiswaDao.saveMahasiswa(mahasiswa);
					}
					clearForm();
					listMahasiswa.clear();
					showTable();
					JOptionPane.showMessageDialog(null, "Success Saving Data Mahasiswa", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Error Saving Data Mahasiswa : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_1.setBounds(45, 322, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Edit");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				String nim = nimField.getText();
				String nama = namaField.getText();
				String prodi = prodiCombo.getSelectedItem().toString();
				String matkul = matkulCombo.getSelectedItem().toString();
				int nilai = Integer.parseInt(nilaiField.getText());
				
				Mahasiswa mahasiswa = new Mahasiswa(nim, nama, prodi, matkul, nilai);
				listMahasiswa.set(i, mahasiswa);
				showTable();
				clearForm();
				JOptionPane.showMessageDialog(null, "Success Update Data Mahasiswa", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton_1_1.setBounds(155, 322, 69, 23);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Hapus");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				listMahasiswa.remove(i);
				clearForm();
				showTable();
				JOptionPane.showMessageDialog(null, "Success Delete Data Mahasiswa", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton_1_2.setBounds(250, 322, 78, 23);
		panel.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_2_1 = new JButton("Tutup");
		btnNewButton_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pilihan = JOptionPane.showConfirmDialog(null, "Apakah anda ingin keluar ?", "EXIT", JOptionPane.YES_NO_OPTION);
				if (pilihan == 0) {
					System.exit(0);
				}
			}
		});
		btnNewButton_1_2_1.setBounds(382, 322, 69, 23);
		panel.add(btnNewButton_1_2_1);
		
		JButton btnTambah = new JButton("Tambah");
		btnTambah.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nim = nimField.getText();
				String nama = namaField.getText();
				String prodi = prodiCombo.getSelectedItem().toString();
				String matkul = matkulCombo.getSelectedItem().toString();
				int nilai = Integer.parseInt(nilaiField.getText());
				
				Mahasiswa mahasiswa = new Mahasiswa(nim, nama, prodi, matkul, nilai);
				listMahasiswa.add(mahasiswa);
				showTable();
				clearForm();
				JOptionPane.showMessageDialog(null, "Success Add Data Mahasiswa", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnTambah.setBounds(432, 142, 89, 23);
		panel.add(btnTambah);
	}
	
	private void showTable() {
		tableModel = new MahasiswaTableModel(listMahasiswa);
		table.setModel(tableModel);
	}

	private void clearForm() {
		nimField.setText("");
		namaField.setText("");
		prodiCombo.setSelectedIndex(0);
		matkulCombo.setSelectedIndex(0);
		nilaiField.setText("");
	}
}
