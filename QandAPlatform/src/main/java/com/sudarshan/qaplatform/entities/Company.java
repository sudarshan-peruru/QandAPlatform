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

import io.swagger.annotations.ApiModelProperty;


@Entity
@Table(name = "Company")
public class Company {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@NotBlank
	@Column(name = "Name")
	private String name;
	
	@ApiModelProperty(hidden = true)
	@ManyToMany(mappedBy = "questionCompanies")
	private List<Questions> companyQuestions;

	public Company() {

	}
	
	public Company(Integer id, String name) {
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

	public List<Questions> getCompanyQuestions() {
		return companyQuestions;
	}

	public void setCompanyQuestions(List<Questions> companyQuestions) {
		this.companyQuestions = companyQuestions;
	}
	
	
}
