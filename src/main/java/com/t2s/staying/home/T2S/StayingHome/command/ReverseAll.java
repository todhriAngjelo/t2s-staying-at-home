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

	public ReverseAll(DocumentEditorView reverseAllView) {
		this.view = reverseAllView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		List<Line> currentLines = documentManager.getCurrentDocument().getLines();
		Collections.reverse(currentLines);

		/* todo intialise a local list<line> with the reverse currentLines
		*   if not our current doc is updating to reversed and we dont want this
		* bcs if we press again reverse button its gonna read it "reverse" again that is the
		* original*/

		try {
			for (Line currentLine : currentLines) {
				Collections.reverse(currentLine.getWords());
				for (String word : currentLine.getWords()) {
					t2s.play(word);
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}
}
