package com.gerryron.UTS.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Image;
import javax.swing.SwingConstants;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class Login {

	private JFrame frmLOG;
	private JTextField usernameField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLOG.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLOG = new JFrame();
		frmLOG.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLOG.setResizable(false);
		frmLOG.setTitle("L O G I N");
		frmLOG.setBounds(100, 100, 483, 328);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(SystemColor.activeCaption);
		frmLOG.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TOKO");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(29, 21, 77, 41);
		panel.add(lblNewLabel);
		
		JLabel lbljayaAbadi = new JLabel("\"JAYA ABADI\"");
		lbljayaAbadi.setForeground(Color.RED);
		lbljayaAbadi.setFont(new Font("Arial", Font.BOLD, 20));
		lbljayaAbadi.setBounds(94, 21, 152, 41);
		panel.add(lbljayaAbadi);
		
		JLabel lblNewLabel_1 = new JLabel("Jl. Surya Kencana Pamulang Timur No 12");
		lblNewLabel_1.setBounds(29, 61, 251, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username :");
		lblNewLabel_2.setFont(new Font("Arial Narrow", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(160, 121, 97, 22);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password :");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1.setFont(new Font("Arial Narrow", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(160, 154, 97, 22);
		panel.add(lblNewLabel_2_1);
		
		usernameField = new JTextField();
		usernameField.setBounds(265, 121, 139, 22);
		panel.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(265, 155, 137, 22);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				String password = new String(passwordField.getPassword());
				
				if(username.equalsIgnoreCase("gerryron") && password.equals("181011401627")) {
					UTS_Gerryron.main();
					frmLOG.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "Username atau password salah !", "ERROR", JOptionPane.OK_OPTION);
				}
			}
		});
		btnNewButton.setBounds(178, 211, 77, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Keluar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pilihan = JOptionPane.showConfirmDialog(null, "apakah anda ingin keluar ?", "Exit ?", JOptionPane.YES_NO_OPTION);
				if (pilihan == 0) {
					System.exit(0);
				}
			}
		});
		btnNewButton_1.setBounds(327, 211, 77, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/loginKey.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img));
		lblNewLabel_3.setBounds(29, 105, 139, 129);
		panel.add(lblNewLabel_3);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEEE, dd MMMM yyyy        hh:mm:ss", new Locale("id", "ID"));
		String currDate = dateFormat.format(new Date());
		JLabel lblNewLabel_4 = new JLabel(currDate);
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(229, 264, 228, 14);
		panel.add(lblNewLabel_4);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(29, 86, 345, 14);
		panel.add(separator);
	}
}
