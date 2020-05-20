package com.t2s.staying.home.T2S.StayingHome.manager;

import com.t2s.staying.home.T2S.StayingHome.model.Document;
import com.t2s.staying.home.T2S.StayingHome.model.Line;
import org.apache.logging.log4j.util.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DocumentManager {

	private static final Document document = new Document();

	private static final Line line = new Line();

	public static Document getCurrentDocument() {
		return document;
	}

	public static Line getCurrentLines(){
		return line;
	}
	public static Document createDocument(String title, String author, List<Line> lines, Long creationTime, Long lastModifiedTime) {
		Document document = new Document();

		document.setLastModifiedTime(lastModifiedTime);
		document.setCreationTime(creationTime);
		document.setTitle(title);
		document.setAuthorsName(author);
		document.setLines(lines);
		return document;
	}

	public static void updateStaticCurrentDocument(String title, String author, List<Line> lines, Long creationTime, Long lastModifiedTime) {
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

	public static void splitToWords(List<String> currentlines){
		List<List<String>> allTheLines = new ArrayList<>();

		for (String currentline : currentlines) {

			List<String> words = Arrays.asList(currentline.split("\\s+"));

			allTheLines.add(words);

			//line.setWords(allTheLines);

		}

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
