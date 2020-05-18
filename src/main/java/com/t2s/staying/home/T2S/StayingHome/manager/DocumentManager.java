package com.t2s.staying.home.T2S.StayingHome.manager;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.apache.logging.log4j.util.Strings;

import com.t2s.staying.home.T2S.StayingHome.model.Document;

public class DocumentManager {

	private static final Document document = new Document();

	public static Document getCurrentDocument() {
		return document;
	}

	public static Document createDocument(String title, String author, List<String> lines, Long creationTime, Long lastModifiedTime) {
		Document document = new Document();

		document.setLastModifiedTime(lastModifiedTime);
		document.setCreationTime(creationTime);
		document.setTitle(title);
		document.setAuthorsName(author);
		document.setLines(lines);
		return document;
	}

	public static void updateStaticCurrentDocument(String title, String author, List<String> lines, Long creationTime, Long lastModifiedTime) {
		if (Strings.isNotBlank(title))
			document.setTitle(title);

		if (Strings.isNotBlank(author))
			document.setAuthorsName(author);

		if (creationTime != null)
			document.setCreationTime(creationTime);

		if (lastModifiedTime != null)
			document.setLastModifiedTime(lastModifiedTime);

		if (lines != null)
			document.setLines(lines);
	}

//	public static List<String> getTextFromDocument(Document document) {
//		String textFromLines = "";
//
//		for (String line : document.getLines()) {
//			textFromLines = textFromLines.concat(line).concat("<br>");
//		}
//		return textFromLines;
//	}
}
