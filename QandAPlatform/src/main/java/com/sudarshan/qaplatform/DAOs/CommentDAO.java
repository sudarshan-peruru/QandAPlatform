package com.sudarshan.qaplatform.DAOs;

import javax.validation.constraints.NotBlank;

public class CommentDAO {
	
	@NotBlank(message = "QAPlatform : Question text cannot be blank.")
	private String text;
	
	private Integer userID;
	
	private Integer answerID;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public Integer getAnswerID() {
		return answerID;
	}

	public void setAnswerID(Integer answerID) {
		this.answerID = answerID;
	}

	
	
	
	
}
