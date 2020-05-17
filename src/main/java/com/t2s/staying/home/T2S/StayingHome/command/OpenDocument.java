package com.t2s.staying.home.T2S.StayingHome.command;

import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.AUTHOR_METADATA_NAME;
import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.TITLE_METADATA_NAME;
import static com.t2s.staying.home.T2S.StayingHome.manager.DocumentManager.getCurrentDocument;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.t2s.staying.home.T2S.StayingHome.ApplicationErrors;
import com.t2s.staying.home.T2S.StayingHome.manager.DocumentManager;
import com.t2s.staying.home.T2S.StayingHome.model.Document;
import com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView;
import com.t2s.staying.home.T2S.utils.DateUtils;
import com.t2s.staying.home.T2S.utils.FileUtils;

public class OpenDocument implements ActionListener {

	private static final String OPEN_DIALOG_TITLE = "Select file to open:";

	private final Logger log = LoggerFactory.getLogger(OpenDocument.class);

	private static DocumentEditorView view;

	public OpenDocument(DocumentEditorView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(java.awt.event.ActionEvent e) {
		JFileChooser dialog = new JFileChooser();
		dialog.setDialogTitle(OPEN_DIALOG_TITLE);

		if (dialog.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			BufferedReader bufferedReader = FileUtils.getFileBufferReader(dialog.getSelectedFile().getAbsolutePath());

			List<String> lines = new ArrayList<>();
			if (bufferedReader != null) {
				bufferedReader.lines().forEach(line -> lines.add(line));
				FileUtils.closeBufferedReader(bufferedReader);
			} else {
				view.showErrorDialog(ApplicationErrors.LOAD_FILE_ERROR);
			}

			String title = FileUtils.getFileMetadata(dialog.getSelectedFile().getAbsolutePath(), AUTHOR_METADATA_NAME);
			String author = FileUtils.getFileMetadata(dialog.getSelectedFile().getAbsolutePath(), TITLE_METADATA_NAME);
			Long lModifiedTime = FileUtils.getFileLastModifiedTime(dialog.getSelectedFile().getAbsolutePath());
			Long creationTime = FileUtils.getFileCreationTime(dialog.getSelectedFile().getAbsolutePath());

			if (Strings.isBlank(title) || Strings.isBlank(author)) {
				view.showErrorDialog(ApplicationErrors.EMPTY_TITLE_AUTHOR_ERROR);
				view.goToMainView();
			}

			if (creationTime == null || lModifiedTime == null) {
				view.showErrorDialog(ApplicationErrors.EMPTY_FILE_TIMESTAMPS_ERROR);
				view.goToMainView();
			}

			DocumentManager.updateStaticCurrentDocument(title, author, lines, creationTime, lModifiedTime);
			updateView(getCurrentDocument());
		}
	}

	private void updateView(Document document) {
		view.updateView(
				document.getTitle(),
				document.getAuthorsName(),
				DateUtils.getTimezoneStringDate(document.getCreationTime(), null),
				DateUtils.getTimezoneStringDate(document.getLastModifiedTime(), null),
				DocumentManager.getTextFromDocument(document));
	}
}