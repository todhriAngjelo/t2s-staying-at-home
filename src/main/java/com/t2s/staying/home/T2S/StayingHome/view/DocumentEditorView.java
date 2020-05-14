package com.t2s.staying.home.T2S.StayingHome.view;

import com.t2s.staying.home.T2S.StayingHome.factory.CommandsFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.*;

public class DocumentEditorView {

	private CommandsFactory commandsFactory = new CommandsFactory();
	private final Logger log = LoggerFactory.getLogger(DocumentEditorView.class);

	private static final String LAST_MODIFIED_TIMESTAMP_LABEL = "Last Modified Date";
	private static final String CREATION_TIMESTAMP_LABEL = "Creation Date";
	private static final String TEXT_AREA_LABEL = "Text Area";
	private static final String DOCUMENT_TITLE_LABEL = "Document Title";
	private static final String TRANSFORM_TO_SPEECH_LABEL_TEXT1 = "Transform to speech";
	private static final String TRANSFORM_TO_SPEECH_LABEL_TEXT2 = "options:";
	private static final String ENCODE_LABEL = "Encoding options:";
	private static final String AUTHORS_NAME_LABEL = "Author's Name";

	private static final String LOAD_BUTTON_TEXT = "Load";
	private static final String SAVE_BUTTON_TEXT = "Save";
	private static final String TRANSFORM_ALL_BUTTON_TEXT = "Transform all";
	private static final String TRANSFORM_SELECTED_BUTTON_TEXT = "Transform selected";
	private static final String RETURN_TO_MAIN_MENU_BUTTON_TEXT = "< Main Menu";

	private JFrame frame;
	private  JTextArea textArea;
	private JTextField authorTextField;
	private JTextField documentTitleTextField;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				DocumentEditorView window = new DocumentEditorView();
				window.frame.setVisible(true);
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
		frame.setBounds(100, 100, 675, 556);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textArea = new JTextArea();

		textArea.setBounds(10, 92, 459, 414);
		frame.getContentPane().add(textArea);
		textArea.setColumns(10);

		JLabel textAreaLabel = new JLabel(TEXT_AREA_LABEL);
		textAreaLabel.setBounds(10, 67, 89, 14);
		frame.getContentPane().add(textAreaLabel);
		
		JLabel creationTimestampLabel = new JLabel(CREATION_TIMESTAMP_LABEL);
		creationTimestampLabel.setBounds(511, 264, 86, 14);
		frame.getContentPane().add(creationTimestampLabel);
		
		JLabel creationTimestampPlaceholder = new JLabel("-"); // init value that is going to be modified
		creationTimestampPlaceholder.setBounds(537, 284, 86, 14);
		frame.getContentPane().add(creationTimestampPlaceholder);
		
		JLabel lModifiedTimestampLabel = new JLabel(LAST_MODIFIED_TIMESTAMP_LABEL);
		lModifiedTimestampLabel.setBounds(511, 309, 86, 14);
		frame.getContentPane().add(lModifiedTimestampLabel);
		
		JLabel lModifiedTimestampPlaceholder = new JLabel("-"); // init value that is going to be modified
		lModifiedTimestampPlaceholder.setBounds(537, 329, 86, 14);
		frame.getContentPane().add(lModifiedTimestampPlaceholder);


		//------LOAD BUTTON-----//
		JButton loadButton = new JButton(LOAD_BUTTON_TEXT);
		ActionListener loadDocumentActionListener = commandsFactory.createCommand(OPEN_DOCUMENT_COMMAND, this);
		loadButton.addActionListener(loadDocumentActionListener);
		loadButton.setBounds(506, 435, 130, 23);
		frame.getContentPane().add(loadButton);

		//------SAVE-----//
		JButton saveButton = new JButton(SAVE_BUTTON_TEXT);

		ActionListener saveDocumentActionListener = commandsFactory.createCommand(SAVE_DOCUMENT_COMMAND, this);
		saveButton.addActionListener(saveDocumentActionListener);
		saveButton.setBounds(506, 469, 130, 23);
		frame.getContentPane().add(saveButton);

