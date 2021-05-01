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
@Table(name = "answer_likes")
@IdClass(AnsLikesIDClass.class)
public class AnswersLikes {
	
	@Id
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "User_ID", nullable = false)
	private Users user;
	
	@Id
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "Answers_ID", nullable = false)
	@JsonIgnoreProperties({"questions"})
	private Answers answers;

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Answers getAnswers() {
		return answers;
	}

	public void setAnswers(Answers answers) {
		this.answers = answers;
	}
	
	
}
