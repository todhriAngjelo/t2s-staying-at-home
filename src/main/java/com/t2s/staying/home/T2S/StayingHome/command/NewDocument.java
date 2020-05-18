package com.t2s.staying.home.T2S.StayingHome.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

import org.springframework.util.StringUtils;

import com.t2s.staying.home.T2S.StayingHome.view.NewDocumentView;

public class NewDocument implements ActionListener {

	public static final String SAVE_BUTTON_DIALOG_TITLE = "Specify the file to save:";

	private NewDocumentView view;

	public NewDocument(NewDocumentView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JFileChooser dialog = new JFileChooser();
		dialog.setDialogTitle(SAVE_BUTTON_DIALOG_TITLE);
		if (dialog.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			saveFile(dialog.getSelectedFile().getAbsolutePath());
		}
	}

	private void saveFile(String filepath) {
		try {
			if (StringUtils.endsWithIgnoreCase(filepath, ".txt")) {
				filepath = filepath.concat(".txt");
			}

			File myObj = new File(filepath);
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
