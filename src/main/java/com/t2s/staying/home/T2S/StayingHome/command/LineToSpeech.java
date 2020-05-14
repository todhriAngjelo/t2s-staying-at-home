package com.t2s.staying.home.T2S.StayingHome.command;

import com.t2s.staying.home.T2S.StayingHome.t2sClasses.FreeTTSAdapter;
import com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LineToSpeech implements ActionListener {

	private DocumentEditorView lineToSpeechView;
	public LineToSpeech(DocumentEditorView lineToSpeechView){this.lineToSpeechView = lineToSpeechView;}
	@Override
	public void actionPerformed(ActionEvent e) {
		String selectedLine = lineToSpeechView.getJTextArea().getSelectedText();
		FreeTTSAdapter freeTTS = new FreeTTSAdapter();
		try {
			freeTTS.play(selectedLine);

		}catch(Exception e1) {}
	}
}