		//------ DocumentToSpeech -----//
		JButton ttsAllButton = new JButton(TRANSFORM_ALL_BUTTON_TEXT);
		ActionListener doc2SpeechActionListener = commandsFactory.createCommand(DOC_TO_SPEECH_COMMAND, this);
		ttsAllButton.addActionListener(doc2SpeechActionListener);
		ttsAllButton.setBounds(506, 77, 130, 23);
		frame.getContentPane().add(ttsAllButton);

		//------ Back To MainMenu ----//
		JButton returnToMainMenuButton = new JButton(RETURN_TO_MAIN_MENU_BUTTON_TEXT);
		returnToMainMenuButton.setBounds(506, 401, 130, 23);
		frame.getContentPane().add(returnToMainMenuButton);
		returnToMainMenuButton.addActionListener(e -> {
			new MainView();
			frame.setVisible(false);
		});

		JLabel authorLabel = new JLabel(AUTHORS_NAME_LABEL);
		authorLabel.setBounds(10, 10, 101, 14);
		frame.getContentPane().add(authorLabel);

		authorTextField = new JTextField();
		authorTextField.setColumns(10);
		authorTextField.setBounds(10, 36, 130, 20);
		frame.getContentPane().add(authorTextField);

		JLabel documentTitleLabel = new JLabel(DOCUMENT_TITLE_LABEL);
		documentTitleLabel.setBounds(169, 10, 130, 14);
		frame.getContentPane().add(documentTitleLabel);

		documentTitleTextField = new JTextField();
		documentTitleTextField.setColumns(10);
		documentTitleTextField.setBounds(169, 36, 130, 20);
		frame.getContentPane().add(documentTitleTextField);

		//---- LineToSpeech -----//
		JButton ttsSelectedButton = new JButton(TRANSFORM_SELECTED_BUTTON_TEXT);
		ActionListener line2SpeechActionListener = commandsFactory.createCommand(LINE_TO_SPEECH, this);
		ttsSelectedButton.addActionListener(line2SpeechActionListener);
		//ttsSelectedButton.setVerticalAlignment(SwingConstants.TOP);
		//ttsSelectedButton.addActionListener(e -> {
		//});
		//});
		ttsSelectedButton.setBounds(506, 109, 130, 23);
		frame.getContentPane().add(ttsSelectedButton);

		JLabel transformToSpeechLabel1 = new JLabel(TRANSFORM_TO_SPEECH_LABEL_TEXT1);
		transformToSpeechLabel1.setForeground(SystemColor.desktop);
		transformToSpeechLabel1.setVerticalAlignment(SwingConstants.TOP);
		transformToSpeechLabel1.setHorizontalAlignment(SwingConstants.LEFT);
		transformToSpeechLabel1.setBounds(506, 38, 130, 14);
		frame.getContentPane().add(transformToSpeechLabel1);

		JLabel transformToSpeechLabel2 = new JLabel(TRANSFORM_TO_SPEECH_LABEL_TEXT2);
		transformToSpeechLabel2.setVerticalAlignment(SwingConstants.TOP);
		transformToSpeechLabel2.setHorizontalAlignment(SwingConstants.LEFT);
		transformToSpeechLabel2.setBounds(506, 52, 130, 14);
		frame.getContentPane().add(transformToSpeechLabel2);

		JLabel encodingOptionsLabel = new JLabel(ENCODE_LABEL);
		encodingOptionsLabel.setVerticalAlignment(SwingConstants.TOP);
		encodingOptionsLabel.setHorizontalAlignment(SwingConstants.LEFT);
		encodingOptionsLabel.setBounds(506, 151, 130, 14);
		frame.getContentPane().add(encodingOptionsLabel);

		JButton encodeAllButton = new JButton(TRANSFORM_ALL_BUTTON_TEXT);
		encodeAllButton.setBounds(506, 171, 130, 23);
		frame.getContentPane().add(encodeAllButton);

		JButton encodeSelectedButton = new JButton(TRANSFORM_SELECTED_BUTTON_TEXT);
		encodeSelectedButton.setVerticalAlignment(SwingConstants.TOP);
		encodeSelectedButton.setBounds(506, 203, 130, 23);
		frame.getContentPane().add(encodeSelectedButton);
	}

	public String getTextArea(){
		return textArea.getText();
	}
	public JTextArea getJTextArea(){
		return textArea;
	}
	public void setTextArea(JTextArea txt){
		this.textArea=txt;

	}
	public void setAuthorTextField(String author){
		this.authorTextField.setText(author);
	}

}