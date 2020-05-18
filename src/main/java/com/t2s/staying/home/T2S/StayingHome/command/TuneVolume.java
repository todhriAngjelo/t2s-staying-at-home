package com.t2s.staying.home.T2S.StayingHome.command;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.t2s.staying.home.T2S.StayingHome.factory.TextToSpeechAPIFactory;
import com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView;

public class TuneVolume implements ChangeListener {

	TextToSpeechAPIFactory factory = new TextToSpeechAPIFactory();
	DocumentEditorView view;

	public TuneVolume(DocumentEditorView view) {
		this.view = view;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		factory.getTTSApi().setVolume(view.getVolume());
	}
}
