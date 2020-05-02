package com.t2s.staying.home.T2S.StayingHome.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

public class CreateDocument {

	private JFrame frame;
	private JTextField textAuthor;
	private JLabel lblNewLabel;
	private JTextField textTitle;

	/**
	 * Launch the application.
	 */
	public void CreateDoc() {
		EventQueue.invokeLater(() -> {
			try {
				CreateDocument window = new CreateDocument();
				window.frame.setVisible(true);

			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreateDocument() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	//test
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 446, 330);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textAuthor = new JTextField();
		textAuthor.setBounds(28, 63, 141, 20);
		frame.getContentPane().add(textAuthor);
		textAuthor.setColumns(10);
		
		JLabel lblAuthor = new JLabel("Author's Name");
		lblAuthor.setBounds(28, 37, 86, 14);
		frame.getContentPane().add(lblAuthor);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					   File file = new File("test.txt");
					   file.createNewFile();
					   JOptionPane.showMessageDialog(btnCreate,"To " + file + " dhmiourgithike", null, 1);
					} catch(Exception e1) {
					   e1.printStackTrace();
					}

			}
		});
		btnCreate.setBounds(169, 208, 89, 23);
		frame.getContentPane().add(btnCreate);
		
		lblNewLabel = new JLabel("Title");
		lblNewLabel.setBounds(28, 102, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textTitle = new JTextField();
		textTitle.setBounds(28, 124, 141, 20);
		frame.getContentPane().add(textTitle);
		textTitle.setColumns(10);
	}
}
