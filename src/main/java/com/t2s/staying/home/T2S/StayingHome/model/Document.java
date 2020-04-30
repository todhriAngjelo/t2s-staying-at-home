package com.t2s.staying.home.T2S.StayingHome.model;

public class Document {

	// models should be pure. no methods here only properties and setters getters. if we need business logic we can craete managers
	private EncodingStrategy encodingStrategy;
	private Text2SpeechAPI audioManager;

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
