package com.t2s.staying.home.T2S.StayingHome.view;

import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.*;

import java.awt.*;

import javax.swing.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.t2s.staying.home.T2S.StayingHome.command.OpenDocument;
import com.t2s.staying.home.T2S.StayingHome.command.SaveDocument;
import com.t2s.staying.home.T2S.StayingHome.factory.CommandsFactory;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DocumentEditorView {
	private final Logger log = LoggerFactory.getLogger(DocumentEditorView.class);
	public String fileName;

	private CommandsFactory commandsFactory = new CommandsFactory();
	private JFrame frame;

	JFileChooser jFileChooser = new JFileChooser();
	StringBuilder sb = new StringBuilder();
	public JTextField textArea;
	private JTextField textField;
	private JTextField textField_1;

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
		OpenDocument openDocumentActionListener = (OpenDocument) commandsFactory.createCommand(OPEN_DOCUMENT_COMMAND, this);

		textArea = new JTextField();
		textArea.setBounds(10, 92, 459, 414);
		frame.getContentPane().add(textArea);
		textArea.setColumns(10);

		JLabel lblNewLabel = new JLabel("Text Area");
		lblNewLabel.setBounds(10, 67, 89, 14);
		frame.getContentPane().add(lblNewLabel);
		SaveDocument saveDocumentActionListener = (SaveDocument) commandsFactory.createCommand(SAVE_DOCUMENT_COMMAND, this);
		
		JLabel creationTimestampLabel = new JLabel("Creation Date");
		creationTimestampLabel.setBounds(511, 264, 86, 14);
		frame.getContentPane().add(creationTimestampLabel);
		
		JLabel creationTimestampPlaceholder = new JLabel("-");
		creationTimestampPlaceholder.setBounds(537, 284, 86, 14);
		frame.getContentPane().add(creationTimestampPlaceholder);
		
		JLabel lModifiedTimestampLabel = new JLabel("Last Modified Date");
		lModifiedTimestampLabel.setBounds(511, 309, 86, 14);
		frame.getContentPane().add(lModifiedTimestampLabel);
		
		JLabel lModifiedTimestampPlaceholder = new JLabel("-");
		lModifiedTimestampPlaceholder.setBounds(537, 329, 86, 14);
		frame.getContentPane().add(lModifiedTimestampPlaceholder);
		
		JButton btnDelte = new JButton("Delete");
		btnDelte.setBounds(506, 435, 130, 23);
		frame.getContentPane().add(btnDelte);
		
		JButton button_1 = new JButton("Save");
		button_1.setBounds(506, 469, 130, 23);
		frame.getContentPane().add(button_1);
		
		JButton btnTextSpeech_1 = new JButton("Transform all");
		btnTextSpeech_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTextSpeech_1.setBounds(506, 77, 130, 23);
		frame.getContentPane().add(btnTextSpeech_1);
		
		JButton button_4 = new JButton("< Main Menu");
		button_4.setBounds(506, 401, 130, 23);
		frame.getContentPane().add(button_4);
		
		JLabel label = new JLabel("Author's Name");
		label.setBounds(10, 10, 101, 14);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 36, 130, 20);
		frame.getContentPane().add(textField);
		
		JLabel label_1 = new JLabel("Document Title");
		label_1.setBounds(169, 10, 130, 14);
		frame.getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(169, 36, 130, 20);
		frame.getContentPane().add(textField_1);
		
		JButton btnTextSelected = new JButton("Transform selected");
		btnTextSelected.setVerticalAlignment(SwingConstants.TOP);
		btnTextSelected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTextSelected.setBounds(506, 109, 130, 23);
		frame.getContentPane().add(btnTextSelected);
		
		JLabel lblTransformToSpeech = new JLabel("Transform to speech");
		lblTransformToSpeech.setForeground(SystemColor.desktop);
		lblTransformToSpeech.setVerticalAlignment(SwingConstants.TOP);
		lblTransformToSpeech.setHorizontalAlignment(SwingConstants.LEFT);
		lblTransformToSpeech.setBounds(506, 38, 130, 14);
		frame.getContentPane().add(lblTransformToSpeech);
		
		JLabel lblOptions = new JLabel("options:");
		lblOptions.setVerticalAlignment(SwingConstants.TOP);
		lblOptions.setHorizontalAlignment(SwingConstants.LEFT);
		lblOptions.setBounds(506, 52, 130, 14);
		frame.getContentPane().add(lblOptions);
		
		JLabel lblEncodingOptions = new JLabel("Encoding options:");
		lblEncodingOptions.setVerticalAlignment(SwingConstants.TOP);
		lblEncodingOptions.setHorizontalAlignment(SwingConstants.LEFT);
		lblEncodingOptions.setBounds(506, 151, 130, 14);
		frame.getContentPane().add(lblEncodingOptions);
		
		JButton btnTransformAll = new JButton("Transform all");
		btnTransformAll.setBounds(506, 171, 130, 23);
		frame.getContentPane().add(btnTransformAll);
		
		JButton button_3 = new JButton("Transform selected");
		button_3.setVerticalAlignment(SwingConstants.TOP);
		button_3.setBounds(506, 203, 130, 23);
		frame.getContentPane().add(button_3);
	}

/*private void saveFile(String fileName) {
		try {
			FileWriter writer = new FileWriter(fileName);
			textArea.write(writer);
			writer.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(btnSave, this, "File" + fileName + "can't be saved.", 0);

		}
	}
*/
		public void openFile() {
				return;
		}
}







/*public void actionPerformed(ActionEvent e) {
String	cn = textChooseN.getText()	.toString();
String  an = textAuthorsN.getText().toString();
String  ta = textArea.getText()	.toString();

try {
	FileWriter writer = new FileWriter("chris.txt",true);
	writer.write(cn);
	writer.write(System.getProperty("line.separator"));
	writer.write(an);
	writer.write(System.getProperty("line.separator"));
	writer.write(ta);
	writer.write(System.getProperty("line.separator"));
	writer.close();
	JOptionPane.showMessageDialog(getRootPane(), "Success");


} catch(Exception e1) {

	JOptionPane.showMessageDialog(getRootPane(), "Error");

}

JFileChooser fc=new JFileChooser();
				fc.showSaveDialog(null);
				File f=fc.getSelectedFile()	;
				try {
					FileWriter fw=new FileWriter(f);
					String text =textArea.getText();
					fw.write(text);
					fw.close();
			    }
				catch(IOException e1){
					System.out.println(e1);
				}

} */