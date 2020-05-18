package com.t2s.staying.home.T2S.StayingHome.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.t2s.staying.home.T2S.StayingHome.factory.TextToSpeechAPIFactory;
import com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView;

public class ReverseLine implements ActionListener {

    TextToSpeechAPIFactory textToSpeechAPI = new TextToSpeechAPIFactory();
    DocumentEditorView view;

    public ReverseLine(DocumentEditorView view) { this.view = view;}

    @Override
    public void actionPerformed(ActionEvent e) {
        textToSpeechAPI.getTTSApi().play("something happened here and now");
    }
}
