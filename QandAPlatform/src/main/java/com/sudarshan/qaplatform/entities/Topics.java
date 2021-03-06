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

@Entity
@Table(name = "Topic")
public class Topics {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	
	@Column(name = "Name")
	private String name;
	
	//@JsonManagedReference
	@JsonIgnoreProperties("subTopics")
	@OneToMany(mappedBy = "topics")
	List<SubTopics> subTopics;

	public Topics() {
		super();
	}

	public Topics(Integer id, String name) {
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

	public List<SubTopics> getSubTopics() {
		return subTopics;
	}

	public void setSubTopics(List<SubTopics> subTopics) {
		this.subTopics = subTopics;
	}
	
	
	
}
