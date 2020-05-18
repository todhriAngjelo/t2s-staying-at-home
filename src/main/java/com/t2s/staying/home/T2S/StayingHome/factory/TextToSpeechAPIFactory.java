package com.t2s.staying.home.T2S.StayingHome.factory;

import com.t2s.staying.home.T2S.StayingHome.tts.FakeTextToSpeechAPI;
import com.t2s.staying.home.T2S.StayingHome.tts.FreeTTSAdapter;
import com.t2s.staying.home.T2S.StayingHome.tts.TextToSpeechAPI;

public class TextToSpeechAPIFactory {

	//    @Value("${text.to.speech.api}")
	private String text2SpeechApi = "freeTTSAdapter";

	public TextToSpeechAPI getTTSApi() {
		if (text2SpeechApi.equals("freeTTSAdapter")) {
			return new FreeTTSAdapter();
		} else if (text2SpeechApi.equals("FakeT2s")) {
			return new FakeTextToSpeechAPI();
		}
		return null;
	}
}
