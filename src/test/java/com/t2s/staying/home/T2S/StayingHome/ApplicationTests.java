package com.t2s.staying.home.T2S.StayingHome;

import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.ATBASH;
import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.ROT13;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import com.t2s.staying.home.T2S.StayingHome.command.NewDocument;
import com.t2s.staying.home.T2S.StayingHome.command.SaveEdited;
import com.t2s.staying.home.T2S.StayingHome.encoding.EncodingStrategy;
import com.t2s.staying.home.T2S.StayingHome.factory.StrategiesFactory;
import com.t2s.staying.home.T2S.StayingHome.manager.DocumentManager;
import com.t2s.staying.home.T2S.StayingHome.manager.ReplayManager;
import com.t2s.staying.home.T2S.StayingHome.model.Document;
import com.t2s.staying.home.T2S.StayingHome.model.Line;
import com.t2s.staying.home.T2S.StayingHome.tts.FakeTextToSpeechAPI;
import com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView;
import com.t2s.staying.home.T2S.StayingHome.view.NewDocumentView;
import com.t2s.staying.home.T2S.utils.FileUtils;

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
		// SaveDocument command has been run in previous test so there is no need to perform a save document again.
		// once save document has been executed before file has been edited and we just have to go and perform a line words counts
		// between currentDocument and the file ( from the buffered reader ) words count
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
		// open document has been executed in previous test so there is no need to re-open it. Once
		// openDocument command was executed getCurrentDocumetn from Documetn Manager has been populated
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

	// Test all the contents of a document To Speech
	@Test
	void us5Test() {
//		List<String> words1 = new ArrayList<String>(){{
//			add("I ");
//			add("am ");
//			add("Niko ");
//			add("Spyropoulo ");
//		}};
//		Line line1 = new Line();
//		line1.setWords(words1);
//		List<String> words2 = new ArrayList<String>(){{
//			add("You ");
//			add("are ");
//			add("Aggelo ");
//			add("Todri ");
//		}};
//		Line line2 = new Line();
//		line2.setWords(words2);
//
//		List<Line> lines = new ArrayList<Line>(){{
//			add(line1);
//			add(line2);
//		}};

		FakeTextToSpeechAPI fakeT2S = new FakeTextToSpeechAPI();
		Document document = DocumentManager.getCurrentDocument();
//		document.setLines(lines);

		//Here we creating a List<string> and we add as items all the words of the
		//current Document. We are doing this because we wanna compare the currentDocument
		//with the fakeT2S.getLastText() that is a List<string> too.
		List<String> text = new ArrayList<>();
		for (Line line : document.getLines()) {
			for (String word : line.getWords()) {
				text.add(word);
			}
		}

		DocumentManager.playContents(fakeT2S);

		assertEquals(text, fakeT2S.getLastText());
	}

	// Test all the contents of a Line To Speech
	// we test always the first Line
	@Test
	void us6Test(){
		FakeTextToSpeechAPI fakeT2S = new FakeTextToSpeechAPI();
		Document document = DocumentManager.getCurrentDocument();

		DocumentManager.playLine(0, fakeT2S);

		assertEquals(document.getLines().get(0).getWords(), fakeT2S.getLastText());

	}

	// Test all the contents of a document To Speech in reverse
	@Test
	void us7Test(){
		FakeTextToSpeechAPI fakeT2S = new FakeTextToSpeechAPI();
		Document document = DocumentManager.getCurrentDocument();

		//Here we creating a List<string> and we add as items all the words of the
		//current Document(in reverse). We are doing this because we wanna compare the currentDocument
		//with the fakeT2S.getLastText() that is a List<string> too.
		List<String> text = new ArrayList<>();
		Collections.reverse(document.getLines());
		for (Line line : document.getLines()) {
			Collections.reverse(line.getWords());
			for (String word : line.getWords()) {
				text.add(word);
			}
			Collections.reverse(line.getWords());
		}
		Collections.reverse(document.getLines());

		DocumentManager.reverseAll(fakeT2S);

		assertEquals(text, fakeT2S.getLastText());
	}

	// Test all the contents of a Line To Speech in reverse
	// we test always the first Line
	@Test
	void us8Test(){
		FakeTextToSpeechAPI fakeT2S = new FakeTextToSpeechAPI();
		Document document = DocumentManager.getCurrentDocument();

		DocumentManager.reverseLine(0, fakeT2S);
		Collections.reverse(document.getLines().get(0).getWords());
		assertEquals(document.getLines().get(0).getWords(), fakeT2S.getLastText());
		Collections.reverse(document.getLines().get(0).getWords());

	}


	// test if the contents that the faketts reads are the same with the
	// encoded(by rot13) content of the document
	@Test
	void us9RotTest(){
		StrategiesFactory strategy = new StrategiesFactory();
		EncodingStrategy algorithm = strategy.createStrategy(ROT13);
		FakeTextToSpeechAPI fakeT2S = new FakeTextToSpeechAPI();

		List<String> text = DocumentManager.encodingAllAndSpeech(fakeT2S, algorithm);

		assertEquals(text, fakeT2S.getLastText());

	}

	// test if the contents that the faketts reads are the same with the
	// encoded(by atbash) content of the document
	@Test
	void us9AtbashTest(){
		StrategiesFactory strategy = new StrategiesFactory();
		EncodingStrategy algorithm = strategy.createStrategy(ATBASH);
		FakeTextToSpeechAPI fakeT2S = new FakeTextToSpeechAPI();

		List<String> text = DocumentManager.encodingAllAndSpeech(fakeT2S, algorithm);

		assertEquals(text, fakeT2S.getLastText());
	}
	@Test
	void us10RotTest(){
		StrategiesFactory strategy = new StrategiesFactory();
		EncodingStrategy algorithm = strategy.createStrategy(ROT13);
		FakeTextToSpeechAPI fakeT2S = new FakeTextToSpeechAPI();

		List<String> text = DocumentManager.encodingLineAndSpeech(fakeT2S, algorithm, 0);
		assertEquals(text, fakeT2S.getLastText());
	}

	// test if the contents that the faketts reads are the same with the
	// encoded(by atbash) content of the SELECTED line
	// here we choose always line 0
	@Test
	void us10AbashTest(){
		StrategiesFactory strategy = new StrategiesFactory();
		EncodingStrategy algorithm = strategy.createStrategy(ATBASH);
		FakeTextToSpeechAPI fakeT2S = new FakeTextToSpeechAPI();

		List<String> text = DocumentManager.encodingLineAndSpeech(fakeT2S, algorithm, 0);
		assertEquals(text, fakeT2S.getLastText());
	}

	// test the audios volume, pitch, rate
	@Test
	void us12(){
		FakeTextToSpeechAPI fakeT2S = new FakeTextToSpeechAPI();

		fakeT2S.setVolume(0.4f);
		fakeT2S.setPitch(60);
		fakeT2S.setRate(60);

		assertEquals(0.4f, fakeT2S.getLastVolume());
		assertEquals(60, fakeT2S.getLastPitch());
		assertEquals(60, fakeT2S.getLastRate());

	}

	@Test
	void us12ReplayCommandTest() {
		DocumentEditorView view = initializeDocumentEditorView();
		Long lModificationTime = DocumentManager.getCurrentDocument().getLastModifiedTime();
		SaveEdited saveEdited = new SaveEdited(view);
		ReplayManager replayManager = new ReplayManager();
		replayManager.add(saveEdited);
		replayManager.replay();

		assert (!lModificationTime.equals(DocumentManager.getCurrentDocument().getLastModifiedTime()));
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
