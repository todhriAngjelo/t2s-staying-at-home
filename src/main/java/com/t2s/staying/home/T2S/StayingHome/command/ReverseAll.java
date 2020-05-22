package com.t2s.staying.home.T2S.StayingHome.command;

import com.t2s.staying.home.T2S.StayingHome.factory.TextToSpeechAPIFactory;
import com.t2s.staying.home.T2S.StayingHome.manager.DocumentManager;
import com.t2s.staying.home.T2S.StayingHome.model.Line;
import com.t2s.staying.home.T2S.StayingHome.tts.TextToSpeechAPI;
import com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.FREE_TTS;

public class ReverseAll implements ActionListener {

	private TextToSpeechAPIFactory textToSpeech = new TextToSpeechAPIFactory();
	TextToSpeechAPI t2s =  textToSpeech.getTTSApi(FREE_TTS);
	DocumentEditorView view;
	private DocumentManager documentManager = new DocumentManager();
	private List<Line> currentLines;
	public ReverseAll(DocumentEditorView reverseAllView) {
		this.view = reverseAllView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		currentLines = documentManager.getCurrentDocument().getLines();
		Collections.reverse(currentLines);

		try {
			for (Line currentLine : currentLines) {
				Collections.reverse(currentLine.getWords());
				for (String word : currentLine.getWords()) {
					t2s.play(word);
				}
				Collections.reverse(currentLine.getWords());
			}
			Collections.reverse(currentLines);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		view.getReplayManager().add(this);

	}
}
