package com.t2s.staying.home.T2S.StayingHome.model;

import com.t2s.staying.home.T2S.StayingHome.theinterfaces.TextToSpeechAPI;

import java.util.Arrays;
import java.util.List;

public class Line {

	// models should be pure. no methods here only properties and setters getters.
	// if we need business logic we can create managers
	private List<String> words;
	private EncodingStrategy encodingStrategy;
	private TextToSpeechAPI audioManager;
	private String line;

	public void splitToWords(String line){
		this.line = line;
		List<String> words = Arrays.asList(line.split(" "));
	}

	private Line() {
	}

	public List<String> getWords() {
		return words;
	}

//	//public void setWords(List<String> words) {
//		this.words = words;
//	}

	public EncodingStrategy getEncodingStrategy() {
		return encodingStrategy;
	}

	public void setEncodingStrategy(EncodingStrategy encodingStrategy) {
		this.encodingStrategy = encodingStrategy;
	}

	public TextToSpeechAPI getAudioManager() {
		return audioManager;
	}

	public void setAudioManager(TextToSpeechAPI audioManager) {
		this.audioManager = audioManager;
	}
}
