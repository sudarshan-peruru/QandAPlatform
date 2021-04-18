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
@Table(name = "Questions")
public class Questions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "Text")
	private String text;
	
	@JsonIgnoreProperties({"questions"})
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "Subtopic_ID", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private SubTopics subTopics;
	
	@JsonIgnoreProperties({"questions"})
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "User_ID", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Users users;

	public Questions(Integer id, String text, SubTopics subTopics, Users users) {
		super();
		this.id = id;
		this.text = text;
		this.subTopics = subTopics;
		this.users = users;
	}

	public Questions() {
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

	public SubTopics getSubTopic() {
		return subTopics;
	}

	public void setSubTopic(SubTopics subTopics) {
		this.subTopics = subTopics;
	}

	public Users getUser() {
		return users;
	}

	public void setUser(Users users) {
		this.users = users;
	}
	
}
