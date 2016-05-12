package com.example.sql.db;

public class DictionaryEV {
	private String english_word;
	private String vietnam_word;

	public DictionaryEV() {

	}

	public DictionaryEV(String english_word, String vietnam_word) {
		this.english_word = english_word;
		this.vietnam_word = vietnam_word;
	}

	public String getEnglish_word() {
		return english_word;
	}

	public void setEnglish_word(String english_word) {
		this.english_word = english_word;
	}

	public String getVietnam_word() {
		return vietnam_word;
	}

	public void setVietnam_word(String vietnam_word) {
		this.vietnam_word = vietnam_word;
	}

}
