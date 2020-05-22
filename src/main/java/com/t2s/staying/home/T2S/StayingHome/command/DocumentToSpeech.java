package com.t2s.staying.home.T2S.StayingHome.command;

import com.t2s.staying.home.T2S.StayingHome.factory.TextToSpeechAPIFactory;
import com.t2s.staying.home.T2S.StayingHome.manager.DocumentManager;
import com.t2s.staying.home.T2S.StayingHome.model.Line;
import com.t2s.staying.home.T2S.StayingHome.tts.TextToSpeechAPI;
import com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.FREE_TTS;

public class DocumentToSpeech implements ActionListener {

	private DocumentEditorView documentToSpeechView;
	private DocumentManager documentManager = new DocumentManager();

	public DocumentToSpeech(DocumentEditorView documentToSpeechView) {
		this.documentToSpeechView = documentToSpeechView;
	}

	private TextToSpeechAPIFactory textToSpeech = new TextToSpeechAPIFactory();
	TextToSpeechAPI t2s =  textToSpeech.getTTSApi(FREE_TTS);
	@Override
	public void actionPerformed(ActionEvent e) {

		List<Line> currentLines = documentManager.getCurrentDocument().getLines();

		try {
			for (Line currentLine : currentLines) {
				for (String word : currentLine.getWords()) {
					t2s.play(word);
				}
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		documentToSpeechView.getReplayManager().add(this);

	}
}

