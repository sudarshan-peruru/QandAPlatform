package com.sudarshan.qaplatform.DAOs;

import java.util.LinkedList;
import java.util.List;

import javax.validation.constraints.NotBlank;

import com.sudarshan.qaplatform.entities.Tags;

public class QuestionCreateDAO {
	@NotBlank(message = "QAPlatform : Question text cannot be blank.")
	private String text;
	private Integer companyID;
	private Integer subTopicID;
	private List<Tags> tagsList = new LinkedList<>();
	private Integer userID;

	public QuestionCreateDAO(String text, Integer companyID, Integer subTopicID, Integer userID) {
		super();
		this.text = text;
		this.companyID = companyID;
		this.subTopicID = subTopicID;
		this.userID = userID;
	}
	
	public QuestionCreateDAO() {
		super();
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public Integer getCompanyID() {
		return companyID;
	}
	
	public void setCompanyID(Integer companyID) {
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

	public List<Tags> getTagsList() {
		return tagsList;
	}

	public void setTagsList(List<Tags> tagsList) {
		this.tagsList = tagsList;
	}
	
}
