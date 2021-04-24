package com.sudarshan.qaplatform.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Answers")
public class Answers {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "Text")
	private String text;

	@JsonIgnoreProperties({"answers"})
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "User_ID", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Users users;
	
	@JsonIgnoreProperties({"answers"})
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "Questions_ID", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Questions questions;
	
	public Answers() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Questions getQuestions() {
		return questions;
	}

	public void setQuestions(Questions questions) {
		this.questions = questions;
	}

}
