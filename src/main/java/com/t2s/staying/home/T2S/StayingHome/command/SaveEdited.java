package com.t2s.staying.home.T2S.StayingHome.command;

import com.t2s.staying.home.T2S.StayingHome.ApplicationErrors;
import com.t2s.staying.home.T2S.StayingHome.manager.DocumentManager;
import com.t2s.staying.home.T2S.StayingHome.model.Document;
import com.t2s.staying.home.T2S.StayingHome.model.Line;
import com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView;
import com.t2s.staying.home.T2S.utils.DateUtils;
import com.t2s.staying.home.T2S.utils.FileUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.AUTHOR_METADATA_NAME;
import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.TITLE_METADATA_NAME;


public class SaveEdited implements ActionListener {
    public static final String SAVE_BUTTON_DIALOG = "Specify the file to save:";
    private DocumentEditorView view;

    public SaveEdited(DocumentEditorView view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            saveToFile();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    /* todo save only in the current file... Now we can save wherever(WRONG) */
    protected void saveToFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle(SAVE_BUTTON_DIALOG);
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            if (file == null) {
                return;
            }
            if (!file.getName().toLowerCase().endsWith(".txt")) {
                file = new File(file.getParentFile(), file.getName() + ".txt");
            }
            try {
                view.getTextArea().write(new OutputStreamWriter(new FileOutputStream(file),
                        "utf-8"));
                FileUtils.setFileMetadata(file.getAbsolutePath(), AUTHOR_METADATA_NAME, view.getAuthorTextField());
                FileUtils.setFileMetadata(file.getAbsolutePath(), TITLE_METADATA_NAME, view.getDocumentTitleTextField());

                BufferedReader bufferedReader = FileUtils.getFileBufferReader(file.getAbsolutePath());
                List<String> lines = new ArrayList<>();
                if (bufferedReader != null) {
                    bufferedReader.lines().forEach(line -> lines.add(line));
                    FileUtils.closeBufferedReader(bufferedReader);
                } else {
                    view.showMessageDialog(ApplicationErrors.LOAD_FILE_ERROR);
                }
                List<String> words;
                List<Line> currentLines = new ArrayList<>();
                for (String line : lines) {

                    Line currentLine = new Line();
                    words = Arrays.asList(line.split("\\s+"));

                    currentLine.setWords(words);
                    currentLines.add(currentLine);
                }

                FileUtils.setFileMetadata(file.getAbsolutePath(), AUTHOR_METADATA_NAME, view.getAuthorTextField());
                FileUtils.setFileMetadata(file.getAbsolutePath(), TITLE_METADATA_NAME, view.getDocumentTitleTextField());

                DocumentManager.updateStaticCurrentDocument(
                        view.getDocumentTitleTextField(),
                        view.getAuthorTextField(),
                        currentLines,
                        null,
                        FileUtils.getFileLastModifiedTime(file.getAbsolutePath()));
                updateView(DocumentManager.getCurrentDocument());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        view.getReplayManager().add(this);
    }

    private void updateView(Document document) {
        view.updateView(
                document.getTitle(),
                document.getAuthorsName(),
                DateUtils.getTimezoneStringDate(document.getCreationTime(), null),
                DateUtils.getTimezoneStringDate(document.getLastModifiedTime(), null),
                document.getLines());
    }
}
