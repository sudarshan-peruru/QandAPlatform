package com.sudarshan.qaplatform.DAOs;

import javax.validation.constraints.NotBlank;

public class AnswerDAO {
	
	@NotBlank(message = "QAPlatform : Answer text cannot be blank.")
	private String text;
	
	private Integer user_ID;
	
	private Integer questions_ID;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getUser_ID() {
		return user_ID;
	}

	public void setUser_ID(Integer user_ID) {
		this.user_ID = user_ID;
	}

	public Integer getQuestions_ID() {
		return questions_ID;
	}

	public void setQuestions_ID(Integer questions_ID) {
		this.questions_ID = questions_ID;
	}
	
	
	
}
