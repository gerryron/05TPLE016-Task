package com.gerryron.pertemuan7;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DiskusiKedua {
	
	/*
	 Buatlah aplikasi dengan menggunakan netbean yang akan menghasilkan output seperti diatas

	 tombol "OK" untuk menampilkan "hasil" dan "keterangan"

	 hasil = (nilai1 + nilai2)/2

	 keterangan = jika hasil >= 60 " Lulus" jika tidak " Mengulang" gunakan exception


	 */

	private JFrame frame = new JFrame("Diskusi Kedua - Gerryron");
	private JPanel panel = new JPanel();
	private JLabel label1 = new JLabel("Nilai 1");
	private JTextField textField1 = new JTextField();
	private JLabel label2 = new JLabel("Nilai 2");
	private JTextField textField2 = new JTextField();
	private JLabel label3 = new JLabel("Hasil");
	private JTextField textField3 = new JTextField();
	private JLabel label4 = new JLabel("Keterangan");
	private JTextField textField4 = new JTextField();
	private JButton tombol = new JButton("OK");
	private JLabel label5 = new JLabel();
	
	DiskusiKedua() {
		panel.setLayout(null);
		panel.setSize(150, 200);
		frame.setSize(650, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Data Setter
		label1.setBounds(110, 70, 200, 25);
		textField1.setBounds(240, 70, 200, 25);
		label2.setBounds(110, 110, 200, 25);
		textField2.setBounds(240, 110, 200, 25);
		label3.setBounds(110, 150, 200, 25);
		textField3.setBounds(240, 150, 300, 25);
		textField3.setEditable(false);
		label4.setBounds(110, 190, 200, 25);
		textField4.setBounds(240, 190, 300, 25);
		textField4.setEditable(false);
		tombol.setBounds(470, 110, 70, 25);
		
		// Set action listener tombol
		tombol.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int nilai1 = Integer.parseInt(textField1.getText());
					int nilai2 = Integer.parseInt(textField2.getText());
					float hasil = (nilai1+nilai2)/2;
					
					NumberFormat formatter = new DecimalFormat("#0.00");     
					textField3.setText(formatter.format(hasil));
					
					if (hasil >= 60) {
						textField4.setText("LULUS");
					}else textField4.setText("Mengulang");		
				} catch (Exception ex) {
					label5.setText("Nilai masukkan harus berupa bilangan bulat");
					label5.setBounds(240, 230, 300, 25);
					label5.setForeground(Color.RED);
				}
				
			}
		});
		
		// Add panel
		panel.add(label1);
		panel.add(textField1);
		panel.add(label2);
		panel.add(textField2);
		panel.add(label3);
		panel.add(textField3);
		panel.add(label4);
		panel.add(textField4);
		panel.add(tombol);
		panel.add(label5);
		
		// Create frame
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		DiskusiKedua diskusiKedua = new DiskusiKedua();
	}
	
}
