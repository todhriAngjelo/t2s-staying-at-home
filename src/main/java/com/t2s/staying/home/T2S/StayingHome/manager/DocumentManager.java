package com.t2s.staying.home.T2S.StayingHome.manager;

import com.t2s.staying.home.T2S.StayingHome.model.Document;
import com.t2s.staying.home.T2S.StayingHome.model.Line;
import com.t2s.staying.home.T2S.StayingHome.tts.TextToSpeechAPI;
import org.apache.logging.log4j.util.Strings;

import java.util.Collections;
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

	// this method is being used when we wanna play the contents of a whole document.
	// Take as a TextToSpeechApi and it calls the play method
	public static void playContents(TextToSpeechAPI t2s){
		List<Line> currentLines = getCurrentDocument().getLines();

		for (Line currentLine : currentLines) {
			for (String word : currentLine.getWords()) {
				t2s.play(word);
			}
		}
	}

	// this method is being used when we wanna play the contents of a line
	// Take as a TextToSpeechApi and it calls the play method
	public static void playLine(int lineNum,TextToSpeechAPI t2s ){
		List<Line> currentLines = getCurrentDocument().getLines();
		for (int n = 0; n < currentLines.size(); n += 1){
			for (String word : currentLines.get(n).getWords()) {
				if (lineNum == n){t2s.play(word);}
			}
		}
	}

	// this method is being used when we wanna play the contents of a document in reverse
	// Take as a TextToSpeechApi and it calls the play method
	public static void reverseAll(TextToSpeechAPI t2s){
		List<Line> currentLines = getCurrentDocument().getLines();
		Collections.reverse(currentLines);
		for (Line currentLine : currentLines) {
			Collections.reverse(currentLine.getWords());
			for (String word : currentLine.getWords()) {
				t2s.play(word);
			}
			Collections.reverse(currentLine.getWords());
		}
		Collections.reverse(currentLines);
	}

	// this method is being used when we wanna play the contents of a line in reverse
	// Take as a TextToSpeechApi and it calls the play method
	public static void reverseLine(int lineNum,TextToSpeechAPI t2s ){
		List<Line> currentLines = getCurrentDocument().getLines();
		for (int n = 0; n < currentLines.size(); n += 1) {
			if (lineNum == n) {
				Collections.reverse(currentLines.get(n).getWords());
				for (String word : currentLines.get(n).getWords()) {
					t2s.play(word);
				}
				Collections.reverse(currentLines.get(n).getWords());
			}
		}
	}
}
