package com.t2s.staying.home.T2S.StayingHome.view;

import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.*;

import java.awt.event.ActionListener;

import javax.swing.*;

import com.t2s.staying.home.T2S.StayingHome.factory.CommandsFactory;

public class NewDocumentView {

	private CommandsFactory commandsFactory = new CommandsFactory();

	private static final String DOCUMENT_TITLE_LABEL_TEXT = "Document title:";
	private static final String AUTHORS_NAME_LABEL_TEXT = "Author's name:";
	private static final String VOICE_VOLUME_LABEL_TEXT = "Voice volume";

	private static final String SAVE_US_BUTTON_TEXT = "Save file";
	private static final String RETURN_TO_MAIN_MENU_BUTTON_TEXT = "< Main Menu";
	private static final String REVERSE_ALL_BUTTON_TEXT = "Reverse all:";
	private static final String REVERSE_SELECTED_BUTTON_TEXT = "Reverse selected";

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * @wbp.parser.entryPoint
	 */
	public NewDocumentView() {
		initialize();
		this.frame.setVisible(true);

	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(400, 400, 446, 330);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton saveButton = new JButton(SAVE_US_BUTTON_TEXT);
   		ActionListener saveDocumentActionListener = commandsFactory.createCommand(NEW_DOCUMENT_COMMAND, this);
		saveButton.addActionListener(saveDocumentActionListener);
		saveButton.setBounds(278, 237, 130, 23);
		frame.getContentPane().add(saveButton);
		
		JButton returnToMainMenuButton = new JButton(RETURN_TO_MAIN_MENU_BUTTON_TEXT);
		returnToMainMenuButton.setBounds(278, 203, 130, 23);
		returnToMainMenuButton.addActionListener(e -> {
			new MainView();
			frame.setVisible(false);
		});
		frame.getContentPane().add(returnToMainMenuButton);

		JLabel label = new JLabel(AUTHORS_NAME_LABEL_TEXT);
		label.setBounds(41, 36, 101, 14);
		frame.getContentPane().add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(41, 62, 130, 20);
		frame.getContentPane().add(textField_1);
		
		JLabel label_1 = new JLabel(DOCUMENT_TITLE_LABEL_TEXT);
		label_1.setBounds(41, 93, 130, 14);
		frame.getContentPane().add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(41, 119, 130, 20);
		frame.getContentPane().add(textField_2);
	}

	public void showErrorDialog(String message) {
		JOptionPane.showMessageDialog(frame, message);
	}

	public void goToMainView() {
		new MainView();
		frame.setVisible(false);
	}

}
