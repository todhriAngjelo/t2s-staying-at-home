package com.t2s.staying.home.T2S.StayingHome.command;

import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.DEFAULT_SAVE_FILE_LOCATION;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import com.t2s.staying.home.T2S.StayingHome.model.Document;
import com.t2s.staying.home.T2S.StayingHome.view.NewDocumentView;
import com.t2s.staying.home.T2S.utils.FileUtils;

public class NewDocument implements ActionListener {

	private NewDocumentView newDocumentView;
	private Document document = new Document();

	public NewDocument(NewDocumentView newDocumentView) {
		this.newDocumentView = newDocumentView;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		try {
			if (getDocumentTitle() == null) {
				System.out.println("Can not create a document with an empty title.");
			}
			File myObj = new File(String.format(DEFAULT_SAVE_FILE_LOCATION + "%s.txt", getDocumentTitle()));

			String path = DEFAULT_SAVE_FILE_LOCATION + getDocumentTitle() + ".txt";

			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName()); // todo implement ui success message
				FileUtils.setFileMetadata(path, "author", getDocumentAuthor());
				FileUtils.setFileMetadata(path, "cTime", String.valueOf(System.currentTimeMillis()));
			} else {
				System.out.println("File already exists."); // todo implement ui . already exists file
				FileUtils.getFileMetadata(path, "author");
				FileUtils.getFileMetadata(path, "cTime");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	private String getDocumentTitle() {
		if
		document.setTitle(newDocumentView.getDocumentTitle());

		return ;
	}

	private String getDocumentAuthor() {
		return newDocumentView.getDocumentAuthor();
	}
}
