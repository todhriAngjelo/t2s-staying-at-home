package com.t2s.staying.home.T2S.StayingHome.command;

import com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView;
import com.t2s.staying.home.T2S.utils.FileUtils;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import static com.t2s.staying.home.T2S.utils.FileUtils.getFileBufferReader;


public class OpenDocument implements ActionListener {

	private static DocumentEditorView openDocumentView;

	public OpenDocument(DocumentEditorView openDocumentView){this.openDocumentView = openDocumentView;}

	@Override
	//change
	public void actionPerformed(java.awt.event.ActionEvent e) {
		JFileChooser dialog = new JFileChooser();
		if (dialog.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			System.out.println("Selected file: " +dialog.getSelectedFile().getAbsolutePath());
			BufferedReader buf = getFileBufferReader(dialog.getSelectedFile().getAbsolutePath());
			try {
				openDocumentView.getJTextArea().read(buf, null);
				buf.close();
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
			File file = FileUtils.getFileReader(dialog.getSelectedFile().getAbsolutePath());
			try {
				String string= FileUtils.getFileMetadata(dialog.getSelectedFile().getAbsolutePath(), "author");
				openDocumentView.setAuthorTextField(string);
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		}
	}
}
