package com.t2s.staying.home.T2S.StayingHome.model;

import java.util.List;

public class Line {

	// models should be pure. no methods here only properties and setters getters. if we need business logic we can craete managers
	private List<String> words;
	private EncodingStrategy encodingStrategy;
	private Text2SpeechAPI audioManager;

	public List<String> getWords() {
		return words;
	}

	public void setWords(List<String> words) {
		this.words = words;
	}

	public EncodingStrategy getEncodingStrategy() {
		return encodingStrategy;
	}

	public void setEncodingStrategy(EncodingStrategy encodingStrategy) {
		this.encodingStrategy = encodingStrategy;
	}

	public Text2SpeechAPI getAudioManager() {
		return audioManager;
	}

	public void setAudioManager(Text2SpeechAPI audioManager) {
		this.audioManager = audioManager;
	}
}
