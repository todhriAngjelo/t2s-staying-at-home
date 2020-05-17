package com.t2s.staying.home.T2S.StayingHome.command;

import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.AUTHOR_METADATA_NAME;

import com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView;
import com.t2s.staying.home.T2S.utils.FileUtils;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class SaveDocument implements ActionListener {

	private DocumentEditorView view;

	public SaveDocument(DocumentEditorView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser dialog = new JFileChooser();
		dialog.setDialogTitle("Specify a file to save:");
		if (dialog.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			saveFile(dialog.getSelectedFile().getAbsolutePath());
		}

	}

	private void saveFile(String filepath) {
		try {
			FileWriter writer = new FileWriter(filepath);

//			FileUtils.setFileMetadata(filepath, AUTHOR_METADATA_NAME, view.get)

			writer.close();
		} catch (IOException e) {


		}
	}
}
