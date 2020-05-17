package com.t2s.staying.home.T2S.StayingHome.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.t2s.staying.home.T2S.StayingHome.factory.TextToSpeechAPIFactory;
import com.t2s.staying.home.T2S.StayingHome.tts.TextToSpeechAPI;
import com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView;

public class ReverseAll implements ActionListener {

	TextToSpeechAPIFactory textToSpeechAPIFactory = new TextToSpeechAPIFactory();

	DocumentEditorView view;

	public ReverseAll(DocumentEditorView reverseAllView) {
		this.view = reverseAllView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String doc = ""; // fixme

		List<String> lines = Arrays.asList(doc.split(" "));
		Collections.reverse(lines);

		TextToSpeechAPI freeTTS = textToSpeechAPIFactory.getTTSApi();
		try {
			for (int n = 0; n < lines.size(); n += 1) {
				freeTTS.play(lines.get(n));
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}
}
