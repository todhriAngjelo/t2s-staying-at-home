package com.t2s.staying.home.T2S.StayingHome.model;

import java.util.Arrays;
import java.util.List;

public class Line {

	// models should be pure. no methods here only properties and setters getters.
	// if we need business logic we can create managers
	private List<String> words;

	public List<String> getWords() {
		return words;
	}

	public void setWords(List<String> words) {
		this.words = words;
	}
}
