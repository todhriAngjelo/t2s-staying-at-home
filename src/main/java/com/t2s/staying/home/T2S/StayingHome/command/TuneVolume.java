package com.t2s.staying.home.T2S.StayingHome.command;

import com.t2s.staying.home.T2S.StayingHome.factory.TextToSpeechAPIFactory;
import com.t2s.staying.home.T2S.StayingHome.tts.TextToSpeechAPI;
import com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.FREE_TTS;

public class TuneVolume implements ChangeListener {

	TextToSpeechAPIFactory factory = new TextToSpeechAPIFactory();
	DocumentEditorView view;
	private TextToSpeechAPIFactory textToSpeech = new TextToSpeechAPIFactory();
	TextToSpeechAPI t2s =  textToSpeech.getTTSApi(FREE_TTS);

	public TuneVolume(DocumentEditorView view) {
		this.view = view;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		//factory.getTTSApi().setVolume(view.getVolume());


		t2s.setPitch(view.getVoiceVolumeSlider().getValue());
		System.out.println("voicePitchSlider.getValue()  " + view.getVoicePitchSlider().getValue());
	}
}
