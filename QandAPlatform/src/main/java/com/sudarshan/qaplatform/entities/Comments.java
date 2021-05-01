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

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "Comments")
public class Comments {
	
	@ApiModelProperty(hidden = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	@Id
	private Integer id;
	
	@Column(name = "Text")
	private String text;
	
	@ApiModelProperty(hidden = true)
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "User_ID", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Users users;
	
	@ApiModelProperty(hidden = true)
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "Answers_ID", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Answers answers;
	
	public Comments() {
		super();
	}
	
	

	public Comments(Integer id, String text, Users users, Answers answers) {
		super();
		this.id = id;
		this.text = text;
		this.users = users;
		this.answers = answers;
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



	public Answers getAnswers() {
		return answers;
	}



	public void setAnswers(Answers answers) {
		this.answers = answers;
	}

	
	
}
