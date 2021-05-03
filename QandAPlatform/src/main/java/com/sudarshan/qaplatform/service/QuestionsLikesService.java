package com.sudarshan.qaplatform.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudarshan.qaplatform.entities.QuesLikesIDClass;
import com.sudarshan.qaplatform.entities.Questions;
import com.sudarshan.qaplatform.entities.QuestionsLikes;
import com.sudarshan.qaplatform.entities.Users;
import com.sudarshan.qaplatform.repositories.QuestionsLikesRep;
import com.sudarshan.qaplatform.repositories.QuestionsRep;
import com.sudarshan.qaplatform.repositories.UsersRep;

@Service
public class QuestionsLikesService {
	
	@Autowired
	QuestionsLikesRep questionsLikesRep;
	@Autowired
	UsersRep usersRep;
	@Autowired
	QuestionsRep questionsRep;
	
	public QuestionsLikes createQuestionsLikes(QuesLikesIDClass quesLikesIDClass) {
		
		QuestionsLikes questionsLikes = new QuestionsLikes();
		Users user = usersRep.findById(quesLikesIDClass.getUser())
				.orElseThrow(() -> new EntityNotFoundException("User not found"));
		questionsLikes.setUser(user);
		Questions question = questionsRep.findById(quesLikesIDClass.getQuestions())
				.orElseThrow(() -> new EntityNotFoundException("User not found"));
		Optional<QuestionsLikes> ques = questionsLikesRep.findById(quesLikesIDClass);
		if(!ques.isPresent()) {
			question.setLikesCount(question.getLikesCount()+1);
			questionsRep.save(question);
		}
		questionsLikes.setQuestions(question);
		return questionsLikesRep.save(questionsLikes);
	}
	
	public List<QuestionsLikes> retriveAllQuestionsLikes() {
		return questionsLikesRep.findAll();
	}
}
