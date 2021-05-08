package com.sudarshan.qaplatform.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;
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
	
	@Column(name = "Likes_count")
	private Integer likesCount = 0;
	
	@JsonFormat(pattern = "dd-MMM-yyyy HH:mm:ss")
	@Column(name = "Creation_date", insertable = false, updatable = false)
	private Date creationDate;
	
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
	
	@JsonIgnoreProperties({"answers", "questions"})
	@OneToMany(mappedBy = "questions")
	List<Answers> answers;
	
	@ManyToMany
	@JsonIgnoreProperties("companyQuestions")
	@JoinTable(
			name = "Questions_Company_Map",
			joinColumns = @JoinColumn(name = "Questions_ID"),
			inverseJoinColumns = @JoinColumn(name = "Company_ID"))
	private List<Company> questionCompanies;
	
	
	@ManyToMany
	@JsonIgnoreProperties("tagsQuestions")
	@JoinTable(
			name = "questions_tags_map",
			joinColumns = @JoinColumn(name = "Questions_ID"),
			inverseJoinColumns = @JoinColumn(name = "Tags_ID"))
	private List<Tags> questionTags;
	
//	public Questions(Integer id, String text, SubTopics subTopics, Users users) {
//		super();
//		this.id = id;
//		this.text = text;
//		this.subTopics = subTopics;
//		this.users = users;
//	}
//
//	public Questions(Integer id, String text, SubTopics subTopics, Users users, List<Company> qCompanies) {
//		super();
//		this.id = id;
//		this.text = text;
//		this.subTopics = subTopics;
//		this.users = users;
//		this.questionCompanies = qCompanies;
//	}
//
//	public Questions() {
//		super();
//	}

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

	public List<Company> getQuestionCompanies() {
		return questionCompanies;
	}

	public void setQuestionCompanies(List<Company> questionCompanies) {
		this.questionCompanies = questionCompanies;
	}

	public List<Tags> getQuestionTags() {
		return questionTags;
	}

	public void setQuestionTags(List<Tags> questionTags) {
		this.questionTags = questionTags;
	}

	public List<Answers> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answers> answers) {
		this.answers = answers;
	}

	public Integer getLikesCount() {
		return likesCount;
	}

	public void setLikesCount(Integer likesCount) {
		this.likesCount = likesCount;
	}

	
	 
}
