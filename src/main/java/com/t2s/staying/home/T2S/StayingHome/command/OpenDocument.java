package com.t2s.staying.home.T2S.StayingHome.command;

import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;

import com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView;


public class OpenDocument implements ActionListener {

	private DocumentEditorView openDocumentView;
	private String fileName;
	private JTextField textArea;

	public OpenDocument(DocumentEditorView openDocumentView){this.openDocumentView =openDocumentView;}


	@Override
	public void actionPerformed(java.awt.event.ActionEvent e) {
		JFileChooser dialog = new JFileChooser();
		if (dialog.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			openFile(dialog.getSelectedFile().getAbsolutePath());
		}
	}




	public void openFile(String absolutePath) {
		try {
			FileReader reader = new FileReader(fileName);
			//textArea.read(reader, null);
			reader.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
//		openDocumentView.openFile();
	}


	


}
