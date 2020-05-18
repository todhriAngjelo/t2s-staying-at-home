package com.t2s.staying.home.T2S.StayingHome.factory;

import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.TUNE_VOLUME_COMMAND;

import javax.swing.event.ChangeListener;

import com.t2s.staying.home.T2S.StayingHome.command.TuneVolume;
import com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView;

public class TextToSpeechFactory {

	public ChangeListener createChangeListener(String commandKind, Object view) {

		if (commandKind.equals(TUNE_VOLUME_COMMAND)) {
			return new TuneVolume((DocumentEditorView) view);
		}

		return null;
	}
}
