package com.sudarshan.qaplatform.DAOs;

import java.sql.Date;
import java.util.List;

public class QueryInDAO {
	
	public List<Integer> companyIDs;
	
	public List<Integer> tagIDs;
	
	public List<Integer> subTopicIDs;

	public List<Integer> getCompanyIDs() {
		return companyIDs;
	}
	
	public Integer likesCount;
	
	public Date date;
	
	public void setCompanyIDs(List<Integer> companyIDs) {
		this.companyIDs = companyIDs;
	}

	public List<Integer> getTagIDs() {
		return tagIDs;
	}

	public void setTagIDs(List<Integer> tagIDs) {
		this.tagIDs = tagIDs;
	}

	public List<Integer> getSubTopicIDs() {
		return subTopicIDs;
	}

	public void setSubTopicIDs(List<Integer> subTopicIDs) {
		this.subTopicIDs = subTopicIDs;
	}

	public Integer getLikesCount() {
		return likesCount;
	}

	public void setLikesCount(Integer likesCount) {
		this.likesCount = likesCount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
