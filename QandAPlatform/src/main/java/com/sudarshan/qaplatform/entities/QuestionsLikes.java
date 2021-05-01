package com.sudarshan.qaplatform.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "question_likes")
@IdClass(QuesLikesIDClass.class)
public class QuestionsLikes {
	
	@Id
	@JsonIgnoreProperties("quesitons")
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "Questions_ID", nullable = false)
	private Questions questions;
	
	@Id
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "User_ID", nullable = false)
	private Users user;

	public Questions getQuestions() {
		return questions;
	}

	public void setQuestions(Questions questions) {
		this.questions = questions;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
}
