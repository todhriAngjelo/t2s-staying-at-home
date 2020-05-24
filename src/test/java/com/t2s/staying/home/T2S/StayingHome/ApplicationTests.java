package com.t2s.staying.home.T2S.StayingHome;

import com.t2s.staying.home.T2S.StayingHome.command.NewDocument;
import com.t2s.staying.home.T2S.StayingHome.manager.DocumentManager;
import com.t2s.staying.home.T2S.StayingHome.model.Document;
import com.t2s.staying.home.T2S.StayingHome.model.Line;
import com.t2s.staying.home.T2S.StayingHome.tts.FakeTextToSpeechAPI;
import com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView;
import com.t2s.staying.home.T2S.StayingHome.view.NewDocumentView;
import com.t2s.staying.home.T2S.utils.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTests {
//
	DocumentEditorView documentEditorView;
	NewDocumentView newDocumentView;
	@Test
	// To test the creation of a new document we can implement an
	// acceptance test that creates a NewDocument command executes it and
	// then checks whether the contents of the current document object that
	// is held by the Text2SpeechEditorView class is empty.
	void us1Test() {
		newDocumentView = initializeNewDocumentView();
		NewDocument newDocument = new NewDocument(newDocumentView);
		newDocument.actionPerformed(null);
		String filepath = newDocument.getDialog().getSelectedFile().getAbsolutePath();
		if (!StringUtils.endsWithIgnoreCase(filepath, ".txt")) {
			filepath = filepath.concat(".txt");
		}

		BufferedReader bufferedReader = FileUtils.getFileBufferReader(filepath);
		assert Objects.requireNonNull(bufferedReader).lines().count() == 0;
	}


	private DocumentEditorView initializeDocumentEditorView() {
		DocumentEditorView documentEditorView = new DocumentEditorView();
		documentEditorView.getTextArea().setText("test line 1/n test line 2");
		documentEditorView.getTitleJTextField().setText("test title");
		documentEditorView.getAuthorJTextField().setText("test author");
		return documentEditorView;
	}

	public NewDocumentView initializeNewDocumentView() {
		NewDocumentView newDocumentView = new NewDocumentView();
		newDocumentView.getAuthorJTextField().setText("test author");
		newDocumentView.getDocumentTitleJTextField().setText("test title");
		return newDocumentView;
	}

	@Test
	void us5Test() {

		List<String> words1 = new ArrayList<String>(){{
			add("I ");
			add("am ");
			add("Niko ");
			add("Spyropoulo ");
		}};
		Line line1 = new Line();
		line1.setWords(words1);
		List<String> words2 = new ArrayList<String>(){{
			add("You ");
			add("are ");
			add("Aggelo ");
			add("Todri ");
		}};
		Line line2 = new Line();
		line2.setWords(words2);

		List<Line> lines = new ArrayList<Line>(){{
			add(line2);
		}};


		FakeTextToSpeechAPI fakeT2S = new FakeTextToSpeechAPI();

		DocumentManager documentManager = new DocumentManager();

		Document document = documentManager.getCurrentDocument();

		document.setLines(lines);

		List<String> text = new ArrayList<>();

		for (Line line : document.getLines()) {
			for (String word : line.getWords()) {
				text.add(word);
			}
		}

		documentManager.playContents(fakeT2S);

		assertEquals(text, fakeT2S.getLastText());
	}
}
