package com.gerryron.UTS.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.awt.Color;
import javax.swing.SwingConstants;

import com.gerryron.UTS.DAO.DataBarangDAO;
import com.gerryron.UTS.Entity.DataBarang;
import com.gerryron.UTS.Model.DataBarangTableModel;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;

public class DataBarangView {

	private JFrame frmDataBarang;
	private JTextField searchField;
	private JTextField kodeField;
	private JTextField namaBarangField;
	private JTextField jumlahField;
	private JTextField hargaBeliField;
	private JTextField hargaJualField;
	private JComboBox<String> jenisCombo;
	private JTable table;
	
	private List<DataBarang> listBarang = new ArrayList<DataBarang>();
	private DataBarangDAO dataBarangDAO;
	private DataBarangTableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataBarangView window = new DataBarangView();
					window.frmDataBarang.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DataBarangView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			dataBarangDAO = new DataBarangDAO();
		} catch (Exception e){
			JOptionPane.showMessageDialog(null, "Error : " + e, "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		frmDataBarang = new JFrame();
		frmDataBarang.setResizable(false);
		frmDataBarang.setTitle("Data Barang");
		frmDataBarang.setBounds(100, 100, 694, 670);
		frmDataBarang.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmDataBarang.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Toko");
		lblNewLabel.setForeground(Color.MAGENTA);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 46, 16);
		panel.add(lblNewLabel);
		
		JLabel lbljayaAbadi = new JLabel("\"Jaya Abadi\"");
		lbljayaAbadi.setForeground(Color.BLUE);
		lbljayaAbadi.setFont(new Font("Arial", Font.PLAIN, 14));
		lbljayaAbadi.setBounds(48, 11, 88, 16);
		panel.add(lbljayaAbadi);
		
		JLabel lblNewLabel_1 = new JLabel("Data Barang");
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(10, 59, 659, 22);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cari Berdasarkan Nama");
		lblNewLabel_2.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
		lblNewLabel_2.setForeground(new Color(50, 205, 50));
		lblNewLabel_2.setBounds(244, 92, 158, 22);
		panel.add(lblNewLabel_2);
		
		searchField = new JTextField();
		searchField.setBounds(244, 125, 166, 23);
		searchField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					try {
						String namaBarang = searchField.getText();
						List<DataBarang> listBarang = dataBarangDAO.getDataBarangByNama(namaBarang);
						tableModel = new DataBarangTableModel(listBarang);
						table.setModel(tableModel);
						if (listBarang.isEmpty() || listBarang == null) {
							JOptionPane.showMessageDialog(null, "Data yang dicari tidak ada", "Info", JOptionPane.INFORMATION_MESSAGE);
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Error : " + ex, "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		panel.add(searchField);
		searchField.setColumns(10);
		
		kodeField = new JTextField();
		kodeField.setColumns(10);
		kodeField.setBounds(244, 160, 75, 23);
		panel.add(kodeField);
		
		namaBarangField = new JTextField();
		namaBarangField.setColumns(10);
		namaBarangField.setBounds(244, 195, 166, 23);
		panel.add(namaBarangField);
		
		jumlahField = new JTextField();
		jumlahField.setColumns(10);
		jumlahField.setBounds(244, 265, 166, 23);
		panel.add(jumlahField);
		
		hargaBeliField = new JTextField();
		hargaBeliField.setColumns(10);
		hargaBeliField.setBounds(244, 300, 166, 23);
		panel.add(hargaBeliField);
		
		hargaJualField = new JTextField();
		hargaJualField.setColumns(10);
		hargaJualField.setBounds(244, 335, 166, 23);
		panel.add(hargaJualField);
		
		jenisCombo = new JComboBox<String>();
		jenisCombo.setBounds(244, 230, 75, 23);
		jenisCombo.addItem("- Pilih");
		jenisCombo.addItem("Kg");
		jenisCombo.addItem("Botol");
		jenisCombo.addItem("Liter");
		jenisCombo.addItem("Sachet");
		jenisCombo.addItem("Kaleng");
		panel.add(jenisCombo);
		
		JLabel lblNewLabel_3 = new JLabel("Kode");
		lblNewLabel_3.setBounds(144, 165, 90, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Nama Barang");
		lblNewLabel_3_1.setBounds(144, 199, 90, 14);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Jenis");
		lblNewLabel_3_2.setBounds(144, 234, 90, 14);
		panel.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Jumlah");
		lblNewLabel_3_3.setBounds(144, 269, 90, 14);
		panel.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_3_1 = new JLabel("Harga Beli");
		lblNewLabel_3_3_1.setBounds(144, 304, 90, 14);
		panel.add(lblNewLabel_3_3_1);
		
		JLabel lblNewLabel_3_3_1_1 = new JLabel("Harga Jual");
		lblNewLabel_3_3_1_1.setBounds(144, 339, 90, 14);
		panel.add(lblNewLabel_3_3_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 377, 659, 133);
		panel.add(scrollPane);
		
		table = new JTable();
		showTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				kodeField.setText(tableModel.getValueAt(i, 0).toString());
				namaBarangField.setText(tableModel.getValueAt(i, 1).toString());
				jenisCombo.setSelectedItem(tableModel.getValueAt(i, 2).toString());
				jumlahField.setText(tableModel.getValueAt(i, 3).toString());
				hargaBeliField.setText(tableModel.getValueAt(i, 4).toString());
				hargaJualField.setText(tableModel.getValueAt(i, 5).toString());
			}
		});
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 255, 255));
		panel_1.setBounds(10, 535, 659, 48);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Tambah");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kodeBarang = kodeField.getText();
				String namaBarang = namaBarangField.getText();
				String jenisBarang = jenisCombo.getSelectedItem().toString();
				BigDecimal jumlah = new BigDecimal(jumlahField.getText());
				BigDecimal pembelian = new BigDecimal(hargaBeliField.getText());
				BigDecimal penjualan = new BigDecimal(hargaJualField.getText());
				
				DataBarang dataBarang = new DataBarang(kodeBarang, namaBarang, jenisBarang, jumlah, pembelian, penjualan);
				listBarang.add(dataBarang);
				showTable();
				clearForm();
				JOptionPane.showMessageDialog(null, "Success Tambah Data Barang", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		Image img = new ImageIcon(this.getClass().getResource("/plus.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.setBounds(10, 11, 104, 23);
		panel_1.add(btnNewButton);
		
		JButton btnSimpan = new JButton("Simpan");
		btnSimpan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					for (DataBarang dataBarang : listBarang) {
						dataBarangDAO.saveDataBarang(dataBarang);
					}
					listBarang.clear();
					clearForm();
					showTable();
					JOptionPane.showMessageDialog(null, "Success Simpan Data Barang ke DB", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error Simpan Data Barang ke DB" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		Image img2 = new ImageIcon(this.getClass().getResource("/floppy-disk.png")).getImage();
		btnSimpan.setIcon(new ImageIcon(img2));
		btnSimpan.setBounds(124, 11, 97, 23);
		panel_1.add(btnSimpan);
		
		JButton btnNewButton_1_1 = new JButton("Ubah");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				String kodeBarang = kodeField.getText();
				String namaBarang = namaBarangField.getText();
				String jenisBarang = jenisCombo.getSelectedItem().toString();
				BigDecimal jumlah = new BigDecimal(jumlahField.getText());
				BigDecimal pembelian = new BigDecimal(hargaBeliField.getText());
				BigDecimal penjualan = new BigDecimal(hargaJualField.getText());
				
				DataBarang dataBarang = new DataBarang(kodeBarang, namaBarang, jenisBarang, jumlah, pembelian, penjualan);
				listBarang.set(i, dataBarang);
				showTable();
				clearForm();
				JOptionPane.showMessageDialog(null, "Success Ubah Data Barang", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		Image img3 = new ImageIcon(this.getClass().getResource("/updated.png")).getImage();
		btnNewButton_1_1.setIcon(new ImageIcon(img3));
		btnNewButton_1_1.setBounds(231, 11, 89, 23);
		panel_1.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Hapus");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				listBarang.remove(i);
				clearForm();
				showTable();
				JOptionPane.showMessageDialog(null, "Success Hapus Data Barang", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		Image img4 = new ImageIcon(this.getClass().getResource("/delete.png")).getImage();
		btnNewButton_1_1_1.setIcon(new ImageIcon(img4));
		btnNewButton_1_1_1.setBounds(330, 11, 97, 23);
		panel_1.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Batal");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pilihan = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin batalkan data?", "Batalkan ?", JOptionPane.YES_NO_OPTION);
				if (pilihan == 0) {
					listBarang.clear();
					clearForm();
					showTable();
				}	
			}
		});
		Image img5 = new ImageIcon(this.getClass().getResource("/clear.png")).getImage();
		btnNewButton_1_1_1_1.setIcon(new ImageIcon(img5));
		btnNewButton_1_1_1_1.setBounds(437, 11, 89, 23);
		panel_1.add(btnNewButton_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1_1 = new JButton("Keluar");
		btnNewButton_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pilihan = JOptionPane.showConfirmDialog(null, "apakah anda ingin menutup halaman ?", "Keluar ?", JOptionPane.YES_NO_OPTION);
				if (pilihan == 0) {
					frmDataBarang.dispose();
				}
			}
		});
		Image img6 = new ImageIcon(this.getClass().getResource("/logout.png")).getImage();
		btnNewButton_1_1_1_1_1.setIcon(new ImageIcon(img6));
		btnNewButton_1_1_1_1_1.setBounds(552, 11, 97, 23);
		panel_1.add(btnNewButton_1_1_1_1_1);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEEE, dd MMMM yyyy        hh:mm:ss", new Locale("id", "ID"));
		String currDate = dateFormat.format(new Date());
		JLabel lblNewLabel_4 = new JLabel(currDate);
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(429, 594, 228, 14);
		panel.add(lblNewLabel_4);
	}
	
	private void showTable() {
		tableModel = new DataBarangTableModel(listBarang);
		table.setModel(tableModel);
	}
	
	private void clearForm() {
		searchField.setText("");
		kodeField.setText("");
		namaBarangField.setText("");
		jumlahField.setText("");
		hargaBeliField.setText("");
		hargaJualField.setText("");
		jenisCombo.setSelectedIndex(0);;
	}
	
}
