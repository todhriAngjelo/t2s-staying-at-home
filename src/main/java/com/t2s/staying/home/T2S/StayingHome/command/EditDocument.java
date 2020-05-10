package com.t2s.staying.home.T2S.StayingHome.command;

import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.DEFAULT_SAVE_FILE_LOCATION;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.UserDefinedFileAttributeView;

import com.t2s.staying.home.T2S.StayingHome.model.Document;

public class EditDocument implements ActionListener {

	Document document;

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (document.getTitle() == null) {
				System.out.println("An error occurred. Can not edit a document with an empty title");
			}
			File myObj = new File(String.format(DEFAULT_SAVE_FILE_LOCATION + "%s.txt", document.getTitle()));
			myObj.getAbsoluteFile();
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName()); // todo implement ui success message

			} else {
				System.out.println("File already exists."); // todo implement ui . already exists file

			}
		} catch (IOException error) {
			System.out.println("An error occurred.");
			error.printStackTrace();
		}
	}

	public void setDocument(Document document) {
		this.document = document;
	}
}
