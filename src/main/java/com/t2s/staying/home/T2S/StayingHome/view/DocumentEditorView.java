package com.t2s.staying.home.T2S.StayingHome.view;

import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Caret;
import javax.swing.text.Document;
import javax.swing.text.EditorKit;
import javax.swing.text.ViewFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.t2s.staying.home.T2S.StayingHome.factory.CommandsFactory;

public class DocumentEditorView {

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
	private static final String UPDATE_BUTTON_TEXT = "Update";
	private static final String RETURN_TO_MAIN_MENU_BUTTON_TEXT = "< Main Menu";
	private static final String REVERSE_ALL_BUTTON_TEXT = "Reverse all:";
	private static final String REVERSE_SELECTED_BUTTON_TEXT = "Reverse selected";

	private JFrame frame;
	private JTextField authorTextField;
	private JTextField documentTitleTextField;
	private JLabel creationTimestampPlaceholder;
	private JLabel lModifiedTimestampPlaceholder;
	public JTextPane textPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				DocumentEditorView window = new DocumentEditorView();
				window.frame.setVisible(true);
				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public DocumentEditorView() {
		initialize();
		this.frame.setVisible(true);

	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 895, 544);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel textAreaLabel = new JLabel(TEXT_AREA_LABEL_TEXT);
		textAreaLabel.setBounds(10, 11, 89, 14);
		frame.getContentPane().add(textAreaLabel);

		JLabel creationTimestampLabel = new JLabel(CREATION_TIMESTAMP_LABEL_TEXT);
		creationTimestampLabel.setBounds(569, 407, 86, 14);
		frame.getContentPane().add(creationTimestampLabel);

		creationTimestampPlaceholder = new JLabel("-"); // init value that is going to be modified
		creationTimestampPlaceholder.setBounds(569, 431, 146, 14);
		frame.getContentPane().add(creationTimestampPlaceholder);

		JLabel lModifiedTimestampLabel = new JLabel(LAST_MODIFIED_TIMESTAMP_LABEL_TEXT);
		lModifiedTimestampLabel.setBounds(569, 450, 110, 14);
		frame.getContentPane().add(lModifiedTimestampLabel);

		lModifiedTimestampPlaceholder = new JLabel("-"); // init value that is going to be modified
		lModifiedTimestampPlaceholder.setBounds(572, 474, 146, 14);
		frame.getContentPane().add(lModifiedTimestampPlaceholder);

		//------LOAD BUTTON-----//
		JButton loadButton = new JButton(LOAD_BUTTON_TEXT);
		ActionListener loadDocumentActionListener = commandsFactory.createCommand(OPEN_DOCUMENT_COMMAND, this);
		loadButton.addActionListener(loadDocumentActionListener);
		loadButton.setBounds(728, 437, 130, 23);
		frame.getContentPane().add(loadButton);

		//------SAVE-----//
		JButton saveButton = new JButton(UPDATE_BUTTON_TEXT);

		ActionListener saveDocumentActionListener = commandsFactory.createCommand(SAVE_DOCUMENT_COMMAND, this);
		saveButton.addActionListener(saveDocumentActionListener);
		saveButton.setBounds(728, 471, 130, 23);
		frame.getContentPane().add(saveButton);

		//------ DocumentToSpeech -----//
		JButton ttsAllButton = new JButton(ALL_LINES_BUTTON_TEXT);
		ActionListener doc2SpeechActionListener = commandsFactory.createCommand(DOC_TO_SPEECH_COMMAND, this);
		ttsAllButton.addActionListener(doc2SpeechActionListener);
		ttsAllButton.setBounds(567, 46, 130, 23);
		frame.getContentPane().add(ttsAllButton);

		//------ Back To MainMenu ----//
		JButton returnToMainMenuButton = new JButton(RETURN_TO_MAIN_MENU_BUTTON_TEXT);
		returnToMainMenuButton.setBounds(728, 403, 130, 23);
		frame.getContentPane().add(returnToMainMenuButton);
		returnToMainMenuButton.addActionListener(e -> {
			new MainView();
			frame.setVisible(false);
		});

