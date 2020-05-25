package com.t2s.staying.home.T2S.StayingHome.command;

import com.t2s.staying.home.T2S.StayingHome.factory.TextToSpeechAPIFactory;
import com.t2s.staying.home.T2S.StayingHome.manager.DocumentManager;
import com.t2s.staying.home.T2S.StayingHome.tts.TextToSpeechAPI;
import com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.FREE_TTS;

public class DocumentToSpeech implements ActionListener {

	private DocumentEditorView view;

	public DocumentToSpeech(DocumentEditorView view) {
		this.view = view;
	}

	private TextToSpeechAPIFactory textToSpeech = new TextToSpeechAPIFactory();
	TextToSpeechAPI t2s =  textToSpeech.getTTSApi(FREE_TTS);
	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			DocumentManager.playContents(t2s);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		view.getReplayManager().add(this);
	}
}

