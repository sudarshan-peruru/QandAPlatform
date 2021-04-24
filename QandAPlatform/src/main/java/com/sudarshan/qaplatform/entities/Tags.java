package com.sudarshan.qaplatform.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Tags")
public class Tags {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@NotBlank
	@Column(name = "Name")
	private String name;

	
	@ManyToMany(mappedBy = "questionTags")
	private List<Questions> tagsQuestions;
	
	public Tags() {
		super();
	}

	public Tags(Integer id, String name) {
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

	public List<Questions> getTagsQuestions() {
		return tagsQuestions;
	}

	public void setTagsQuestions(List<Questions> tagsQuestions) {
		this.tagsQuestions = tagsQuestions;
	}
	
	
}
