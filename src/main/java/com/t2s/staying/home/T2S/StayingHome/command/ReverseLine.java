package com.t2s.staying.home.T2S.StayingHome.command;

import static com.t2s.staying.home.T2S.StayingHome.manager.DocumentManager.getCurrentDocument;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.t2s.staying.home.T2S.StayingHome.factory.TextToSpeechAPIFactory;
import com.t2s.staying.home.T2S.StayingHome.manager.DocumentManager;
import com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView;

public class ReverseLine implements ActionListener {

    TextToSpeechAPIFactory textToSpeechAPI = new TextToSpeechAPIFactory();
    DocumentEditorView view;

    public ReverseLine(DocumentEditorView view) { this.view = view;}

    @Override
    public void actionPerformed(ActionEvent e) {
        getCurrentDocument().getLines();
//        DocumentManager.get
//        DocumentUtils.findLineFromCaretPosition(view.getLineNumber(), getCurrentDocument()).getWords());
//
//        Collections.reverse(words);
//
//        textToSpeechAPI.getTTSApi().play(getListWordsInAString(words));
    }
}
