package com.gerryron.pertemuan7;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class DiskusiPertama{

	/*
	 * Buatlah aplikasi dengan menggunakan netbean yang akan menghasilkan output

	   Tombol "OK" untuk menampilkan teks pada "nama lengkap" dari nama depan dan nama belakang
	 */
	
	private JFrame frame = new JFrame("Diskusi Pertama - Gerryron");
	private JPanel panel = new JPanel();
	private JLabel label1 = new JLabel("Nama Depan");
	private JTextField textField1 = new JTextField();
	private JLabel label2 = new JLabel("Nama Belakang");
	private JTextField textField2 = new JTextField();
	private JLabel label3 = new JLabel("Nama Lengkap");
	private JTextField textField3 = new JTextField();
	private JButton tombol = new JButton("OK");
	
	DiskusiPertama() {
		panel.setLayout(null);
		panel.setSize(150, 200);
		frame.setSize(650, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Data Setter
		label1.setBounds(140, 70, 200, 25);
		textField1.setBounds(240, 70, 200, 25);
		label2.setBounds(140, 110, 200, 25);
		textField2.setBounds(240, 110, 200, 25);
		label3.setBounds(140, 150, 200, 25);
		textField3.setBounds(240, 150, 300, 25);
		textField3.setEditable(false);
		tombol.setBounds(320, 210, 70, 25);
		
		// Set action listener tombol
		tombol.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textField3.setText(textField1.getText() + " " + textField2.getText());		
			}
		});
		
		// Add panel
		panel.add(label1);
		panel.add(textField1);
		panel.add(label2);
		panel.add(textField2);
		panel.add(label3);
		panel.add(textField3);
		panel.add(tombol);
		
		// Create frame
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		DiskusiPertama diskusiPertama = new DiskusiPertama();
	}
	
}
