package com.gerryron.pertemuan8;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import com.gerryron.pertemuan8.DAO.MahasiswaDAO;
import com.gerryron.pertemuan8.Entity.Mahasiswa;
import com.gerryron.pertemuan8.Model.MahasiswaTableModel;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class DiskusiKedua {

	private JFrame frmDiskusiKedua;
	private JTextField nim;
	private JTextField nama;
	private MahasiswaDAO mahasiswaDao;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiskusiKedua window = new DiskusiKedua();
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
	public DiskusiKedua() {
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
		
		frmDiskusiKedua = new JFrame();
		frmDiskusiKedua.setTitle("Diskusi Kedua - Gerryron");
		frmDiskusiKedua.setBounds(100, 100, 485, 504);
		frmDiskusiKedua.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmDiskusiKedua.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NIM");
		lblNewLabel.setFont(new Font("Arial Narrow", Font.PLAIN, 13));
		lblNewLabel.setBounds(40, 51, 58, 23);
		panel.add(lblNewLabel);
		
		JLabel lblNama = new JLabel("Nama");
		lblNama.setFont(new Font("Arial Narrow", Font.PLAIN, 13));
		lblNama.setBounds(40, 91, 58, 23);
		panel.add(lblNama);
		
		JLabel lblNewLabel_1_1 = new JLabel("Prodi");
		lblNewLabel_1_1.setFont(new Font("Arial Narrow", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(40, 131, 58, 23);
		panel.add(lblNewLabel_1_1);
		
		nim = new JTextField();
		nim.setBounds(144, 53, 185, 20);
		panel.add(nim);
		nim.setColumns(10);
		
		nama = new JTextField();
		nama.setColumns(10);
		nama.setBounds(144, 93, 185, 20);
		panel.add(nama);
		
		JComboBox prodi = new JComboBox();
		prodi.setBounds(144, 133, 154, 21);
		panel.add(prodi);
		prodi.addItem("-- pilih --");
		prodi.addItem("Manajemen");
		prodi.addItem("Hukum");
		prodi.addItem("T. Informatika");
		
		
		JButton btnNewButton = new JButton("Cari");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nimMhs = nim.getText();
					
					List<Mahasiswa> listMahasiswa = null;
					
					if(nimMhs != null && nimMhs.trim().length()>0) {
						listMahasiswa = mahasiswaDao.searchMahasiswaByNIM(nimMhs);
					} else {
						listMahasiswa = mahasiswaDao.getAllMahasiswa();
					}
					
					// create the model and update the "table"
					MahasiswaTableModel tableModel = new MahasiswaTableModel(listMahasiswa);
					table.setModel(tableModel);
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error : " + ex, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(369, 51, 71, 39);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Simpan");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nimMhs = nim.getText();
				String namaMhs = nama.getText();
				String prodiMhs = prodi.getSelectedItem().toString();
				Mahasiswa mahasiswa = new Mahasiswa(nimMhs, namaMhs, prodiMhs);
				
				try {
					mahasiswaDao.addMahasiswa(mahasiswa);
					JOptionPane.showMessageDialog(null, "Success Saving Mahasiswa", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Error Saving Mahasiswa : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_1.setBounds(21, 362, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Hapus");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nimMhs = nim.getText();
				
				try {
					mahasiswaDao.deleteMahasiswa(nimMhs);;
					JOptionPane.showMessageDialog(null, "Success Delete Data Mahasiswa", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Error Delete Mahasiswa : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_2.setBounds(159, 362, 89, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Keluar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_3.setBounds(351, 362, 89, 23);
		panel.add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 183, 400, 156);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
