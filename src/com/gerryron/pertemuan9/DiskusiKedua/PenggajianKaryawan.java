package com.gerryron.pertemuan9.DiskusiKedua;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import com.gerryron.pertemuan9.DiskusiKedua.DAO.KaryawanDAO;
import com.gerryron.pertemuan9.DiskusiKedua.Entity.Karyawan;
import com.gerryron.pertemuan9.DiskusiKedua.Model.KaryawanTableModel;


import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PenggajianKaryawan {

	private JFrame frmDiskusiKedua;
	private JTextField nikField;
	private JTextField namaField;
	private JTextField gapokField;
	private JTextField upahLemburField;
	private JTextField gajiField;
	private JComboBox<String> jkCombo;
	private JComboBox<String> jabatanCombo;
	private JComboBox<String> lemburCombo;
	private JTable table;
	private JTextField cariField;
	
	private List<Karyawan> listKaryawan = new ArrayList<Karyawan>();
	private KaryawanDAO karyawanDao;
	private KaryawanTableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PenggajianKaryawan window = new PenggajianKaryawan();
					window.frmDiskusiKedua.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PenggajianKaryawan() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			karyawanDao = new KaryawanDAO();
		} catch (Exception e){
			JOptionPane.showMessageDialog(null, "Error : " + e, "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		frmDiskusiKedua = new JFrame();
		frmDiskusiKedua.setTitle("Penggajian Karyawan - Gerryron");
		frmDiskusiKedua.setBounds(100, 100, 815, 559);
		frmDiskusiKedua.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmDiskusiKedua.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Penggajian Karyawan");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 11, 756, 30);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NIK");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(70, 70, 66, 24);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nama Karyawan");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(16, 110, 120, 29);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Jenis Kelamin");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(26, 150, 110, 24);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Jabatan");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
		lblNewLabel_1_3.setBounds(36, 190, 100, 24);
		panel.add(lblNewLabel_1_3);
		
		nikField = new JTextField();
		nikField.setBounds(187, 75, 188, 20);
		panel.add(nikField);
		nikField.setColumns(10);
		
		namaField = new JTextField();
		namaField.setColumns(10);
		namaField.setBounds(187, 117, 188, 20);
		panel.add(namaField);
		
		jkCombo = new JComboBox<String>();
		jkCombo.setBounds(187, 155, 188, 20);
		jkCombo.addItem("- Pilih Jenis Kelamin");
		jkCombo.addItem("Laki Laki");
		jkCombo.addItem("Perempuan");
		jkCombo.addItem("Tidak Terjamin");
		panel.add(jkCombo);
		
		jabatanCombo = new JComboBox<String>();
		jabatanCombo.addItem("- Pilih Jabatan");
		jabatanCombo.addItem("Keuangan");
		jabatanCombo.addItem("Kasir");
		jabatanCombo.addItem("Cleaning Service");
		jabatanCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int jabatanIndex = jabatanCombo.getSelectedIndex();
				
				if (jabatanIndex != 0) {
					gapokField.setText("2500000");
				} else {
					gapokField.setText("0");
				}
			}
		});
		jabatanCombo.setBounds(187, 195, 188, 20);
		panel.add(jabatanCombo);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Gaji Pokok");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(417, 70, 120, 29);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Jam Lembur");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1.setBounds(417, 110, 120, 29);
		panel.add(lblNewLabel_1_1_1_1);
		
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Upah Lembur");
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1_1.setBounds(417, 150, 120, 29);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Total Gaji");
		lblNewLabel_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1_1_1.setBounds(417, 190, 120, 29);
		panel.add(lblNewLabel_1_1_1_1_1_1);
		
		gapokField = new JTextField();
		gapokField.setEditable(false);
		gapokField.setColumns(10);
		gapokField.setBounds(564, 75, 188, 20);
		panel.add(gapokField);
		
		lemburCombo = new JComboBox<String>();
		lemburCombo.setBounds(564, 117, 188, 20);
		lemburCombo.addItem("- Pilih Jam Lembur");
		lemburCombo.addItem("1 Jam");
		lemburCombo.addItem("2 Jam");
		lemburCombo.addItem("3 Jam");
		lemburCombo.addItem("4 Jam");
		lemburCombo.addItem("5 Jam");
		lemburCombo.addItem("Tidak Lembur");
		lemburCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int lemburComboIndex = lemburCombo.getSelectedIndex();
				
				if (lemburComboIndex == 1) {
					upahLemburField.setText("75000");
				} else if (lemburComboIndex == 2) {
					upahLemburField.setText("150000");
				} else if (lemburComboIndex == 3) {
					upahLemburField.setText("225000");
				} else if (lemburComboIndex == 4) {
					upahLemburField.setText("300000");
				} else if (lemburComboIndex == 5) {
					upahLemburField.setText("375000");
				}else {
					upahLemburField.setText("0");
				}
				
				BigDecimal totalGaji = new BigDecimal("0");
				if (!gapokField.getText().equals("") || !gapokField.getText().isEmpty()) {
					BigDecimal gajiPokok = new BigDecimal(gapokField.getText());
					BigDecimal upahLembur = new BigDecimal(upahLemburField.getText());
					totalGaji = gajiPokok.add(upahLembur);
				}
				
				gajiField.setText(totalGaji.toString());
		
			}
		});
		panel.add(lemburCombo);
		
		upahLemburField = new JTextField();
		upahLemburField.setEditable(false);
		upahLemburField.setColumns(10);
		upahLemburField.setBounds(564, 155, 188, 20);
		panel.add(upahLemburField);
		
		gajiField = new JTextField();
		gajiField.setEditable(false);
		gajiField.setColumns(10);
		gajiField.setBounds(564, 195, 188, 20);
		panel.add(gajiField);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 274, 779, 186);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				nikField.setText(tableModel.getValueAt(i, 0).toString());
				namaField.setText(tableModel.getValueAt(i, 1).toString());
				gapokField.setText(tableModel.getValueAt(i, 4).toString());
				getComboBoxSelected(i);
				upahLemburField.setText(tableModel.getValueAt(i, 6).toString());
				gajiField.setText(tableModel.getValueAt(i, 7).toString());
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Simpan");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				try {
					for(Karyawan karyawan : listKaryawan) {
						karyawanDao.addKaryawan(karyawan);
					}
					JOptionPane.showMessageDialog(null, "Success Saving Data Karyawan", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Error Saving Data Karyawan : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewButton.setBounds(35, 470, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnHapus = new JButton("Hapus");
		btnHapus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				JOptionPane.showMessageDialog(null, "Success Hapus Data Karyawan : " + listKaryawan.get(i).getNamaKaryawan(), "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
				listKaryawan.remove(i);
				showTable();
				clearForm();
			}
		});
		btnHapus.setBounds(155, 470, 89, 23);
		panel.add(btnHapus);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				String nik = nikField.getText();
				String namaKaryawan = namaField.getText();
				String jenisKelamin = jkCombo.getSelectedItem().toString();
				String jabatan = jabatanCombo.getSelectedItem().toString();
				BigDecimal gajiPokok = new BigDecimal(gapokField.getText());
				Short jamLembur = 0;
				String jamLemburField = lemburCombo.getSelectedItem().toString();
				if (!jamLemburField.equalsIgnoreCase("Tidak Lembur")) {
					jamLembur = new Short(String.valueOf(jamLemburField.charAt(0)));
				}
				BigDecimal upahLembur = new BigDecimal(upahLemburField.getText());
				BigDecimal totalGaji = new BigDecimal(gajiField.getText());
				
				Karyawan karyawan = new Karyawan(nik, namaKaryawan, jenisKelamin, jabatan, gajiPokok, jamLembur, upahLembur, totalGaji);
				JOptionPane.showMessageDialog(null, "Success Update Data Karyawan", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
				listKaryawan.set(i, karyawan);		
				showTable();
				clearForm();
			}
		});
		btnUpdate.setBounds(275, 470, 89, 23);
		panel.add(btnUpdate);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Cari");
		lblNewLabel_1_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3_1.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
		lblNewLabel_1_3_1.setBounds(593, 471, 53, 24);
		panel.add(lblNewLabel_1_3_1);
		
		cariField = new JTextField();
		cariField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					try {
						int nikSearch = Integer.parseInt(cariField.getText());
						List<Karyawan> listKaryawan = karyawanDao.searchKaryawanByNIK(nikSearch);
						if (listKaryawan.isEmpty() || listKaryawan == null) {
							JOptionPane.showMessageDialog(null, "Data yang dicari tidak ada", "Info", JOptionPane.INFORMATION_MESSAGE);
						}
						tableModel = new KaryawanTableModel(listKaryawan);
						table.setModel(tableModel);
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Error : " + ex, "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		cariField.setColumns(10);
		cariField.setBounds(669, 471, 120, 20);
		panel.add(cariField);
		
		JButton btnKeluar = new JButton("Keluar");
		btnKeluar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnKeluar.setBounds(448, 470, 89, 23);
		panel.add(btnKeluar);
		
		JButton btnNewButton_1 = new JButton("Tambah");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nik = nikField.getText();
				String namaKaryawan = namaField.getText();
				String jenisKelamin = jkCombo.getSelectedItem().toString();
				String jabatan = jabatanCombo.getSelectedItem().toString();
				BigDecimal gajiPokok = new BigDecimal(gapokField.getText());
				Short jamLembur = 0;
				String jamLemburField = lemburCombo.getSelectedItem().toString();
				if (!jamLemburField.equalsIgnoreCase("Tidak Lembur")) {
					jamLembur = new Short(String.valueOf(jamLemburField.charAt(0)));
				}
				BigDecimal upahLembur = new BigDecimal(upahLemburField.getText());
				BigDecimal totalGaji = new BigDecimal(gajiField.getText());
				
				Karyawan karyawan = new Karyawan(nik, namaKaryawan, jenisKelamin, jabatan, gajiPokok, jamLembur, upahLembur, totalGaji);
				
				listKaryawan.add(karyawan);
				showTable();
			}
		});
		btnNewButton_1.setBounds(700, 242, 89, 23);
		panel.add(btnNewButton_1);
	}
	
	private void clearForm() {
		nikField.setText("");
		namaField.setText("");
		jkCombo.setSelectedIndex(0);
		jabatanCombo.setSelectedIndex(0);
		gapokField.setText("");
		lemburCombo.setSelectedIndex(0);
		upahLemburField.setText("");
		gajiField.setText("");
	}
	
	private void showTable() {
			tableModel = new KaryawanTableModel(listKaryawan);
			table.setModel(tableModel);
	}

	private void getComboBoxSelected(int index) {
		String jenisKelamin = tableModel.getValueAt(index, 2).toString();
		String jabatan = tableModel.getValueAt(index, 3).toString();
		String jamLembur = tableModel.getValueAt(index, 5).toString();
		
		if (jenisKelamin.equals("Laki Laki")) {
			jkCombo.setSelectedIndex(1);
		} else if (jenisKelamin.equals("Perempuan")) {
			jkCombo.setSelectedIndex(2);
		} else if (jenisKelamin.equals("Tidak Terjamin")) {
			jkCombo.setSelectedIndex(3);
		} else {
			jkCombo.setSelectedIndex(0);
		}
		
		if (jabatan.equals("Keuangan")) {
			jabatanCombo.setSelectedIndex(1);
		} else if (jabatan.equals("Kasir")) {
			jabatanCombo.setSelectedIndex(2);
		} else if (jabatan.equals("Cleaning Service")) {
			jabatanCombo.setSelectedIndex(3);
		} else {
			jabatanCombo.setSelectedIndex(0);
		}
		
		if (jamLembur.equals("1")) {
			lemburCombo.setSelectedIndex(1);
		} else if (jamLembur.equals("2")) {
			lemburCombo.setSelectedIndex(2);
		} else if (jamLembur.equals("3")) {
			lemburCombo.setSelectedIndex(3);
		} else if (jamLembur.equals("4")) {
			lemburCombo.setSelectedIndex(4);
		} else if (jamLembur.equals("5")) {
			lemburCombo.setSelectedIndex(5);
		}else {
			lemburCombo.setSelectedIndex(4);
		}
		
	}
}
