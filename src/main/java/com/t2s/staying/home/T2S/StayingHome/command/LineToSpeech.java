package com.t2s.staying.home.T2S.StayingHome.command;

import com.t2s.staying.home.T2S.StayingHome.factory.TextToSpeechAPIFactory;
import com.t2s.staying.home.T2S.StayingHome.manager.DocumentManager;
import com.t2s.staying.home.T2S.StayingHome.tts.FreeTTSAdapter;
import com.t2s.staying.home.T2S.StayingHome.tts.TextToSpeechAPI;
import com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.FREE_TTS;

public class LineToSpeech implements ActionListener {

	private DocumentEditorView lineToSpeechView;
	private DocumentManager documentManager = new DocumentManager();
	public LineToSpeech(DocumentEditorView lineToSpeechView) {
		this.lineToSpeechView = lineToSpeechView;
	}
	private TextToSpeechAPIFactory textToSpeech = new TextToSpeechAPIFactory();
	TextToSpeechAPI t2s =  textToSpeech.getTTSApi(FREE_TTS);
	@Override
	public void actionPerformed(ActionEvent e) {
		int lineNumber = lineToSpeechView.getLineNumber();
		System.out.println("linenum1   " +lineNumber);
		List<String> currentLines = documentManager.getCurrentDocument().getLines();
		try {
			for (int n = 0; n < currentLines.size(); n += 1)
			{
				System.out.println("linenum2   " +lineNumber);
				System.out.println(currentLines.get(n));
				if (lineNumber == n) {
					System.out.println("ela mou");
					t2s.play(currentLines.get(n));
				}
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}
}
