package com.t2s.staying.home.T2S.StayingHome.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import com.t2s.staying.home.T2S.StayingHome.model.Document;

public class NewDocument implements ActionListener {

	private Document document;

	@Override
	public void actionPerformed(ActionEvent event) {
		try {
			File myObj = new File(String.format("%s.txt", document.getTitle() )); // todo handle document null
			// todo save this in default location defined in app constants
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName()); // todo implement ui success message
			} else {
				System.out.println("File already exists."); // todo implement ui . already exists file
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

	public void setDocument(Document document) {
		this.document = document;
	}
}
