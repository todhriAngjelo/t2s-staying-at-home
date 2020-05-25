package com.t2s.staying.home.T2S.StayingHome.command;

import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.AUTHOR_METADATA_NAME;
import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.TITLE_METADATA_NAME;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

import org.springframework.util.StringUtils;

import com.t2s.staying.home.T2S.StayingHome.view.NewDocumentView;
import com.t2s.staying.home.T2S.utils.FileUtils;

public class NewDocument implements ActionListener {

	public static final String SAVE_BUTTON_DIALOG_TITLE = "Specify the file to save:";

	private NewDocumentView view;
	JFileChooser dialog = new JFileChooser();

	public NewDocument(NewDocumentView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		dialog = new JFileChooser();
		dialog.setDialogTitle(SAVE_BUTTON_DIALOG_TITLE);
		if (dialog.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			saveFile(dialog.getSelectedFile().getAbsolutePath());
		}

	}

	private void saveFile(String filepath) {
		try {
			if (!StringUtils.endsWithIgnoreCase(filepath, ".txt")) {
				filepath = filepath.concat(".txt");
			}

			File myObj = new File(filepath);
			System.out.println("path"+filepath);
			if (myObj.createNewFile()) {
				FileUtils.setFileMetadata(filepath, AUTHOR_METADATA_NAME, view.getAuthorTextField());
				FileUtils.setFileMetadata(filepath, TITLE_METADATA_NAME, view.getDocumentTitleTextField());
				System.out.println("File created: " + myObj.getName());
				view.showMessageDialog("File successfully created.");
				// todo this is a bad coupling example. the new Document view shouldn't be so coupled with main view
				view.goToMainView();
			} else {
				view.showMessageDialog("File already exists. Try saving the file with another name");
				actionPerformed(null);
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public JFileChooser getDialog() {
		return dialog;
	}
}
