package com.t2s.staying.home.T2S.StayingHome.command;

import com.t2s.staying.home.T2S.StayingHome.t2sClasses.FreeTTSAdapter;
import com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DocumentToSpeech implements ActionListener {

	private DocumentEditorView documentToSpeechView;
	public DocumentToSpeech(DocumentEditorView documentToSpeechView) {
		this.documentToSpeechView = documentToSpeechView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// todo
		FreeTTSAdapter freeTTS = new FreeTTSAdapter();

		try {
			//freeTTS.play(documentToSpeechView.textArea.getText());

		}catch(Exception e1) {}
	}
}
