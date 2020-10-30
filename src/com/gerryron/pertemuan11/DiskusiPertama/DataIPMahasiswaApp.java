package com.gerryron.pertemuan11.DiskusiPertama;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.gerryron.pertemuan9.DiskusiKelima.DataNilaiMahasiswa;
import com.gerryron.pertemuan9.DiskusiKelima.DataNilaiMahasiswaDAO;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DataIPMahasiswaApp {

	private JFrame frmDiskusiPertama;
	private JTextField nimField;
	private JTextField namaField;
	private JTextField ipField;
	private JTextField emailField;
	private JTextField telpField;
	private JComboBox<String> prodiCombo;
	private JTable table;
	
	private List<DataIPMahasiswa> listIndex = new ArrayList<DataIPMahasiswa>();
	private DataIPMahasiswaTableModel tableModel;
	private DataIPMahasiswaDAO dataIndexDao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataIPMahasiswaApp window = new DataIPMahasiswaApp();
					window.frmDiskusiPertama.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DataIPMahasiswaApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			dataIndexDao = new DataIPMahasiswaDAO();
		} catch (Exception e){
			JOptionPane.showMessageDialog(null, "Error : " + e, "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		frmDiskusiPertama = new JFrame();
		frmDiskusiPertama.setTitle("Data IP Mahasiswa App- Gerryron");
		frmDiskusiPertama.setBounds(100, 100, 799, 552);
		frmDiskusiPertama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmDiskusiPertama.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DATA INDEX PRESTASI MAHASISWA");
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 22, 763, 27);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NIM");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(161, 73, 134, 27);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("NAMA");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(161, 116, 134, 27);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("PRODI");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(161, 156, 134, 27);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("INDEX PRESTASI");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(161, 196, 134, 27);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("EMAIL");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_4.setBounds(161, 236, 134, 27);
		panel.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("TELP.");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_5.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_5.setBounds(161, 276, 134, 27);
		panel.add(lblNewLabel_1_5);
		
		nimField = new JTextField();
		nimField.setBounds(324, 76, 189, 23);
		panel.add(nimField);
		nimField.setColumns(10);
		
		namaField = new JTextField();
		namaField.setColumns(10);
		namaField.setBounds(324, 120, 189, 23);
		panel.add(namaField);
		
		ipField = new JTextField();
		ipField.setColumns(10);
		ipField.setBounds(324, 200, 189, 23);
		panel.add(ipField);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(324, 240, 189, 23);
		panel.add(emailField);
		
		telpField = new JTextField();
		telpField.setColumns(10);
		telpField.setBounds(324, 280, 189, 23);
		panel.add(telpField);
		
		prodiCombo = new JComboBox<String>();
		prodiCombo.setBounds(324, 160, 189, 23);
		prodiCombo.addItem("- Pilih Program Studi");
		prodiCombo.addItem("Teknik Informatika");
		prodiCombo.addItem("Hukum");
		prodiCombo.addItem("Teknik Elektro");
		panel.add(prodiCombo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 354, 717, 148);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				nimField.setText(tableModel.getValueAt(i, 0).toString());
				namaField.setText(tableModel.getValueAt(i, 1).toString());
				prodiCombo.setSelectedItem(tableModel.getValueAt(i, 2).toString());
				ipField.setText(tableModel.getValueAt(i, 3).toString());
				emailField.setText(tableModel.getValueAt(i, 4).toString());
				telpField.setText(tableModel.getValueAt(i, 5).toString());
			}
		});
		showTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("TAMBAH DATA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nim = nimField.getText();
					String nama = namaField.getText();
					String prodi = prodiCombo.getSelectedItem().toString();
					String indexPrestasi = ipField.getText();
					String email = emailField.getText();
					String telp = telpField.getText();
					
					DataIPMahasiswa dataIndex = new DataIPMahasiswa(nim, nama, prodi, indexPrestasi, email, telp);
					listIndex.add(dataIndex);
					showTable();
					clearForm();
					JOptionPane.showMessageDialog(null, "Success Tambah Data IP Mahasiswa", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error : " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(63, 320, 119, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SIMPAN DATA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					for (DataIPMahasiswa dataIndex : listIndex) {
						dataIndexDao.saveDataIPMahasiswa(dataIndex);
					}
					listIndex.clear();
					clearForm();
					showTable();
					JOptionPane.showMessageDialog(null, "Success Insert Data IP Mahasiswa", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error Insert Data Nilai Mahasiswa : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_1.setBounds(192, 320, 113, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("EDIT");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				String nim = nimField.getText();
				String nama = namaField.getText();
				String prodi = prodiCombo.getSelectedItem().toString();
				String indexPrestasi = ipField.getText();
				String email = emailField.getText();
				String telp = telpField.getText();
				
				DataIPMahasiswa dataIndex = new DataIPMahasiswa(nim, nama, prodi, indexPrestasi, email, telp);
				listIndex.set(i,dataIndex);
				showTable();
				clearForm();
				JOptionPane.showMessageDialog(null, "Success Ubah Data IP Mahasiswa", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton_2.setBounds(315, 320, 65, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("HAPUS");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				listIndex.remove(i);
				clearForm();
				showTable();
				JOptionPane.showMessageDialog(null, "Success Hapus Data IP Mahasiswa", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);

			}
		});
		btnNewButton_3.setBounds(390, 320, 77, 23);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("KELUAR");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pilihan = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin keluar ?");
				if (pilihan == 0) {
					System.exit(0);
				}	
			}
		});
		btnNewButton_4.setBounds(668, 320, 83, 23);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("BATAL");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pilihan = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin batalkan data?", "Batalkan ?", JOptionPane.YES_NO_OPTION);
				if (pilihan == 0) {
					listIndex.clear();
					clearForm();
					showTable();
				}	
			}
		});
		btnNewButton_5.setBounds(477, 320, 77, 23);
		panel.add(btnNewButton_5);
	}
	
	private void showTable() {
		tableModel = new DataIPMahasiswaTableModel(listIndex);
		table.setModel(tableModel);
	}
	
	private void clearForm() {
		nimField.setText("");
		namaField.setText("");
		prodiCombo.setSelectedIndex(0);
		ipField.setText("");
		emailField.setText("");
		telpField.setText("");
	}
	
}
