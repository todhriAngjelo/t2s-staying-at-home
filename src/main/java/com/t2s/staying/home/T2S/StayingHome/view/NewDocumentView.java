package com.t2s.staying.home.T2S.StayingHome.view;

import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.t2s.staying.home.T2S.StayingHome.command.NewDocument;
import com.t2s.staying.home.T2S.StayingHome.factory.CommandsFactory;
import com.t2s.staying.home.T2S.StayingHome.model.Document;

public class NewDocumentView {

	private final Logger log = LoggerFactory.getLogger(NewDocumentView.class);

	private CommandsFactory commandsFactory = new CommandsFactory();

	private JFrame frame;
	private JLabel titleLabel;
	private JLabel authorLabel;
	private static JTextField titleValue;
	private static JTextField authorValue;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				NewDocumentView window = new NewDocumentView();
				window.frame.setVisible(true);
				//theme
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public NewDocumentView() {
		initialize();
	}

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
		NewDocument newDocumentActionListener = (NewDocument) commandsFactory.createCommand(NEW_DOCUMENT_COMMAND, this);
		btnCreate.addActionListener(newDocumentActionListener); // setup button action listener

 		btnCreate.setBounds(169, 208, 89, 23);
		frame.getContentPane().add(btnCreate);
	}

	public String getDocumentTitle() {
		return titleValue.getText();
	}

	public String getDocumentAuthor() {
		return titleValue.getText();
	}
}