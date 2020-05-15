package com.t2s.staying.home.T2S.StayingHome.model;

import com.t2s.staying.home.T2S.StayingHome.t2sClasses.FreeTTSAdapter;
import com.t2s.staying.home.T2S.StayingHome.theinterfaces.TextToSpeechAPI;

import java.util.Arrays;
import java.util.List;

public class Document {

	// models should be pure. no methods here only properties and setters getters. if we need business logic we can create managers
	private EncodingStrategy encodingStrategy;
	private TextToSpeechAPI audioManager;
	//private List<Line> lines;
	private String content;

	private Long creationTime;

	private String authorsName;
	private String title;

	public Document(){}

	public void setText(String content){
		this.content = content;
		List<String> lines = Arrays.asList(content.split("\n"));
	}

	public void setLines(){
	}

//	public List<Line> getLines() {
//		return lines;
//	}
//
//	public void setLines(List<Line> lines) {
//		this.lines = lines;
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

	public void playContents(String text){
		FreeTTSAdapter freeTTS = new FreeTTSAdapter();
		freeTTS.play(text);
	}

	public void playReverseContents(){}

	public void EncodedContents(){}

	public void playLine(int line){}

	public void playReverseLine(int line){}

	public void playEncodedLine(int line){}

	public void tuneEncodingStrategy(EncodingStrategy strategy){}

}