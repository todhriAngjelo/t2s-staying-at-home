package com.t2s.staying.home.T2S.StayingHome.view;

import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.*;

import java.awt.event.ActionListener;

import javax.swing.*;

import com.t2s.staying.home.T2S.StayingHome.factory.CommandsFactory;

public class NewDocumentView {

	private CommandsFactory commandsFactory = new CommandsFactory();

	private static final String SAVE_US_BUTTON_TEXT = "Save file";
	private static final String RETURN_TO_MAIN_MENU_BUTTON_TEXT = "< Main Menu";
	private static final String AUTHORS_NAME_LABEL_TEXT = "Author's name:";
	private static final String DOCUMENT_TITLE_LABEL_TEXT = "Document title:";

	private JFrame frame;
	private JTextField authorTextField;
	private JTextField documentTitleTextField;

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

		JLabel authorLabel = new JLabel(AUTHORS_NAME_LABEL_TEXT);
		authorLabel.setBounds(41, 36, 101, 14);
		frame.getContentPane().add(authorLabel);
		
		authorTextField = new JTextField();
		authorTextField.setColumns(10);
		authorTextField.setBounds(41, 62, 130, 20);
		frame.getContentPane().add(authorTextField);
		
		JLabel documentTitleLabel = new JLabel(DOCUMENT_TITLE_LABEL_TEXT);
		documentTitleLabel.setBounds(41, 93, 130, 14);
		frame.getContentPane().add(documentTitleLabel);
		
		documentTitleTextField = new JTextField();
		documentTitleTextField.setColumns(10);
		documentTitleTextField.setBounds(41, 119, 130, 20);
		frame.getContentPane().add(documentTitleTextField);
	}

	public void showMessageDialog(String message) {
		JOptionPane.showMessageDialog(frame, message);
	}

	public void goToMainView() {
		new MainView();
		frame.setVisible(false);
	}

	// getters
	public String getAuthorTextField() {
		return authorTextField.getText();
	}

	public String getDocumentTitleTextField() {
		return documentTitleTextField.getText();
	}

	public void setAuthorTextField(JTextField authorTextField) {
		this.authorTextField = authorTextField;
	}

	public void setDocumentTitleTextField(JTextField documentTitleTextField) {
		this.documentTitleTextField = documentTitleTextField;
	}

	public JTextField getAuthorJTextField() {
		return authorTextField;
	}

	public JTextField getDocumentTitleJTextField() {
		return documentTitleTextField;
	}
}
