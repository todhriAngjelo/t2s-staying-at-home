package com.t2s.staying.home.T2S.StayingHome.command;

import com.t2s.staying.home.T2S.StayingHome.model.Document;
import com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DocumentToSpeech implements ActionListener {

	private DocumentEditorView documentToSpeechView;
	private Document document = new Document();

	public DocumentToSpeech(DocumentEditorView documentToSpeechView) {
		this.documentToSpeechView = documentToSpeechView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		if(documentToSpeechView.getTextArea() != null) { //fixme
		try {
//				document.playContents(documentToSpeechView.getTextArea());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}

