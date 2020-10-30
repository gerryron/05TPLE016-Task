package com.gerryron.pertemuan11.DiskusiKeempat;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class DataPegawaiApp {

	private JFrame frmDataPegawaiApp;
	private JTextField idPegawaiField;
	private JTextField namaPegawaiField;
	private JTextField jenisKelaminField;
	private JComboBox<String> listNamaCombo;
	private JTable table;

	private List<DataPegawai> listPegawai = new ArrayList<DataPegawai>();
	private DataPegawaiDAO dataPegawaiDAO;
	private DataPegawaiTableModel tableModel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataPegawaiApp window = new DataPegawaiApp();
					window.frmDataPegawaiApp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DataPegawaiApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			dataPegawaiDAO = new DataPegawaiDAO();
			listPegawai = dataPegawaiDAO.getAllDataPegawai();
		} catch (Exception e){
			JOptionPane.showMessageDialog(null, "Error : " + e, "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		frmDataPegawaiApp = new JFrame();
		frmDataPegawaiApp.setTitle("Data Pegawai App- Gerryron");
		frmDataPegawaiApp.setBounds(100, 100, 800, 349);
		frmDataPegawaiApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmDataPegawaiApp.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("List Nama");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(47, 30, 100, 20);
		panel.add(lblNewLabel);
		
		JLabel lblIdPegawai = new JLabel("ID Pegawai");
		lblIdPegawai.setFont(new Font("Arial", Font.BOLD, 14));
		lblIdPegawai.setBounds(47, 60, 100, 20);
		panel.add(lblIdPegawai);
		
		JLabel lblNamaPegawai = new JLabel("Nama Pegawai");
		lblNamaPegawai.setFont(new Font("Arial", Font.BOLD, 14));
		lblNamaPegawai.setBounds(47, 90, 100, 20);
		panel.add(lblNamaPegawai);
		
		JLabel lblJenisKelamin = new JLabel("Jenis Kelamin");
		lblJenisKelamin.setFont(new Font("Arial", Font.BOLD, 14));
		lblJenisKelamin.setBounds(47, 120, 100, 20);
		panel.add(lblJenisKelamin);
		
		listNamaCombo = new JComboBox<String>();
		listNamaCombo.setBounds(170, 31, 150, 20);
		listNamaCombo.addItem("- Tampilkan Semua");
		for (DataPegawai dataPegawai : listPegawai) {
			listNamaCombo.addItem(dataPegawai.getNamaPegawai());
		}
		listNamaCombo.addMouseListener(new MouseAdapter() {	
			public void mouseClicked(MouseEvent e) {
				int idIndex = listNamaCombo.getSelectedIndex();
				if (idIndex == 0) {
					showTable();
				} else {
					try {
						List<DataPegawai> listDataPegawai = new ArrayList<DataPegawai>();
						listDataPegawai = dataPegawaiDAO.getDataPegawaiByNama(listNamaCombo.getSelectedItem().toString());
						tableModel = new DataPegawaiTableModel(listDataPegawai);
						table.setModel(tableModel);
					}catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Error get data : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						ex.printStackTrace();
					}
				}
			}
		});
		panel.add(listNamaCombo);
		
		idPegawaiField = new JTextField();
		idPegawaiField.setBounds(170, 61, 150, 20);
		panel.add(idPegawaiField);
		idPegawaiField.setColumns(10);
		
		namaPegawaiField = new JTextField();
		namaPegawaiField.setColumns(10);
		namaPegawaiField.setBounds(170, 91, 150, 20);
		panel.add(namaPegawaiField);
		
		jenisKelaminField = new JTextField();
		jenisKelaminField.setColumns(10);
		jenisKelaminField.setBounds(170, 121, 75, 20);
		panel.add(jenisKelaminField);
		
		JLabel lblLp = new JLabel("L / P");
		lblLp.setFont(new Font("Arial", Font.BOLD, 14));
		lblLp.setBounds(254, 120, 50, 20);
		panel.add(lblLp);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(353, 30, 421, 248);
		panel.add(scrollPane);
		
		table = new JTable();
		showTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				idPegawaiField.setText(tableModel.getValueAt(i, 0).toString());
				namaPegawaiField.setText(tableModel.getValueAt(i, 1).toString());
				jenisKelaminField.setText(tableModel.getValueAt(i, 2).toString());
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("New");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(28, 167, 69, 23);
		panel.add(btnNewButton);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int idPegawai = Integer.parseInt(idPegawaiField.getText());
					String namaPegawai = namaPegawaiField.getText();
					char jenisKelamin = jenisKelaminField.getText().charAt(0);
					
					DataPegawai dataPegawai = new DataPegawai(idPegawai, namaPegawai, jenisKelamin);
					dataPegawaiDAO.updateDataPegawai(dataPegawai);
					showTable();
					clearForm();
					JOptionPane.showMessageDialog(null, "Success Ubah Data Pegawai", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(107, 167, 88, 23);
		panel.add(btnUpdate);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearch.setBounds(205, 167, 88, 23);
		panel.add(btnSearch);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int idPegawai = Integer.parseInt(idPegawaiField.getText());
					String namaPegawai = namaPegawaiField.getText();
					char jenisKelamin = jenisKelaminField.getText().charAt(0);
					
					DataPegawai dataPegawai = new DataPegawai(idPegawai, namaPegawai, jenisKelamin);
					dataPegawaiDAO.saveDataPegawai(dataPegawai);
					showTable();
					clearForm();
					JOptionPane.showMessageDialog(null, "Success Tambah Data Pegawai", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				}
			}
		});
		btnSave.setBounds(28, 212, 69, 23);
		panel.add(btnSave);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int idPegawai = Integer.parseInt(idPegawaiField.getText());
					dataPegawaiDAO.deleteDataPegawai(idPegawai);
					showTable();
					clearForm();
					JOptionPane.showMessageDialog(null, "Success Hapus Data Pegawai", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				}
			}
		});
		btnDelete.setBounds(107, 212, 88, 23);
		panel.add(btnDelete);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listNamaCombo.removeAllItems();
				listNamaCombo.addItem("- Tampilkan Semua");
				try {
					listPegawai = dataPegawaiDAO.getAllDataPegawai();
					for (DataPegawai dataPegawai : listPegawai) {
						listNamaCombo.addItem(dataPegawai.getNamaPegawai());
					}
					showTable();
					JOptionPane.showMessageDialog(null, "Success Refresh Data Pegawai", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception ex){
					JOptionPane.showMessageDialog(null, "Error : " + ex, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnRefresh.setBounds(205, 212, 88, 23);
		panel.add(btnRefresh);
	}

	private void showTable() {
		tableModel = new DataPegawaiTableModel(listPegawai);
		table.setModel(tableModel);
	}
	
	private void clearForm() {
		idPegawaiField.setText("");
		namaPegawaiField.setText("");
		jenisKelaminField.setText("");
	}
	
}
