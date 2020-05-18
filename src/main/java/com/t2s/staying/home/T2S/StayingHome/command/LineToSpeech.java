package com.t2s.staying.home.T2S.StayingHome.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView;

public class LineToSpeech implements ActionListener {

	private DocumentEditorView lineToSpeechView;

	public LineToSpeech(DocumentEditorView lineToSpeechView) {
		this.lineToSpeechView = lineToSpeechView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		lineToSpeech(lineToSpeechView);
	}
}
