package com.t2s.staying.home.T2S.StayingHome.view;

import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainView {

	private JButton btnLoadButton;
	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				MainView window = new MainView();
				window.frame.setVisible(true);
				//theme
				//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public MainView() {
		initialize();
	}

	private void initialize() {
		// window frame
		frame = new JFrame();
		frame.setBounds(400, 400, 446, 330);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel welcomeToT2SEditorLabel = new JLabel(WELCOME_TO_T2S_LABEL_CONTENTS);
		welcomeToT2SEditorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeToT2SEditorLabel.setFont(DEFAULT_FONT_SETTINGS);
		welcomeToT2SEditorLabel.setBounds(10, 31, 410, 44);
		frame.getContentPane().add(welcomeToT2SEditorLabel);
		
		JButton createEmptyDocButton = new JButton(CREATE_EMPTY_DOCUMENT_BUTTON_TEXT);
		createEmptyDocButton.setBackground(Color.WHITE);
		createEmptyDocButton.addActionListener(arg0 -> {
			new toDelete();
			frame.setVisible(false);
		});
		createEmptyDocButton.setBounds(38, 99, 188, 23);
		frame.getContentPane().add(createEmptyDocButton);
		
		JButton exitApplicationButton = new JButton(EXIT_APPLICATION_BUTTON_TEXT);
		exitApplicationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		exitApplicationButton.setBounds(38, 235, 188, 23);
		frame.getContentPane().add(exitApplicationButton);
		
		JButton editExistingDocumentButton = new JButton(EDIT_EXISTING_DOCUMENT_BUTTON_TEXT);
		editExistingDocumentButton.setBackground(Color.WHITE);
		editExistingDocumentButton.addActionListener(arg0 -> {
			new DocumentEditorView();
			frame.setVisible(false);
		});
		editExistingDocumentButton.setBounds(38, 133, 188, 23);
		frame.getContentPane().add(editExistingDocumentButton);
		
		JButton replayLastCommadSequencyButtton = new JButton("Replay last command sequence");
		replayLastCommadSequencyButtton.setBackground(Color.WHITE);
		replayLastCommadSequencyButtton.setBounds(38, 167, 188, 23);
		frame.getContentPane().add(replayLastCommadSequencyButtton);
		
		JButton btnApplicationsSettings = new JButton("Application's settings");
		btnApplicationsSettings.setBackground(Color.WHITE);
		btnApplicationsSettings.setBounds(38, 201, 188, 23);
		frame.getContentPane().add(btnApplicationsSettings);

//		authorLabel = new JLabel(AUTHOR_LABEL_VALUE);
//		authorLabel.setBounds(28, 37, 86, 14);
//		frame.getContentPane().add(authorLabel);
	}
}