		JLabel authorLabel = new JLabel(AUTHORS_NAME_LABEL_TEXT);
		authorLabel.setBounds(567, 220, 101, 14);
		frame.getContentPane().add(authorLabel);

		authorTextField = new JTextField();
		authorTextField.setColumns(10);
		authorTextField.setBounds(567, 246, 130, 20);
		frame.getContentPane().add(authorTextField);

		JLabel documentTitleLabel = new JLabel(DOCUMENT_TITLE_LABEL_TEXT);
		documentTitleLabel.setBounds(728, 220, 130, 14);
		frame.getContentPane().add(documentTitleLabel);

		documentTitleTextField = new JTextField();
		documentTitleTextField.setColumns(10);
		documentTitleTextField.setBounds(728, 246, 130, 20);
		frame.getContentPane().add(documentTitleTextField);

		//---- LineToSpeech -----//
		JButton ttsSelectedButton = new JButton(SELECTED_LINE_BUTTON_TEXT);
		ActionListener line2SpeechActionListener = commandsFactory.createCommand(LINE_TO_SPEECH, this);
		ttsSelectedButton.addActionListener(line2SpeechActionListener);
		ttsSelectedButton.setBounds(567, 77, 130, 23);
		frame.getContentPane().add(ttsSelectedButton);

		JLabel transformToSpeechLabel1 = new JLabel(TRANSFORM_TO_SPEECH_LABEL_TEXT);
		transformToSpeechLabel1.setForeground(SystemColor.desktop);
		transformToSpeechLabel1.setVerticalAlignment(SwingConstants.TOP);
		transformToSpeechLabel1.setHorizontalAlignment(SwingConstants.LEFT);
		transformToSpeechLabel1.setBounds(567, 21, 112, 14);
		frame.getContentPane().add(transformToSpeechLabel1);

		JLabel encodeOptionAtBashLabel = new JLabel(ENCODE_DOCUMENT_ATBASH_LABEL_TEXT);
		encodeOptionAtBashLabel.setVerticalAlignment(SwingConstants.TOP);
		encodeOptionAtBashLabel.setHorizontalAlignment(SwingConstants.LEFT);
		encodeOptionAtBashLabel.setBounds(567, 293, 141, 14);
		frame.getContentPane().add(encodeOptionAtBashLabel);

		JButton encodeAllButton = new JButton(ALL_LINES_BUTTON_TEXT);
		encodeAllButton.setBounds(567, 317, 130, 23);
		frame.getContentPane().add(encodeAllButton);

		JButton encodeSelectedButton = new JButton(SELECTED_LINE_BUTTON_TEXT);
		encodeSelectedButton.setVerticalAlignment(SwingConstants.TOP);
		encodeSelectedButton.setBounds(567, 350, 130, 23);
		frame.getContentPane().add(encodeSelectedButton);

		JLabel reversedTtsLabel = new JLabel(TRANSFORM_TO_SPEECH_REVERSED_LABEL_TEXT);
		reversedTtsLabel.setBounds(718, 21, 156, 13);
		frame.getContentPane().add(reversedTtsLabel);

		// ----- Reverse ALL -----//
		JButton reverseAllButton = new JButton(ALL_LINES_BUTTON_TEXT);
		ActionListener reverseAllActionListener = commandsFactory.createCommand(REVERSE_ALL_COMMAND, this);
		reverseAllButton.addActionListener(reverseAllActionListener);
		reverseAllButton.setBounds(718, 46, 130, 23);
		frame.getContentPane().add(reverseAllButton);

		// ----- Reverse Line -----//
		JButton reverseLineButton_1 = new JButton(SELECTED_LINE_BUTTON_TEXT);
		ActionListener reverseLineActionListener = commandsFactory.createCommand(REVERSE_LINE_COMMAND, this);
		reverseLineButton_1.addActionListener(reverseLineActionListener);
		reverseLineButton_1.setBounds(718, 77, 130, 23);
		frame.getContentPane().add(reverseLineButton_1);

