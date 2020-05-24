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

import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.ATBASH;
import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.FREE_TTS;

public class EncodeLineAtbash implements ActionListener {

	private DocumentEditorView view;
	private StrategiesFactory strategy = new StrategiesFactory();
	EncodingStrategy atbash = strategy.createStrategy(ATBASH);

	public EncodeLineAtbash(DocumentEditorView view) {
		this.view = view;
	}

	private TextToSpeechAPIFactory textToSpeech = new TextToSpeechAPIFactory();
	TextToSpeechAPI t2s = textToSpeech.getTTSApi(FREE_TTS);

	@Override
	public void actionPerformed(ActionEvent e) {
		int lineNumber = view.getLineNumber();
		try {

			List<String> displayText = DocumentManager.encodingLineAndSpeech(t2s, atbash, lineNumber);
            view.showMessageDialog("The encoded text is: " + displayText);
        } catch (Exception exception) {
			exception.printStackTrace();
		}
		view.getReplayManager().add(this);
	}
}
