package com.t2s.staying.home.T2S.StayingHome.factory;

import com.t2s.staying.home.T2S.StayingHome.tts.FakeTextToSpeechAPI;
import com.t2s.staying.home.T2S.StayingHome.tts.FreeTTSAdapter;
import com.t2s.staying.home.T2S.StayingHome.tts.TextToSpeechAPI;

import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.FAKE_TTS;
import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.FREE_TTS;

public class TextToSpeechAPIFactory {

	public TextToSpeechAPI getTTSApi(String text2SpeechApi) {
		if (text2SpeechApi.equals(FREE_TTS)) {
			return new FreeTTSAdapter();
		} else if (text2SpeechApi.equals(FAKE_TTS)) {
			return new FakeTextToSpeechAPI();
		}
		return null;
	}
}
