package com.t2s.staying.home.T2S.StayingHome.command;

import com.t2s.staying.home.T2S.StayingHome.view.EditDocumentView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;


public class SaveDocument implements ActionListener {
	private EditDocumentView saveDocumentView;
	public SaveDocument(EditDocumentView saveDocumentView) {
		this.saveDocumentView = saveDocumentView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			JFileChooser dialog = new JFileChooser();
			if (dialog.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				saveFile(dialog.getSelectedFile().getAbsolutePath());
			}

	}


	private void saveFile(String fileName) {
		try {
			FileWriter writer = new FileWriter(fileName);
			writer.close();
		} catch (IOException e) {


		}
	}
}
