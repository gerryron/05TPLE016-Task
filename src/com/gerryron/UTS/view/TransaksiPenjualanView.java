package com.gerryron.UTS.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;

import com.gerryron.UTS.DAO.DataBarangDAO;
import com.gerryron.UTS.DAO.DataPenjualanDAO;
import com.gerryron.UTS.DAO.JasperDAO;
import com.gerryron.UTS.Entity.DataBarang;
import com.gerryron.UTS.Entity.DataPenjualan;
import com.gerryron.UTS.Model.TransaksiPenjualan;
import com.gerryron.UTS.Model.TransaksiPenjualanTableModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class TransaksiPenjualanView {

	private JFrame frmTransaksiPenjualan;
	private JTextField kodeField;
	private JTextField namaField;
	private JTextField totalBayarField;
	private JTextField bayarField;
	private JTextField kembalianField;
	private JLabel lblNote;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField noteField;
	private JTextField barangField;
	private JTextField hargaField;
	private JTextField jumlahField;
	private JTextField potonganField;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JTextField totalField;
	private JTextField subTotalField;
	private JTextField persentaseField;
	private JTextField jenisField;
	private JDateChooser tanggalChooser;
	private JComboBox<String> kodeBarangCombo;
	private JTable table;
	
	private List<TransaksiPenjualan> listTransaksi = new ArrayList<TransaksiPenjualan>();
	private List<DataBarang> listBarang = new ArrayList<DataBarang>();
	private TransaksiPenjualanTableModel tableModel;
	private DataPenjualanDAO dataPenjualanDao;
	private DataBarangDAO dataBarangDao;
	private JasperDAO jasperDao;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransaksiPenjualanView window = new TransaksiPenjualanView();
					window.frmTransaksiPenjualan.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TransaksiPenjualanView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			dataPenjualanDao = new DataPenjualanDAO();
			jasperDao = new JasperDAO();
			dataBarangDao = new DataBarangDAO();
			listBarang = dataBarangDao.getAllDataBarang();
		} catch (Exception e){
			JOptionPane.showMessageDialog(null, "Error : " + e, "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		frmTransaksiPenjualan = new JFrame();
		frmTransaksiPenjualan.setResizable(false);
		frmTransaksiPenjualan.setTitle("Transaksi Penjualan");
		frmTransaksiPenjualan.setBounds(100, 100, 862, 571);
		frmTransaksiPenjualan.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		frmTransaksiPenjualan.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kode");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(67, 43, 100, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNama = new JLabel("Nama");
		lblNama.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNama.setBounds(67, 73, 100, 15);
		panel.add(lblNama);
		
		JLabel lblNewLabel_1_1 = new JLabel("Total Bayar");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(67, 166, 100, 15);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Bayar");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(67, 202, 100, 15);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Kembalian");
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(67, 243, 100, 15);
		panel.add(lblNewLabel_1_1_1_1);
		
		kodeField = new JTextField();
		kodeField.setBounds(177, 41, 86, 20);
		panel.add(kodeField);
		kodeField.setColumns(10);
		
		namaField = new JTextField();
		namaField.setColumns(10);
		namaField.setBounds(177, 71, 86, 20);
		panel.add(namaField);
		
		totalBayarField = new JTextField();
		totalBayarField.setColumns(10);
		totalBayarField.setBounds(177, 164, 120, 20);
		panel.add(totalBayarField);
		
		bayarField = new JTextField();
		bayarField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					BigDecimal totalBayar = new BigDecimal(totalBayarField.getText());
					BigDecimal bayar  = new BigDecimal(bayarField.getText());
					
					kembalianField.setText(totalBayar.subtract(bayar).negate().toString());
				}
			}
		});
		bayarField.setColumns(10);
		bayarField.setBounds(177, 200, 120, 20);
		panel.add(bayarField);
		
		kembalianField = new JTextField();
		kembalianField.setColumns(10);
		kembalianField.setBounds(177, 241, 120, 20);
		panel.add(kembalianField);
		
		lblNote = new JLabel("Note");
		lblNote.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNote.setBounds(394, 43, 100, 15);
		panel.add(lblNote);
		
		lblNewLabel_2 = new JLabel("Tanggal");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(394, 73, 100, 15);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Kode");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(394, 113, 100, 15);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Barang");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(394, 143, 100, 15);
		panel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Harga");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(394, 173, 100, 15);
		panel.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Jumlah Beli");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(394, 203, 100, 15);
		panel.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Potongan");
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(394, 233, 100, 15);
		panel.add(lblNewLabel_7);
		
		noteField = new JTextField();
		noteField.setColumns(10);
		noteField.setBounds(497, 41, 100, 20);
		panel.add(noteField);
		
		tanggalChooser = new JDateChooser();
		tanggalChooser.setBounds(497, 73, 150, 20);
		panel.add(tanggalChooser);
		
		barangField = new JTextField();
		barangField.setColumns(10);
		barangField.setBounds(497, 143, 185, 20);
		panel.add(barangField);
		
		hargaField = new JTextField();
		hargaField.setColumns(10);
		hargaField.setBounds(497, 173, 100, 20);
		panel.add(hargaField);
		
		jumlahField = new JTextField();
		jumlahField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					BigDecimal hargaBarang = new BigDecimal(hargaField.getText());
					BigDecimal jumlahBarang  = new BigDecimal(jumlahField.getText());
					
					BigDecimal subTotal = hargaBarang.multiply(jumlahBarang);
					subTotalField.setText(subTotal.toString());
				}
			}
		});
		jumlahField.setColumns(10);
		jumlahField.setBounds(497, 203, 50, 20);
		panel.add(jumlahField);
		
		potonganField = new JTextField();
		potonganField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					BigDecimal subTotal = new BigDecimal(subTotalField.getText());
					BigDecimal persentasePotongan = new BigDecimal(potonganField.getText());
					
					BigDecimal potongan = subTotal.multiply(persentasePotongan.divide(new BigDecimal(100)));
					persentaseField.setText(potongan.toString());
					totalField.setText(subTotal.subtract(potongan).toString());
				}
			}
		});
		potonganField.setColumns(10);
		potonganField.setBounds(497, 233, 50, 20);
		panel.add(potonganField);
		
		lblNewLabel_1 = new JLabel("SubTotal");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(597, 203, 70, 15);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_8 = new JLabel("% => Rp");
		lblNewLabel_8.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(597, 233, 75, 15);
		panel.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("Total");
		lblNewLabel_9.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_9.setBounds(394, 275, 100, 15);
		panel.add(lblNewLabel_9);
		
		totalField = new JTextField();
		totalField.setColumns(10);
		totalField.setBounds(497, 273, 100, 20);
		panel.add(totalField);
		
		subTotalField = new JTextField();
		subTotalField.setColumns(10);
		subTotalField.setBounds(682, 203, 100, 20);
		panel.add(subTotalField);
		
		persentaseField = new JTextField();
		persentaseField.setColumns(10);
		persentaseField.setBounds(682, 233, 100, 20);
		panel.add(persentaseField);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(67, 319, 714, 158);
		panel.add(scrollPane);
		
		table = new JTable();
		showTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Tambah");
		Image imgSave = new ImageIcon(this.getClass().getResource("/floppy-disk.png")).getImage();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String kodeBarang = kodeField.getText();
					Timestamp tanggal = new Timestamp(tanggalChooser.getDate().getTime());
					BigDecimal totalBayar = new BigDecimal(totalBayarField.getText());
					BigDecimal bayar = new BigDecimal(bayarField.getText());
					BigDecimal jumlahBeli = new BigDecimal(0);
					BigDecimal potongan = new BigDecimal(0);
					
					for (TransaksiPenjualan transaksiPenjualan : listTransaksi) {
						jumlahBeli = jumlahBeli.add(transaksiPenjualan.getJumlahBarang());
						potongan = potongan.add(transaksiPenjualan.getPotongan());
					}
					
					DataPenjualan dataPenjualan = new DataPenjualan(kodeBarang, tanggal, totalBayar, bayar, jumlahBeli, potongan);
					dataPenjualanDao.saveDataPenjualan(dataPenjualan);
					
					listTransaksi.clear();
					showTable();
					clearForm();
					JOptionPane.showMessageDialog(null, "Success Tambah Data Barang", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error Simpan Data Transaksi ke DB" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(imgSave));
		btnNewButton.setBounds(100, 489, 113, 23);
		panel.add(btnNewButton);
		
		JButton btnCetak = new JButton("Cetak");
		Image imgCetak = new ImageIcon(this.getClass().getResource("/printer.png")).getImage();
		btnCetak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jrxmlPath = UTS_Gerryron.class.getResource("/TransaksiPenjualan.jrxml").getPath();
				jasperDao.showJasperPDFTransaksiPenjualan(jrxmlPath, listTransaksi);	
			}
		});
		btnCetak.setIcon(new ImageIcon(imgCetak));
		btnCetak.setBounds(353, 489, 89, 23);
		panel.add(btnCetak);
		
		JButton btnBatal = new JButton("Batal");
		Image imgBatal = new ImageIcon(this.getClass().getResource("/clear.png")).getImage();
		btnBatal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pilihan = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin batalkan data?", "Batalkan ?", JOptionPane.YES_NO_OPTION);
				if (pilihan == 0) {
					listTransaksi.clear();
					clearForm();
					showTable();
				}	
			}
		});
		btnBatal.setIcon(new ImageIcon(imgBatal));
		btnBatal.setBounds(608, 489, 89, 23);
		panel.add(btnBatal);
		
		JButton btnMasuk = new JButton("Masuk");
		Image imgMasuk = new ImageIcon(this.getClass().getResource("/add.png")).getImage();
		btnMasuk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nota = noteField.getText();
				String kodeBarang = kodeBarangCombo.getSelectedItem().toString();
				String namaBarang = barangField.getText();
				String jenisBarang = jenisField.getText();
				BigDecimal hargaBarang = new BigDecimal(hargaField.getText());
				BigDecimal jumlahBarang = new BigDecimal(jumlahField.getText());
				BigDecimal potongan = new BigDecimal(persentaseField.getText());
				BigDecimal total = new BigDecimal(totalField.getText());
				
				TransaksiPenjualan transaksiPenjualan = new TransaksiPenjualan(nota, kodeBarang, namaBarang, jenisBarang, 
						hargaBarang, jumlahBarang, potongan, total);
				listTransaksi.add(transaksiPenjualan);
				showTable();
				updateKeranjang();
				JOptionPane.showMessageDialog(null, "Success Tambah Data Barang", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnMasuk.setIcon(new ImageIcon(imgMasuk));
		btnMasuk.setBounds(682, 272, 100, 23);
		panel.add(btnMasuk);
		
		kodeBarangCombo = new JComboBox<String>();
		kodeBarangCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kodeBarang = kodeBarangCombo.getSelectedItem().toString();
				try {
					if (!kodeBarang.equals("- Pilih Kode")){
						DataBarang dataBarang = dataBarangDao.getDataBarangByKode(kodeBarang);
						
						barangField.setText(dataBarang.getNamaBarang());
						hargaField.setText(String.valueOf(dataBarang.getPenjualan()));
						jenisField.setText(dataBarang.getJenisBarang());
					}
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error get data : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				}	
			}
		});
		kodeBarangCombo.setBounds(497, 111, 100, 20);
		kodeBarangCombo.addItem("- Pilih Kode");
		for (DataBarang dataBarang : listBarang) {
			kodeBarangCombo.addItem(dataBarang.getKodeBarang());
		}
		panel.add(kodeBarangCombo);
		
		jenisField = new JTextField();
		jenisField.setColumns(10);
		jenisField.setBounds(692, 143, 86, 20);
		panel.add(jenisField);
	}
	
	private void showTable() {
		tableModel = new TransaksiPenjualanTableModel(listTransaksi);
		table.setModel(tableModel);
	}
	
	private void clearForm() {
		kodeBarangCombo.setSelectedIndex(0);
		namaField.setText("");
		kodeField.setText("");
		totalBayarField.setText("");
		kembalianField.setText("");
		bayarField.setText("");
		noteField.setText("");
		barangField.setText("");
		hargaField.setText("");
		jumlahField.setText("");
		potonganField.setText("");
		subTotalField.setText("");
		persentaseField.setText("");
		totalField.setText("");
		tanggalChooser.setDate(new Date());
		jenisField.setText("");
	}
	
	private void updateKeranjang() {
		BigDecimal totalBayar = new BigDecimal(0);
		for (TransaksiPenjualan transaksiPenjualan : listTransaksi) {
			totalBayar = totalBayar.add(transaksiPenjualan.getTotal());
		}
		totalBayarField.setText(totalBayar.toString());
	}
}
