package com.sudarshan.qaplatform.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudarshan.qaplatform.DAOs.QuestionCreateDAO;
import com.sudarshan.qaplatform.entities.Questions;
import com.sudarshan.qaplatform.entities.SubTopics;
import com.sudarshan.qaplatform.entities.Users;
import com.sudarshan.qaplatform.repositories.QuestionsRep;
import com.sudarshan.qaplatform.repositories.SubTopicsRep;
import com.sudarshan.qaplatform.repositories.UsersRep;

@Service
public class QuestionsService {
	
	@Autowired
	QuestionsRep questionsRep;
	@Autowired
	SubTopicsRep subTopicsRep;
	@Autowired
	UsersRep usersRep;
	
	public Questions createQuestion(QuestionCreateDAO questionCreateDAO) {
		Questions question = new Questions();
		question.setText(questionCreateDAO.getText());
		SubTopics subTopic = subTopicsRep.findById(questionCreateDAO.getSubTopicID()).orElseThrow(() -> new EntityNotFoundException("QAPlatform : SubTopic with ID: " + questionCreateDAO.getSubTopicID() + " does not exist."));
		question.setSubTopic(subTopic);
		Users user = usersRep.findById(questionCreateDAO.getUserID()).orElseThrow(() -> new EntityNotFoundException("QAPlatform : User with ID: " + questionCreateDAO.getUserID() + " does not exist."));
		question.setUser(user);
		return questionsRep.save(question);
	}
	
//	public Questions retrive() {
//		
//	}
}
