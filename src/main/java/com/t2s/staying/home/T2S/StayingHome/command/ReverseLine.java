package com.t2s.staying.home.T2S.StayingHome.command;

import static com.t2s.staying.home.T2S.utils.DocumentUtils.getCurrentDocument;
import static com.t2s.staying.home.T2S.utils.DocumentUtils.getListWordsInAString;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.t2s.staying.home.T2S.StayingHome.factory.TextToSpeechAPIFactory;
import com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView;
import com.t2s.staying.home.T2S.utils.DocumentUtils;

public class ReverseLine implements ActionListener {

    TextToSpeechAPIFactory textToSpeechAPI = new TextToSpeechAPIFactory();
    DocumentEditorView view;

    public ReverseLine(DocumentEditorView view) { this.view = view;}

    @Override
    public void actionPerformed(ActionEvent e) {
        List<String> words = new ArrayList<>(
                DocumentUtils.findDocumentLineFromCaretPosition(view.getLineNumber(), getCurrentDocument()).getWords());

        Collections.reverse(words);

        textToSpeechAPI.getTTSApi().play(getListWordsInAString(words));
    }
}
