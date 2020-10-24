package com.gerryron.pertemuan7;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DiskusiKetiga {

	private JFrame frmDiskusiKetiga;
	private JTextField nim;
	private JTextField nama;
	private JTextField nilai;
	private JTable table;
	DefaultTableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiskusiKetiga window = new DiskusiKetiga();
					window.frmDiskusiKetiga.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DiskusiKetiga() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDiskusiKetiga = new JFrame();
		frmDiskusiKetiga.setTitle("Diskusi Ketiga - Gerryron");
		frmDiskusiKetiga.setBounds(100, 100, 621, 460);
		frmDiskusiKetiga.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmDiskusiKetiga.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NIM");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(50, 39, 74, 24);
		panel.add(lblNewLabel);
		
		JLabel lblNama = new JLabel("Nama");
		lblNama.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNama.setBounds(50, 79, 74, 24);
		panel.add(lblNama);
		
		JLabel lblProdi = new JLabel("Prodi");
		lblProdi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblProdi.setBounds(50, 119, 74, 24);
		panel.add(lblProdi);
		
		JLabel lblMataKuliah = new JLabel("Mata Kuliah");
		lblMataKuliah.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMataKuliah.setBounds(50, 159, 74, 24);
		panel.add(lblMataKuliah);
		
		JLabel lblNilai = new JLabel("Nilai");
		lblNilai.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNilai.setBounds(50, 199, 74, 24);
		panel.add(lblNilai);
		
		nim = new JTextField();
		nim.setBounds(170, 42, 150, 20);
		panel.add(nim);
		nim.setColumns(10);
		
		nama = new JTextField();
		nama.setColumns(10);
		nama.setBounds(170, 82, 180, 20);
		panel.add(nama);
		
		JComboBox prodi = new JComboBox();
		prodi.addItem("-- pilih --");
		prodi.addItem("Manajemen");
		prodi.addItem("Hukum");
		prodi.addItem("Teknik Elektro");
		prodi.addItem("Teknik Informatika");
		prodi.addItem("Sosiologi");
		prodi.addItem("Sastra Inggris");
		prodi.addItem("Hubungan Masyarakat");
		prodi.addItem("Ilmu Keperawatan");
		prodi.addItem("Matematika");
		prodi.addItem("Fisika");
		prodi.setBounds(170, 122, 180, 20);
		panel.add(prodi);
		
		JComboBox matkul = new JComboBox();
		matkul.addItem("-- pilih --");
		matkul.addItem("Bahasa Indonesia");
		matkul.addItem("Pendidikan Pancasila");
		matkul.addItem("Pendidikan Kewarganegaraan");
		matkul.addItem("Pendidikan Agama");
		matkul.setBounds(170, 162, 180, 20);
		panel.add(matkul);
		
		nilai = new JTextField();
		nilai.setBounds(170, 202, 86, 20);
		panel.add(nilai);
		nilai.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 244, 498, 90);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				nim.setText(tableModel.getValueAt(i, 0).toString());
				nama.setText(tableModel.getValueAt(i, 1).toString());
				prodi.setSelectedItem(tableModel.getValueAt(i, 2).toString());
				matkul.setSelectedItem(tableModel.getValueAt(i, 3).toString());
				nilai.setText(tableModel.getValueAt(i, 4).toString());
			}
		});
		tableModel = new DefaultTableModel();
		Object[] column = {"NIM", "Nama", "Prodi", "MataKuliah", "Nilai"};
		Object[] row = new Object[5];
		tableModel.setColumnIdentifiers(column);
		table.setModel(tableModel);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Simpan");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nim.getText().equals("") || nama.getText().equals("") || nilai.getText().equals("") || prodi.getSelectedIndex() == 0 || matkul.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "Gagal menyimpan data : tolong lengkapi informasi");
				} else {
					row[0] = nim.getText();
					row[1] = nama.getText();
					row[2] = prodi.getSelectedItem();
					row[3] = matkul.getSelectedItem();
					row[4] = nilai.getText();
					tableModel.addRow(row);
					
					clearRow();
					prodi.setSelectedIndex(0);
					matkul.setSelectedIndex(0);
					JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
				}
			}
		});
		btnNewButton.setBounds(50, 352, 74, 25);
		panel.add(btnNewButton);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				tableModel.setValueAt(nim.getText(), i, 0);
				tableModel.setValueAt(nama.getText(), i, 1);
				tableModel.setValueAt(prodi.getSelectedItem(), i, 2);
				tableModel.setValueAt(matkul.getSelectedItem(), i, 3);
				tableModel.setValueAt(nilai.getText(), i, 4);
				JOptionPane.showMessageDialog(null, "Data berhasil diubah");
			}
		});
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnEdit.setBounds(150, 352, 74, 25);
		panel.add(btnEdit);
		
		JButton btnHapus = new JButton("Hapus");
		btnHapus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if (i>=0) {
					tableModel.removeRow(i);
					JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
				} else {
					JOptionPane.showMessageDialog(null, "Gagal menghapus data : tolong pilih baris yang ingin dihapus");
				}
			}
		});
		btnHapus.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnHapus.setBounds(250, 353, 74, 25);
		panel.add(btnHapus);
		
		JButton btnTutup = new JButton("Tutup");
		btnTutup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnTutup.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnTutup.setBounds(350, 353, 74, 25);
		panel.add(btnTutup);
		
		JButton btnCari = new JButton("Cari");
		btnCari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i=0; i<tableModel.getRowCount(); i++) {
					if (
						nim.getText().equalsIgnoreCase((String) tableModel.getValueAt(i, 0)) ||
						nama.getText().equalsIgnoreCase((String) tableModel.getValueAt(i, 0))
					) {
						JOptionPane.showMessageDialog(null, "Data yang dicari tersedia");
					} else {
						JOptionPane.showMessageDialog(null, "Gagal menemukan data yang dicari");
					}
				}
			}
		});
		btnCari.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCari.setBounds(488, 200, 60, 25);
		panel.add(btnCari);
	}
	
	private void clearRow() {
		nim.setText("");
		nama.setText("");
		nilai.setText("");
	}
}
