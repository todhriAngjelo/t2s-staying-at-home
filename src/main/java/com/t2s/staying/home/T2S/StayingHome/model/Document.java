package com.t2s.staying.home.T2S.StayingHome.model;

import com.t2s.staying.home.T2S.StayingHome.tts.TextToSpeechAPI;

import java.util.List;

public class Document {

	// models should be pure. no methods here only properties and setters getters. if we need business logic we can create managers
//	private EncodingStrategy encodingStrategy;
	private List<Line>  lines;
	private Long creationTime;
	private Long lastModifiedTime;
	private String authorsName;
	private String title;

	public List<Line> getLines() {
		return lines;
	}

	public void setLines(List<Line> lines) {
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