package com.sudarshan.qaplatform.entities;

import java.io.Serializable;

public class QuesLikesIDClass implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer questions;
	
	private Integer user;

	public Integer getQuestions() {
		return questions;
	}

	public void setQuestions(Integer questions) {
		this.questions = questions;
	}

	public Integer getUser() {
		return user;
	}

	public void setUser(Integer user) {
		this.user = user;
	}

}
