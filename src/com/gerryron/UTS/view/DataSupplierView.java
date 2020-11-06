package com.gerryron.UTS.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.gerryron.UTS.DAO.DataSupplierDAO;
import com.gerryron.UTS.Entity.DataSupplier;
import com.gerryron.UTS.Model.DataSupplierTableModel;

public class DataSupplierView {

	private JFrame frmDataSupplier;
	private JTextField searchField;
	private JTextField kodeField;
	private JTextField namaSupplierField;
	private JTextField namaBarangField;
	private JTextField jumlahBarangField;
	private JTable table;
	
	private List<DataSupplier> listSupplier = new ArrayList<DataSupplier>();
	private DataSupplierDAO dataSupplierDao;
	private DataSupplierTableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataSupplierView window = new DataSupplierView();
					window.frmDataSupplier.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DataSupplierView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			dataSupplierDao = new DataSupplierDAO();
		} catch (Exception e){
			JOptionPane.showMessageDialog(null, "Error : " + e, "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		frmDataSupplier = new JFrame();
		frmDataSupplier.setTitle("Data Supplier");
		frmDataSupplier.setBounds(100, 100, 694, 611);
		frmDataSupplier.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmDataSupplier.getContentPane().add(panel, BorderLayout.CENTER);
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
		
		JLabel lblNewLabel_1 = new JLabel("Data Supplier");
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
						String namaSupplier = searchField.getText();
						List<DataSupplier> listSupplier = dataSupplierDao.getDataSupplierByNama(namaSupplier);
						tableModel = new DataSupplierTableModel(listSupplier);
						table.setModel(tableModel);
						if (listSupplier.isEmpty() || listSupplier == null) {
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
		
		namaSupplierField = new JTextField();
		namaSupplierField.setColumns(10);
		namaSupplierField.setBounds(244, 195, 166, 23);
		panel.add(namaSupplierField);
		
		namaBarangField = new JTextField();
		namaBarangField.setColumns(10);
		namaBarangField.setBounds(244, 230, 166, 23);
		panel.add(namaBarangField);
		
		jumlahBarangField = new JTextField();
		jumlahBarangField.setColumns(10);
		jumlahBarangField.setBounds(244, 265, 166, 23);
		panel.add(jumlahBarangField);
		
		JLabel lblNewLabel_3 = new JLabel("Kode");
		lblNewLabel_3.setBounds(144, 165, 90, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Nama Supplier");
		lblNewLabel_3_1.setBounds(144, 199, 90, 14);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_3 = new JLabel("Nama Barang");
		lblNewLabel_3_3.setBounds(144, 234, 90, 14);
		panel.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_3_1 = new JLabel("Jumlah Barang");
		lblNewLabel_3_3_1.setBounds(144, 269, 90, 14);
		panel.add(lblNewLabel_3_3_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 313, 659, 133);
		panel.add(scrollPane);
		
		table = new JTable();
		showTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				kodeField.setText(tableModel.getValueAt(i, 0).toString());
				namaSupplierField.setText(tableModel.getValueAt(i, 1).toString());
				namaBarangField.setText(tableModel.getValueAt(i, 2).toString());
				jumlahBarangField.setText(tableModel.getValueAt(i, 3).toString());
			}
		});
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 255, 255));
		panel_1.setBounds(10, 477, 659, 48);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Tambah");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kodeSupplier = kodeField.getText();
				String namaSupplier = namaSupplierField.getText();
				String namaBarang = namaBarangField.getText();
				BigDecimal banyakBarang = new BigDecimal(jumlahBarangField.getText());
				
				DataSupplier dataSupplier = new DataSupplier(kodeSupplier, namaSupplier, namaBarang, banyakBarang);
				listSupplier.add(dataSupplier);
				showTable();
				clearForm();
				JOptionPane.showMessageDialog(null, "Success Tambah Data Supplier", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
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
					for (DataSupplier dataSupplier : listSupplier) {
						dataSupplierDao.saveDataSupplier(dataSupplier);
					}
					listSupplier.clear();
					clearForm();
					showTable();
					JOptionPane.showMessageDialog(null, "Success Simpan Data Supplier ke DB", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error Simpan Data Supplier ke DB" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
				String kodeSupplier = kodeField.getText();
				String namaSupplier = namaSupplierField.getText();
				String namaBarang = namaBarangField.getText();
				BigDecimal banyakBarang = new BigDecimal(jumlahBarangField.getText());
				
				DataSupplier dataSupplier = new DataSupplier(kodeSupplier, namaSupplier, namaBarang, banyakBarang);
				listSupplier.set(i, dataSupplier);
				showTable();
				clearForm();
				JOptionPane.showMessageDialog(null, "Success Ubah Data Supplier", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
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
				listSupplier.remove(i);
				clearForm();
				showTable();
				JOptionPane.showMessageDialog(null, "Success Hapus Data Supplier", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
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
					listSupplier.clear();
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
					frmDataSupplier.dispose();
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
		lblNewLabel_4.setBounds(429, 536, 228, 14);
		panel.add(lblNewLabel_4);
	}
	
	private void showTable() {
		tableModel = new DataSupplierTableModel(listSupplier);
		table.setModel(tableModel);
	}
	
	private void clearForm() {
		searchField.setText("");
		kodeField.setText("");
		namaSupplierField.setText("");
		namaBarangField.setText("");
		jumlahBarangField.setText("");
	}

}
