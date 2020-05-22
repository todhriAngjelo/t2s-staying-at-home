package com.t2s.staying.home.T2S.StayingHome.tts;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import java.beans.PropertyVetoException;

import static com.t2s.staying.home.T2S.StayingHome.ApplicationConstants.*;
import static java.lang.System.setProperty;
import javax.speech.synthesis.SpeakableListener;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import javax.speech.synthesis.SynthesizerProperties;

public class FreeTTSAdapter implements TextToSpeechAPI {
	private Synthesizer synthesizer;
    Voice voice;
	VoiceManager vm = VoiceManager.getInstance();
	private float volume = -1.0F;
	public FreeTTSAdapter() {
		setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
		setProperty("mbrola.base", "C:\\Users\\nikos\\freetts-1.2.2-bin\\freetts-1.2\\mbrola");
		this.voice = vm.getVoice(VOICE_KEVIN);
		voice.allocate();
		System.out.println("getvolume  "+ voice.getVolume());
	}

	public void play(String text) {
		this.voice.speak(text);
	}


	public void setVolume(float volume) {
		this.voice.setVolume(volume);
	}

	public void setPitch(int pitch) {
		this.voice.setPitch(pitch);
	}

	public void setRate(int rate) {
		this.voice.setRate(rate);
	}
}
