package com.t2s.staying.home.T2S.StayingHome.command;

import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.DEFAULT_SAVE_FILE_LOCATION;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.UserDefinedFileAttributeView;

import com.t2s.staying.home.T2S.StayingHome.model.Document;

public class NewDocument implements ActionListener {

	private Document document;

	@Override
	public void actionPerformed(ActionEvent event) {
		try {
			if (document.getTitle() == null) {
				System.out.println("Can not create a document with an empty title.");
			}
			File myObj = new File(String.format(DEFAULT_SAVE_FILE_LOCATION + "%s.txt", document.getTitle()));

			String path = DEFAULT_SAVE_FILE_LOCATION + document.getTitle() + ".txt";
			Path file = Paths.get(path);

			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName()); // todo implement ui success message

				// write metadata
				UserDefinedFileAttributeView view =
						Files.getFileAttributeView(Paths.get(path), UserDefinedFileAttributeView.class);
				view.write("user.author",
						Charset.defaultCharset().encode(document.getAuthorsName()));

			} else {
				System.out.println("File already exists."); // todo implement ui . already exists file

				// read metadata
				UserDefinedFileAttributeView view =
						Files.getFileAttributeView(Paths.get(path), UserDefinedFileAttributeView.class);
				ByteBuffer buf = ByteBuffer.allocate(view.size("user.author"));
				view.read("user.author", buf);
				buf.flip();
				String value = Charset.defaultCharset().decode(buf).toString();
				System.out.println("author is:" + value);

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
