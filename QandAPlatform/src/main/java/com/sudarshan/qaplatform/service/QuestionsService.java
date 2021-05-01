package com.sudarshan.qaplatform.service;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudarshan.qaplatform.DAOs.QuestionDAO;
import com.sudarshan.qaplatform.entities.Company;
import com.sudarshan.qaplatform.entities.Questions;
import com.sudarshan.qaplatform.entities.SubTopics;
import com.sudarshan.qaplatform.entities.Tags;
import com.sudarshan.qaplatform.entities.Users;
import com.sudarshan.qaplatform.repositories.CompanyRep;
import com.sudarshan.qaplatform.repositories.QuestionsRep;
import com.sudarshan.qaplatform.repositories.SubTopicsRep;
import com.sudarshan.qaplatform.repositories.TagsRep;
import com.sudarshan.qaplatform.repositories.UsersRep;

@Service
public class QuestionsService {
	
	@Autowired
	QuestionsRep questionsRep;
	@Autowired
	SubTopicsRep subTopicsRep;
	@Autowired
	CompanyRep companyRep;
	@Autowired
	UsersRep usersRep;
	@Autowired
	TagsRep tagsRep;
	
	public Questions createQuestion(QuestionDAO questionDAO) {
		Questions question = new Questions();
		question.setText(questionDAO.getText());
		SubTopics subTopic = subTopicsRep.findById(questionDAO.getSubTopicID())
				.orElseThrow(() -> new EntityNotFoundException("QAPlatform : SubTopic with ID: " + questionDAO.getSubTopicID() + " does not exist."));
		question.setSubTopic(subTopic);
		Users user = usersRep.findById(questionDAO.getUserID())
				.orElseThrow(() -> new EntityNotFoundException("QAPlatform : User with ID: " + questionDAO.getUserID() + " does not exist."));
		Company company = companyRep.findById(questionDAO.getCompanyID())
				.orElseThrow(() -> new EntityNotFoundException("QAPlatform : Company with ID: " + questionDAO.getCompanyID() + " does not exist."));
		question.setUser(user);
		List<Company> li = new LinkedList<>();
		li.add(company);
		question.setQuestionCompanies(li);
		List<Integer> ids = questionDAO.getTagsList();
		List<Tags> tags = new LinkedList<>();
		for(int i : ids) {
			tags.add(tagsRep.findById(i)
					.orElseThrow(() -> new EntityNotFoundException("QAPlatform : Tag with ID: " + i + " does not exist.")));
		}
		question.setQuestionTags(tags);
		return questionsRep.save(question);
	}
	
	public List<Questions> retriveAllQuestions() {
		return questionsRep.findAll();
	}
	
//	public Questions retrive() {
//		
//	}
}
