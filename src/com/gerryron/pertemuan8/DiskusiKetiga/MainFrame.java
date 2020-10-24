package com.gerryron.pertemuan8.DiskusiKetiga;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame {

	private JFrame frmDiskusiKetiga;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frmDiskusiKetiga.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDiskusiKetiga = new JFrame();
		frmDiskusiKetiga.setTitle("Diskusi Ketiga - Gerryron");
		frmDiskusiKetiga.setBounds(100, 100, 804, 463);
		frmDiskusiKetiga.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		frmDiskusiKetiga.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 788, 21);
		desktopPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Product");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Add");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InternalFrameAdd internalFrameAdd = new InternalFrameAdd();
				internalFrameAdd.setVisible(true);
				desktopPane.add(internalFrameAdd);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
	}
}
