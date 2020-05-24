package com.t2s.staying.home.T2S.StayingHome;

import com.t2s.staying.home.T2S.StayingHome.command.NewDocument;
import com.t2s.staying.home.T2S.StayingHome.command.SaveEdited;
import com.t2s.staying.home.T2S.StayingHome.manager.DocumentManager;
import com.t2s.staying.home.T2S.StayingHome.model.Line;
import com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView;
import com.t2s.staying.home.T2S.StayingHome.view.NewDocumentView;
import com.t2s.staying.home.T2S.utils.FileUtils;

import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class ApplicationTests {

	private static DocumentEditorView documentEditorView;
	private static NewDocumentView newDocumentView;
	private static String filepath;
	private static BufferedReader bufferedReader;

	// To test the creation of a new document we can implement an
	// acceptance test that creates a NewDocument command executes it and
	// then checks whether the contents of the current document object that
	// is held by the Text2SpeechEditorView class is empty.
	@Test
	void us1Test() {
		newDocumentView = initializeNewDocumentView();
		NewDocument newDocument = new NewDocument(newDocumentView);
		newDocument.actionPerformed(null);
		filepath = newDocument.getDialog().getSelectedFile().getAbsolutePath();
		if (!StringUtils.endsWithIgnoreCase(filepath, ".txt")) {
			filepath = filepath.concat(".txt");
		}

		bufferedReader = FileUtils.getFileBufferReader(filepath);
		assert Objects.requireNonNull(bufferedReader).lines().count() == 0;
	}

	// To test this story we can create an EditDocument command that
	// changes the contents of a document, execute it and subsequently get
	// the new contents of the document (getContents()) and compare them
	// against the contents that have been set.
	@Test
	void us2Test() {
		documentEditorView = initializeDocumentEditorView();
		documentEditorView.setDocumentTitleTextField(newDocumentView.getDocumentTitleJTextField());
		documentEditorView.setAuthorTextField(newDocumentView.getAuthorJTextField());
		SaveEdited saveEdited = new SaveEdited(documentEditorView);
		saveEdited.actionPerformed(null);

		assert Objects.requireNonNull(bufferedReader).lines().count() != 0;
	}

	// An idea for this test is to create SaveDocument command, execute it,
	// and check whether the contents of the current document match with
	// the contents of the file that has been saved to disk.
	@Test
	void us3Test() {
		List<String> currentDocumentLines = DocumentManager.getCurrentDocument().getLines().get(0).getWords();
		List<String> fileLines = Arrays.asList(Objects.requireNonNull(FileUtils.getFileBufferReader(filepath))
				.lines()
				.collect(Collectors.toList()).get(0).split(" "));

		assert fileLines.size() == currentDocumentLines.size();
	}

	// An idea for this test is to create OpenCommand, execute it, and check
	// whether the contents of the current document match with the
	// contents of the file that has been read from the disk.
	@Test
	void us4Test() {
		List<String> currentDocumentLines = DocumentManager.getCurrentDocument().getLines().get(0).getWords();
		List<String> fileLines = Arrays.asList(Objects.requireNonNull(FileUtils.getFileBufferReader(filepath))
				.lines()
				.collect(Collectors.toList()).get(0).split(" "));

		boolean wordsMatch = true;
		int counter = 0;
		for (String word : currentDocumentLines) {
			if (!fileLines.get(counter).equals(word))
				wordsMatch = false;
			counter ++;
		}
		assert wordsMatch;
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
}
