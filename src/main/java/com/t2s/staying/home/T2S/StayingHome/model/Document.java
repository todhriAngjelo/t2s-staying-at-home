package com.t2s.staying.home.T2S.StayingHome.model;

import java.util.List;

public class Document {

	// models should be pure. no methods here only properties and setters getters. if we need business logic we can create managers
	private EncodingStrategy encodingStrategy;
	private Text2SpeechAPI audioManager;
	private List<Line> lines;

	private Long creationTime;

	private String authorsName;
	private String title;

	public List<Line> getLines() {
		return lines;
	}

	public void setLines(List<Line> lines) {
		this.lines = lines;
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
}