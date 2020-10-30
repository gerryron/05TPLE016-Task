package com.gerryron.pertemuan9.DiskusiKeempat;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class InputBarangApp {

	private JFrame frmInputBarangApp;
	private JTextField idBarangField;
	private JTextField namaBarangField;
	private JComboBox<String> kategoriCombo;
	private JTable table;
	
	private List<Barang> listBarang = new ArrayList<Barang>();
	private BarangDAO barangDao;
	private BarangTableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InputBarangApp window = new InputBarangApp();
					window.frmInputBarangApp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InputBarangApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			barangDao = new BarangDAO();
		} catch (Exception e){
			JOptionPane.showMessageDialog(null, "Error : " + e, "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		frmInputBarangApp = new JFrame();
		frmInputBarangApp.setTitle("Input Barang App - Gerryron");
		frmInputBarangApp.setBounds(100, 100, 619, 502);
		frmInputBarangApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 250));
		frmInputBarangApp.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 583, 71);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Input Barang");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 563, 49);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID Barang");
		lblNewLabel_1.setFont(new Font("Cambria", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(50, 115, 100, 18);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Kategori");
		lblNewLabel_1_1.setFont(new Font("Cambria", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(50, 145, 100, 18);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nama Barang");
		lblNewLabel_1_2.setFont(new Font("Cambria", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(50, 175, 100, 18);
		panel.add(lblNewLabel_1_2);
		
		idBarangField = new JTextField();
		idBarangField.setBounds(160, 116, 250, 20);
		panel.add(idBarangField);
		idBarangField.setColumns(10);
		
		namaBarangField = new JTextField();
		namaBarangField.setColumns(10);
		namaBarangField.setBounds(160, 176, 250, 20);
		panel.add(namaBarangField);
		
		kategoriCombo = new JComboBox<String>();
		kategoriCombo.setBounds(160, 146, 250, 20);
		kategoriCombo.addItem("- Pilih Kategori");
		kategoriCombo.addItem("Makanan");
		kategoriCombo.addItem("Minuman");
		kategoriCombo.addItem("Kebutuhan rumah tangga");
		panel.add(kategoriCombo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 233, 583, 149);
		panel.add(scrollPane);
		
		table = new JTable();
		showTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				idBarangField.setText(tableModel.getValueAt(i, 0).toString());
				kategoriCombo.setSelectedItem(tableModel.getValueAt(i, 1).toString());
				namaBarangField.setText(tableModel.getValueAt(i, 2).toString());
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pilihan = JOptionPane.showConfirmDialog(null, "Apakah anda ingin keluar ?", "EXIT", JOptionPane.YES_NO_OPTION);
				if (pilihan == 0) {
					System.exit(0);
				}
			}
		});
		btnNewButton.setBounds(10, 405, 65, 23);
		panel.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pilih = JOptionPane.showConfirmDialog(null, "Apakah anda ingin membatalkan belanja ?", "Batal ?", JOptionPane.YES_NO_OPTION);
				if (pilih == 0) {
					clearForm();
					listBarang.clear();
					showTable();
					JOptionPane.showMessageDialog(null, "Batalkan Belanja", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnCancel.setBounds(517, 405, 76, 23);
		panel.add(btnCancel);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				listBarang.remove(i);
				clearForm();
				showTable();
				JOptionPane.showMessageDialog(null, "Success Hapus Data Barang", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnDelete.setBounds(431, 405, 76, 23);
		panel.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				int idBarang = Integer.parseInt(idBarangField.getText());
				String kategori = kategoriCombo.getSelectedItem().toString();
				String namaBarang = namaBarangField.getText();
				
				Barang barang = new Barang(idBarang, kategori, namaBarang);
				listBarang.set(i, barang);
				clearForm();
				showTable();
				JOptionPane.showMessageDialog(null, "Success Ubah Data Barang", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnUpdate.setBounds(345, 405, 76, 23);
		panel.add(btnUpdate);
		
		JButton btnInsertt = new JButton("Insert");
		btnInsertt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					for (Barang barang : listBarang) {
						barangDao.saveBarang(barang);
					}
					clearForm();
					listBarang.clear();
					showTable();
					JOptionPane.showMessageDialog(null, "Success Simpan Data Barang", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Error Simpan Data Barang : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}		
			}
		});
		btnInsertt.setBounds(259, 405, 76, 23);
		panel.add(btnInsertt);
		
		JButton btnTambah = new JButton("Tambah");
		btnTambah.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idBarang = Integer.parseInt(idBarangField.getText());
				String kategori = kategoriCombo.getSelectedItem().toString();
				String namaBarang = namaBarangField.getText();
				
				Barang barang = new Barang(idBarang, kategori, namaBarang);
				listBarang.add(barang);
				showTable();
				clearForm();
				JOptionPane.showMessageDialog(null, "Success Tambah Data Barang", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnTambah.setBounds(499, 199, 94, 23);
		panel.add(btnTambah);
	}
	
	private void showTable() {
		tableModel = new BarangTableModel(listBarang);
		table.setModel(tableModel);
	}
	
	private void clearForm() {
		idBarangField.setText("");
		kategoriCombo.setSelectedIndex(0);
		namaBarangField.setText("");
	}
	
}
