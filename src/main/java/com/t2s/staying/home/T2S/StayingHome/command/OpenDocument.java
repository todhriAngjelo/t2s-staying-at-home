package com.t2s.staying.home.T2S.StayingHome.command;

import static com.t2s.staying.home.T2S.utils.DocumentUtils.getCurrentDocument;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

import javax.swing.*;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.t2s.staying.home.T2S.StayingHome.ApplicationErrors;
import com.t2s.staying.home.T2S.StayingHome.model.Document;
import com.t2s.staying.home.T2S.StayingHome.model.Line;
import com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView;
import com.t2s.staying.home.T2S.utils.DocumentUtils;
import com.t2s.staying.home.T2S.utils.FileUtils;

public class OpenDocument implements ActionListener {

	private static DocumentEditorView view;
	private final Logger log = LoggerFactory.getLogger(OpenDocument.class);

	public OpenDocument(DocumentEditorView view) {
		this.view = view;
	}

	@Override
	//change
	public void actionPerformed(java.awt.event.ActionEvent e) {
		JFileChooser dialog = new JFileChooser();
		if (dialog.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

			log.info("Selected file at location: " + dialog.getSelectedFile().getAbsolutePath());
			BufferedReader bufferedReader = FileUtils.getFileBufferReader(dialog.getSelectedFile().getAbsolutePath());

			// populating Document instance with text document lines
			List<Line> lines = new ArrayList<>();

			if (bufferedReader != null) {
				bufferedReader.lines().forEach(bufLine -> {
					Line line = new Line();
					line.setWords(Arrays.asList(bufLine.split("\\\\s+")));
					lines.add(line);
				});
				getCurrentDocument().setLines(lines);
				FileUtils.closeBufferedReader(bufferedReader);
			} else {
				view.showErrorDialog(ApplicationErrors.LOAD_FILE_ERROR);
			}

			// populating Document instance with author and title text file metadata
			String title = FileUtils.getFileMetadata(dialog.getSelectedFile().getAbsolutePath(), "title");
			String author = FileUtils.getFileMetadata(dialog.getSelectedFile().getAbsolutePath(), "author");

			if (title != null && author != null) {
				getCurrentDocument().setTitle(title);
				getCurrentDocument().setAuthorsName(author);
			} else {
				view.showErrorDialog(ApplicationErrors.EMPTY_TITLE_AUTHOR_ERROR);
			}

			getCurrentDocument().setLastModifiedTime(FileUtils.getFileLastModifiedTime(dialog.getSelectedFile().getAbsolutePath()));
			getCurrentDocument().setCreationTime(FileUtils.getFileCreationTime(dialog.getSelectedFile().getAbsolutePath()));
			if (getCurrentDocument().getCreationTime() == null || getCurrentDocument().getLastModifiedTime() == null) {
				view.showErrorDialog(ApplicationErrors.EMPTY_FILE_TIMESTAMPS_ERROR);
			}

			updateView(getCurrentDocument());
		}
	}

	private void updateView(Document document) {
		view.updateView(
				document.getTitle(),
				document.getAuthorsName(),
				getTimezoneStringDate(document.getCreationTime()),
				getTimezoneStringDate(document.getLastModifiedTime()),
				DocumentUtils.getTextFromDocument(document));
	}

	private String getTimezoneStringDate(Long dateMillis) {
		DateTime dt = new DateTime(dateMillis);
		dt.toDateTime(DateTimeZone.forTimeZone(TimeZone.getTimeZone(ZoneId.systemDefault())));
		return dt.toString("MM/dd/yyyy HH:mm:ss");
	}
}