		//---------Rot13 all lines--------//
		JButton button = new JButton(ALL_LINES_BUTTON_TEXT);
		ActionListener RotAllLinesActionListener = commandsFactory.createCommand(ROT_ALL_LINES_COMMAND, this);
		button.addActionListener(RotAllLinesActionListener);
		button.setBounds(728, 317, 130, 23);
		frame.getContentPane().add(button);

		JButton button_1 = new JButton(SELECTED_LINE_BUTTON_TEXT);
		button_1.setVerticalAlignment(SwingConstants.TOP);
		button_1.setBounds(728, 350, 130, 23);
		frame.getContentPane().add(button_1);

		JLabel encodeOptionRot13Label = new JLabel(ENCODE_DOCUMENT_ROT13_LABEL_TEXT);
		encodeOptionRot13Label.setVerticalAlignment(SwingConstants.TOP);
		encodeOptionRot13Label.setHorizontalAlignment(SwingConstants.LEFT);
		encodeOptionRot13Label.setBounds(728, 293, 141, 14);
		frame.getContentPane().add(encodeOptionRot13Label);

		JSlider slider_1 = new JSlider();
		slider_1.setValue(0);
		slider_1.setBounds(678, 122, 170, 14);
		frame.getContentPane().add(slider_1);

		JLabel lblVoiceVolume = new JLabel(VOICE_VOLUME_LABEL_TEXT);
		lblVoiceVolume.setVerticalAlignment(SwingConstants.TOP);
		lblVoiceVolume.setHorizontalAlignment(SwingConstants.LEFT);
		lblVoiceVolume.setForeground(Color.BLACK);
		lblVoiceVolume.setBounds(567, 122, 62, 14);
		frame.getContentPane().add(lblVoiceVolume);

		JLabel lblVoicePitch = new JLabel("Voice pitch");
		lblVoicePitch.setVerticalAlignment(SwingConstants.TOP);
		lblVoicePitch.setHorizontalAlignment(SwingConstants.LEFT);
		lblVoicePitch.setForeground(Color.BLACK);
		lblVoicePitch.setBounds(567, 149, 62, 14);
		frame.getContentPane().add(lblVoicePitch);

		JSlider slider = new JSlider();
		slider.setValue(0);
		slider.setBounds(678, 149, 170, 14);
		frame.getContentPane().add(slider);

		JLabel lblVoiceRate = new JLabel("Voice rate");
		lblVoiceRate.setVerticalAlignment(SwingConstants.TOP);
		lblVoiceRate.setHorizontalAlignment(SwingConstants.LEFT);
		lblVoiceRate.setForeground(Color.BLACK);
		lblVoiceRate.setBounds(567, 179, 62, 14);
		frame.getContentPane().add(lblVoiceRate);

		JSlider slider_2 = new JSlider();
		slider_2.setValue(0);
		slider_2.setBounds(678, 179, 170, 14);
		frame.getContentPane().add(slider_2);

		textPane = new JTextPane();
		textPane.setBounds(10, 37, 515, 439);
		textPane.setContentType("text/html");
		frame.getContentPane().add(textPane);

	}


	public int getLineNumber() {
		return textPane.getCaretPosition();
	}
	public void showErrorDialog(String message) {
		JOptionPane.showMessageDialog(frame, message);
	}

	public void updateView(String docTitle, String docAuthor, String docCreationTime, String docLModifiedTime, String docText) {
		this.documentTitleTextField.setText(docTitle);
		this.authorTextField.setText(docAuthor);
		this.creationTimestampPlaceholder.setText(docCreationTime);
		this.lModifiedTimestampPlaceholder.setText(docLModifiedTime);
		this.textPane.setText(docText);
	}
}
