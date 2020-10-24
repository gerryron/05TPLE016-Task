package com.gerryron.pertemuan8.DiskusiKetiga;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class InternalFrameAdd extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InternalFrameAdd frame = new InternalFrameAdd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InternalFrameAdd() {
		setMaximizable(true);
		setResizable(true);
		setClosable(true);
		setTitle("Add Product");
		setBounds(100, 100, 450, 300);

	}

}
