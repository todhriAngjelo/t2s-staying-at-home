package com.t2s.staying.home.T2S.StayingHome.view;

import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.*;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.t2s.staying.home.T2S.StayingHome.factory.CommandsFactory;

public class CreateDocument {

	private CommandsFactory commandsFactory = new CommandsFactory();

	private JFrame frame;
	private JLabel titleLabel;
	private JLabel authorLabel;
	private JTextField titleValue;
	private JTextField authorValue;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateDocument window = new CreateDocument();
					window.frame.setVisible(true);
					//theme
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
	private void initialize() {
		// window frame
		frame = new JFrame();
		frame.setBounds(400, 400, 446, 330);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		authorLabel = new JLabel(AUTHOR_LABEL_VALUE);
		authorLabel.setBounds(28, 37, 86, 14);
		frame.getContentPane().add(authorLabel);

		authorValue = new JTextField();
		authorValue.setBounds(28, 63, 141, 20); //
		frame.getContentPane().add(authorValue);
		authorValue.setColumns(10);

		titleLabel = new JLabel(TITLE_LABEL_VALUE);
		titleLabel.setBounds(28, 102, 46, 14);
		frame.getContentPane().add(titleLabel);

		titleValue = new JTextField();
		titleValue.setBounds(28, 124, 141, 20);
		frame.getContentPane().add(titleValue);
		titleValue.setColumns(10);

		JButton btnCreate = new JButton(CREATE_BUTTON_CONTENT);
		ActionListener newDocumentActionListener = commandsFactory.createCommand(NEW_DOCUMENT_COMMAND);
		btnCreate.addActionListener(newDocumentActionListener); // setup button action listener

		btnCreate.setBounds(169, 208, 89, 23);
		frame.getContentPane().add(btnCreate);
	}
}