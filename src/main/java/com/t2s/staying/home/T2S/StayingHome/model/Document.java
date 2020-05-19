package com.t2s.staying.home.T2S.StayingHome.model;

import com.t2s.staying.home.T2S.StayingHome.tts.TextToSpeechAPI;

import java.util.List;

public class Document {

	// models should be pure. no methods here only properties and setters getters. if we need business logic we can create managers
	private EncodingStrategy encodingStrategy;
	private TextToSpeechAPI audioManager;
	private List<String> lines;
	private Long creationTime;
	private Long lastModifiedTime;
	private String authorsName;
	private String title;


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

	public List<String> getLines() {
		return lines;
	}

	public void setLines(List<String> lines) {
		this.lines = lines;
	}

	public Long getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Long creationTime) {
		this.creationTime = creationTime;
	}

	public String getAuthorsName() {
		return authorsName;
	}

	public void setAuthorsName(String authorsName) {
		this.authorsName = authorsName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(Long lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}
}