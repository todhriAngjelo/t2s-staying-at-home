package com.t2s.staying.home.T2S.StayingHome.factory;

import com.t2s.staying.home.T2S.StayingHome.command.TunePitch;
import com.t2s.staying.home.T2S.StayingHome.command.TuneRate;
import com.t2s.staying.home.T2S.StayingHome.command.TuneVolume;
import com.t2s.staying.home.T2S.StayingHome.view.DocumentEditorView;

import javax.swing.event.ChangeListener;

import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.*;

public class TextToSpeechFactory {

	public ChangeListener createChangeListener(String commandKind, Object view) {

		if (commandKind.equals(TUNE_VOLUME_COMMAND)) {
			return new TuneVolume((DocumentEditorView) view);
		} else if(commandKind.equals(TUNE_RATE_COMMAND)){
			return new TuneRate((DocumentEditorView) view);
		} else if(commandKind.equals(TUNE_PITCH_COMMAND)){
			return new TunePitch((DocumentEditorView) view);
		}

		return null;
	}
}
