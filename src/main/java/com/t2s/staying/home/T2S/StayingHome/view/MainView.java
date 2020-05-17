package com.t2s.staying.home.T2S.StayingHome.view;

import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.DEFAULT_FONT_SETTINGS;

import java.awt.*;

import javax.swing.*;

public class MainView {

	private static final String WELCOME_TO_T2S_LABEL_CONTENTS = "Welcome to T2S Editor";
	private static final String CREATE_EMPTY_DOCUMENT_BUTTON_TEXT = "Create new empty document";
	private static final String EXIT_APPLICATION_BUTTON_TEXT = "Exit application";
	private static final String EDIT_EXISTING_DOCUMENT_BUTTON_TEXT = "Edit existing document";
	private static final String REPLAY_LAST_COMMAND_BUTTON_TEXT = "Replay last command sequence";
	private static final String APPLICATION_SETTINGS_BUTTON_TEXT = "Application's settings";

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				new MainView();

				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
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
		this.frame.setVisible(true);
	}

	private void initialize() {
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
		createEmptyDocButton.addActionListener(arg0 -> {
			new DocumentEditorView();
			frame.setVisible(false);
		});
		createEmptyDocButton.setBounds(123, 99, 188, 23);
		frame.getContentPane().add(createEmptyDocButton);
		
		JButton exitApplicationButton = new JButton(EXIT_APPLICATION_BUTTON_TEXT);
		exitApplicationButton.addActionListener(e -> System.exit(0));
		exitApplicationButton.setBounds(123, 201, 188, 23);
		frame.getContentPane().add(exitApplicationButton);
		
		JButton editExistingDocumentButton = new JButton(EDIT_EXISTING_DOCUMENT_BUTTON_TEXT);
		editExistingDocumentButton.addActionListener(arg0 -> {
			new DocumentEditorView();
			frame.setVisible(false);
		});
		editExistingDocumentButton.setBounds(123, 133, 188, 23);
		frame.getContentPane().add(editExistingDocumentButton);

		JButton replayLastCommandSequenceButton = new JButton(REPLAY_LAST_COMMAND_BUTTON_TEXT);
		replayLastCommandSequenceButton.setBounds(123, 167, 188, 23);
		frame.getContentPane().add(replayLastCommandSequenceButton);
	}
}