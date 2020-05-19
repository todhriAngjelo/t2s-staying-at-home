package com.t2s.staying.home.T2S.StayingHome.command;

import com.t2s.staying.home.T2S.StayingHome.factory.TextToSpeechAPIFactory;
import com.t2s.staying.home.T2S.StayingHome.manager.DocumentManager;
import com.t2s.staying.home.T2S.StayingHome.tts.TextToSpeechAPI;
import com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.FREE_TTS;

public class ReverseAll implements ActionListener {

	private TextToSpeechAPIFactory textToSpeech = new TextToSpeechAPIFactory();
	TextToSpeechAPI t2s =  textToSpeech.getTTSApi(FREE_TTS);
	DocumentEditorView view;
	private DocumentManager documentManager = new DocumentManager();

	public ReverseAll(DocumentEditorView reverseAllView) {
		this.view = reverseAllView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		List<String> currentLines = documentManager.getCurrentDocument().getLines();
		Collections.reverse(currentLines);

		try {

			for (String currentLine : currentLines) {

				List<String> words = Arrays.asList(currentLine.split(" "));
				Collections.reverse(words);
				for (String word : words) {
					t2s.play(word);
				}

			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}
}
