package com.gerryron.pertemuan11.DiskusiKetiga;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.gerryron.pertemuan11.DiskusiKetiga.DAO.TransaksiPenjualanDAO;
import com.gerryron.pertemuan11.DiskusiKetiga.Entity.Product;
import com.gerryron.pertemuan11.DiskusiKetiga.Entity.Transaction;
import com.gerryron.pertemuan11.DiskusiKetiga.Model.TransaksiPenjualanTableModel;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import java.awt.SystemColor;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;

public class TransaksiPenjualan {

	private JFrame frmFormTransaksi;
	private JTextField noJualField;
	private JTextField totalBelanjaField;
	private JTextField barangField;
	private JTextField hargaField;
	private JTextField jumlahField;
	private JTextField totalHargaField;
	private JTable table;
	private JTextField keranjangTotalField;
	private JTextField keranjangBayarField;
	private JTextField keranjangKembalianField;
	private JComboBox<String> idBarangCombo;
	private TransaksiPenjualanTableModel tableModel;
	
	private List<Transaction> transactionsTable = new ArrayList<Transaction>();
	private List<Product> products = new ArrayList<Product>();
	private TransaksiPenjualanDAO transaksiDao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransaksiPenjualan window = new TransaksiPenjualan();
					window.frmFormTransaksi.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TransaksiPenjualan() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			transaksiDao = new TransaksiPenjualanDAO();
			products = transaksiDao.getAllProduct();
		} catch (Exception e){
			JOptionPane.showMessageDialog(null, "Error : " + e, "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		frmFormTransaksi = new JFrame();
		frmFormTransaksi.setTitle("Form Transaksi - Gerryron");
		frmFormTransaksi.setBounds(100, 100, 1048, 687);
		frmFormTransaksi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmFormTransaksi.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(0, 0, 1032, 105);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TRANSAKSI PENJUALAN");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 11, 1012, 83);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBounds(0, 109, 1032, 91);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("No Jual");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(34, 11, 72, 23);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tanggal");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(34, 52, 72, 23);
		panel_2.add(lblNewLabel_1_1);
		
		noJualField = new JTextField();
		noJualField.setBounds(106, 12, 123, 20);
		panel_2.add(noJualField);
		noJualField.setColumns(10);
		
		SpinnerDateModel dateModel = new SpinnerDateModel(new Date(), null, null, Calendar.MONTH);
		JSpinner spinner = new JSpinner(dateModel);
		JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinner, "yyyy/MM/dd");
		spinner.setEditor(dateEditor);
		spinner.setBounds(106, 53, 123, 20);
		panel_2.add(spinner);
		
		JLabel lblNewLabel_1_2 = new JLabel("Total");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_2.setBounds(597, 11, 59, 23);
		panel_2.add(lblNewLabel_1_2);
		
		totalBelanjaField = new JTextField();
		totalBelanjaField.setHorizontalAlignment(SwingConstants.RIGHT);
		totalBelanjaField.setFont(new Font("Arial", Font.PLAIN, 40));
		totalBelanjaField.setColumns(10);
		totalBelanjaField.setBounds(657, 11, 365, 64);
		panel_2.add(totalBelanjaField);
		
		JButton btnNewButton = new JButton("Batal");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearAllForm();
				showTable();
			}
		});
		btnNewButton.setBounds(256, 11, 89, 23);
		panel_2.add(btnNewButton);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.activeCaptionBorder);
		panel_3.setBounds(0, 211, 1032, 105);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1_3 = new JLabel("Data Barang");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_3.setBounds(33, 11, 72, 23);
		panel_3.add(lblNewLabel_1_3);
		
		idBarangCombo = new JComboBox<String>();
		idBarangCombo.setBounds(33, 45, 154, 20);
		idBarangCombo.addItem("- Pilih Kode Barang");
		for (Product product : products) {
			idBarangCombo.addItem(product.getKodeBarang());
		}
		idBarangCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idIndex = idBarangCombo.getSelectedIndex();
				if (idIndex != 0) {
					barangField.setText(products.get(idIndex-1).getNamaBarang());
					hargaField.setText(products.get(idIndex-1).getHargaBarang().toString());
				} else {
					barangField.setText("");
					hargaField.setText("");
				}
			}
		});
		panel_3.add(idBarangCombo);
		
		barangField = new JTextField();
		barangField.setEditable(false);
		barangField.setBounds(197, 45, 175, 20);
		panel_3.add(barangField);
		barangField.setColumns(10);
		
		hargaField = new JTextField();
		hargaField.setEditable(false);
		hargaField.setBounds(382, 45, 100, 20);
		panel_3.add(hargaField);
		hargaField.setColumns(10);
		
		jumlahField = new JTextField();
		jumlahField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BigDecimal harga = new BigDecimal(hargaField.getText());
				int jumlah = Integer.parseInt(jumlahField.getText());
				
				totalHargaField.setText(harga.multiply(new BigDecimal(jumlah)).toString());
			}
		});
		jumlahField.setBounds(492, 45, 86, 20);
		panel_3.add(jumlahField);
		jumlahField.setColumns(10);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Jumlah");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_3_1.setBounds(492, 11, 72, 23);
		panel_3.add(lblNewLabel_1_3_1);
		
		totalHargaField = new JTextField();
		totalHargaField.setColumns(10);
		totalHargaField.setBounds(588, 45, 116, 20);
		panel_3.add(totalHargaField);
		
		JButton btnNewButton_1 = new JButton("Tambah Item");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kodeBarang = idBarangCombo.getSelectedItem().toString();
				String namaBarang = barangField.getText();
				BigDecimal hargaBarang = new BigDecimal(hargaField.getText());
				int jumlahBarang = Integer.parseInt(jumlahField.getText());
				BigDecimal totalHargaBarang = new BigDecimal(totalHargaField.getText());
				
				transactionsTable.add(new Transaction(kodeBarang, namaBarang, hargaBarang, jumlahBarang, totalHargaBarang));
				showTable();
				clearForm();
				updateKeranjang();
				JOptionPane.showMessageDialog(null, "Success Tambah Barang", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton_1.setBounds(731, 44, 109, 23);
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Hapus Item");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				transactionsTable.remove(i);
				showTable();
				clearForm();
				updateKeranjang();
				JOptionPane.showMessageDialog(null, "Success Hapus Barang", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton_1_1.setBounds(850, 44, 116, 23);
		panel_3.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("*tekan enter");
		lblNewLabel_2.setBounds(492, 76, 72, 14);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("*tekan enter");
		lblNewLabel_2_1.setBounds(588, 76, 72, 14);
		panel_3.add(lblNewLabel_2_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.menu);
		panel_4.setBounds(0, 327, 1032, 160);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Detail Barang");
		lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_3_2.setBounds(32, 11, 98, 23);
		panel_4.add(lblNewLabel_1_3_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 1012, 106);
		panel_4.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				String kodeBarang = tableModel.getValueAt(i, 0).toString();
				for (Product product : products) {
					if (product.getKodeBarang() == kodeBarang) {
						idBarangCombo.setSelectedItem(product.getKodeBarang());
					}
				}
				barangField.setText(tableModel.getValueAt(i, 1).toString());
				hargaField.setText(tableModel.getValueAt(i, 2).toString());
				jumlahField.setText(tableModel.getValueAt(i, 3).toString());
				totalHargaField.setText(tableModel.getValueAt(i, 4).toString());
			}
		});

		showTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.activeCaption);
		panel_5.setBounds(0, 498, 1032, 139);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("Jumlah");
		lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_3_1_1.setBounds(708, 11, 72, 23);
		panel_5.add(lblNewLabel_1_3_1_1);
		
		JLabel lblNewLabel_1_3_1_2 = new JLabel("Bayar");
		lblNewLabel_1_3_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_3_1_2.setBounds(708, 38, 72, 23);
		panel_5.add(lblNewLabel_1_3_1_2);
		
		JLabel lblNewLabel_1_3_1_3 = new JLabel("Kembalian");
		lblNewLabel_1_3_1_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_3_1_3.setBounds(708, 67, 72, 23);
		panel_5.add(lblNewLabel_1_3_1_3);
		
		keranjangTotalField = new JTextField();
		keranjangTotalField.setEditable(false);
		keranjangTotalField.setBounds(805, 12, 166, 20);
		panel_5.add(keranjangTotalField);
		keranjangTotalField.setColumns(10);
		
		keranjangBayarField = new JTextField();
		keranjangBayarField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BigDecimal total  = new BigDecimal(keranjangTotalField.getText());
				BigDecimal bayar = new BigDecimal(keranjangBayarField.getText());
				
				keranjangKembalianField.setText(total.subtract(bayar).negate().toString());
			}
		});
		keranjangBayarField.setColumns(10);
		keranjangBayarField.setBounds(805, 39, 166, 20);
		panel_5.add(keranjangBayarField);
		
		keranjangKembalianField = new JTextField();
		keranjangKembalianField.setEditable(false);
		keranjangKembalianField.setColumns(10);
		keranjangKembalianField.setBounds(805, 68, 166, 20);
		panel_5.add(keranjangKembalianField);
		
		JButton btnNewButton_2 = new JButton("Simpan");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String noJual = noJualField.getText();
					Date tanggal = (Date)spinner.getValue();
					for (Transaction transaksi : transactionsTable) {
						String kodeBarang = transaksi.getKodeBarang();
						String namaBarang = transaksi.getNamaBarang();
						BigDecimal hargaBarang = transaksi.getHargaBarang();
						int jumlahBarang = transaksi.getJumlahBarang();
						BigDecimal totalHargaBarang = transaksi.getTotalHargaBarang();
						
						Transaction transaction = new Transaction(0, noJual, tanggal, kodeBarang, namaBarang, hargaBarang, jumlahBarang, totalHargaBarang);
						transaksiDao.saveTransaction(transaction);
					}
					JOptionPane.showMessageDialog(null, "Success Saving Transaction : " + noJual, "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
					clearAllForm();
					showTable();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error Saving Transaction : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(767, 99, 89, 23);
		panel_5.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Keluar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pilihan = JOptionPane.showConfirmDialog(null, "apakah anda ingin keluar ?");
				if (pilihan == 0) {
					System.exit(0);
				}
			}
		});
		btnNewButton_3.setBounds(882, 99, 89, 23);
		panel_5.add(btnNewButton_3);
	}
	
	private void showTable() {
		tableModel = new TransaksiPenjualanTableModel(transactionsTable);
		table.setModel(tableModel);
	}
	
	private void clearAllForm() {
		noJualField.setText("");
		totalBelanjaField.setText("");
		keranjangTotalField.setText("");
		keranjangBayarField.setText("");
		keranjangKembalianField.setText("");
		clearForm();
		transactionsTable.clear();
	}
	
	private void clearForm() {
		idBarangCombo.setSelectedIndex(0);
		barangField.setText("");
		hargaField.setText("");
		jumlahField.setText("");
		totalHargaField.setText("");
	}
	
	private void updateKeranjang() {
		BigDecimal totalKeranjang = new BigDecimal(0);
		for (Transaction transaction : transactionsTable) {
			totalKeranjang = totalKeranjang.add(transaction.getTotalHargaBarang());
		}
		totalBelanjaField.setText(totalKeranjang.toString());
		keranjangTotalField.setText(totalKeranjang.toString());
	}
	
}
