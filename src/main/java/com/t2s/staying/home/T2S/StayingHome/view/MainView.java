package com.t2s.staying.home.T2S.StayingHome.view;

import javax.swing.*;
import java.awt.*;

import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.DEFAULT_FONT_SETTINGS;

public class MainView {

	private static final String WELCOME_TO_T2S_LABEL_CONTENTS = "Welcome to T2S Editor";
	private static final String CREATE_EMPTY_DOCUMENT_BUTTON_TEXT = "Create new empty document";
	private static final String EXIT_APPLICATION_BUTTON_TEXT = "Exit application";
	private static final String OPEN_DOCUMENT_EDITOR_BUTTON_TEXT = "Open document editor";
	private static final String REPLAY_LAST_COMMAND_BUTTON_TEXT = "Replay last command sequence";

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				new MainView();
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
			new NewDocumentView();
			frame.setVisible(false);
		});
		createEmptyDocButton.setBounds(123, 99, 188, 23);
		frame.getContentPane().add(createEmptyDocButton);
		
		JButton exitApplicationButton = new JButton(EXIT_APPLICATION_BUTTON_TEXT);
		exitApplicationButton.addActionListener(e -> System.exit(0));
		exitApplicationButton.setBounds(123, 201, 188, 23);
		frame.getContentPane().add(exitApplicationButton);
		
		JButton openDocumentEditorButton = new JButton(OPEN_DOCUMENT_EDITOR_BUTTON_TEXT);
		openDocumentEditorButton.addActionListener(arg0 -> {
			new DocumentEditorView();
			frame.setVisible(false);
		});
		openDocumentEditorButton.setBounds(123, 133, 188, 23);
		frame.getContentPane().add(openDocumentEditorButton);

	}
}