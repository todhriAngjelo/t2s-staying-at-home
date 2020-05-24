package com.t2s.staying.home.T2S.StayingHome.command;

import com.t2s.staying.home.T2S.StayingHome.encoding.EncodingStrategy;
import com.t2s.staying.home.T2S.StayingHome.factory.StrategiesFactory;
import com.t2s.staying.home.T2S.StayingHome.factory.TextToSpeechAPIFactory;
import com.t2s.staying.home.T2S.StayingHome.manager.DocumentManager;
import com.t2s.staying.home.T2S.StayingHome.tts.TextToSpeechAPI;
import com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.FREE_TTS;
import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.ROT13;

public class EncodeLineRiot13 implements ActionListener {

	private DocumentManager documentManager = new DocumentManager();
	private DocumentEditorView view;
	private StrategiesFactory strategy = new StrategiesFactory();
	EncodingStrategy rot13 = strategy.createStrategy(ROT13);

	public EncodeLineRiot13(DocumentEditorView view) {
		this.view = view;
	}

	private TextToSpeechAPIFactory textToSpeech = new TextToSpeechAPIFactory();
	TextToSpeechAPI t2s = textToSpeech.getTTSApi(FREE_TTS);

	@Override
	public void actionPerformed(ActionEvent e) {
		int lineNumber = view.getLineNumber();
		try {
			List<String> displayText = DocumentManager.encodingLineAndSpeech(t2s, rot13, lineNumber);
			view.showMessageDialog("The encoded text is: " + displayText);

		} catch (Exception exception) {
			exception.printStackTrace();
		}
		view.getReplayManager().add(this);
	}
}
