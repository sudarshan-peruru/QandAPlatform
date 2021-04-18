package com.sudarshan.qaplatform.DAOs;

public class SubTopicDAO {
	private Integer id;
	private String name;
	private Integer topicID;
	
	public SubTopicDAO() {
		super();
	}
	
	public SubTopicDAO(Integer id, String name, Integer topicID) {
		super();
		this.id = id;
		this.name = name;
		this.topicID = topicID;
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

	public Integer getTopicID() {
		return topicID;
	}

	public void setTopicID(Integer topicID) {
		this.topicID = topicID;
	}
	
}
