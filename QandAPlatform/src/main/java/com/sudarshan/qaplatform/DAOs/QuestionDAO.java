package com.sudarshan.qaplatform.DAOs;

import java.util.LinkedList;
import java.util.List;

import javax.validation.constraints.NotBlank;

public class QuestionDAO {
	@NotBlank(message = "QAPlatform : Question text cannot be blank.")
	private String text;
	private List<Integer> companyID;
	//@NotBlank(message = "QAPlatform : Question subtopic cannot be blank.")
	private Integer subTopicID;
	private List<Integer> tagsList = new LinkedList<>();
	//@NotBlank(message = "QAPlatform : User cannot be blank.")
	private Integer userID;

	
	
	public QuestionDAO(String text, List<Integer> companyID, Integer subTopicID, List<Integer> tagsList, Integer userID){
		super();
		this.text = text;
		this.companyID = companyID;
		this.subTopicID = subTopicID;
		this.tagsList = tagsList;
		this.userID = userID;
	}

	public QuestionDAO() {
		super();
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public List<Integer> getCompanyID() {
		return companyID;
	}

	public void setCompanyID(List<Integer> companyID) {
		this.companyID = companyID;
	}

	public Integer getSubTopicID() {
		return subTopicID;
	}
	
	public void setSubTopicID(Integer subTopicID) {
		this.subTopicID = subTopicID;
	}
	
	public Integer getUserID() {
		return userID;
	}
	
	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public List<Integer> getTagsList() {
		return tagsList;
	}

	public void setTagsList(List<Integer> tagsList) {
		this.tagsList = tagsList;
	}
	
}
