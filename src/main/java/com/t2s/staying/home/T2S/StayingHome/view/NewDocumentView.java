package com.t2s.staying.home.T2S.StayingHome.view;

import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.*;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.t2s.staying.home.T2S.StayingHome.factory.CommandsFactory;

public class NewDocumentView {

	private CommandsFactory commandsFactory = new CommandsFactory();

	private static final String LAST_MODIFIED_TIMESTAMP_LABEL_TEXT = "Last modified date:";
	private static final String CREATION_TIMESTAMP_LABEL_TEXT = "Creation date:";
	private static final String TEXT_AREA_LABEL_TEXT = "Text area:";
	private static final String DOCUMENT_TITLE_LABEL_TEXT = "Document title:";
	private static final String TRANSFORM_TO_SPEECH_LABEL_TEXT = "Transform to speech:";
	private static final String TRANSFORM_TO_SPEECH_REVERSED_LABEL_TEXT = "Transform to speech reversed:";
	private static final String ENCODE_DOCUMENT_ATBASH_LABEL_TEXT = "Encode document(Atbash):";
	private static final String ENCODE_DOCUMENT_ROT13_LABEL_TEXT = "Encode document(Rot-13):";
	private static final String AUTHORS_NAME_LABEL_TEXT = "Author's name:";
	private static final String VOICE_VOLUME_LABEL_TEXT = "Voice volume";

	private static final String ALL_LINES_BUTTON_TEXT = "ALL";
	private static final String SELECTED_LINE_BUTTON_TEXT = "SELECTED LINE";
	private static final String LOAD_BUTTON_TEXT = "Load";
	private static final String UPDATE_BUTTON_TEXT = "Save";
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

		//------SAVE-----//
		JButton saveButton = new JButton("Save as");
		ActionListener saveDocumentActionListener = commandsFactory.createCommand(SAVE_DOCUMENT_COMMAND, this);
		saveButton.addActionListener(saveDocumentActionListener);
		saveButton.setBounds(276, 241, 130, 23);
		frame.getContentPane().add(saveButton);
		
		JButton button_1 = new JButton("< Main Menu");
		button_1.setBounds(276, 207, 130, 23);
		frame.getContentPane().add(button_1);
		
		JLabel label = new JLabel("Author's name:");
		label.setBounds(41, 36, 101, 14);
		frame.getContentPane().add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(41, 62, 130, 20);
		frame.getContentPane().add(textField_1);
		
		JLabel label_1 = new JLabel("Document title:");
		label_1.setBounds(41, 105, 130, 14);
		frame.getContentPane().add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(41, 131, 130, 20);
		frame.getContentPane().add(textField_2);

	}
}
