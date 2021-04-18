package com.sudarshan.qaplatform.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "user")
public class Users {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "Name")
	@NotNull
	private String name;

	
//	@OneToMany(mappedBy = "users")
//	@JsonIgnoreProperties({"questions", "users"})
//	List<Questions> questions;
	
	public Users() {
		super();
	}

//	public Users(Integer id, String name) {
//		super();
//		this.id = id;
//		this.name = name;
//	}
	
	public Users(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public List<Questions> getQuestions() {
//		return questions;
//	}
//
//	public void setQuestions(List<Questions> questions) {
//		this.questions = questions;
//	}
	

}
