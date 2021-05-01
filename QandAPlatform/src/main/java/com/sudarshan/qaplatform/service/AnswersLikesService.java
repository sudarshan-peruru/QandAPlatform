package com.sudarshan.qaplatform.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudarshan.qaplatform.entities.AnsLikesIDClass;
import com.sudarshan.qaplatform.entities.Answers;
import com.sudarshan.qaplatform.entities.AnswersLikes;
import com.sudarshan.qaplatform.entities.Users;
import com.sudarshan.qaplatform.repositories.AnswersLikesRep;
import com.sudarshan.qaplatform.repositories.AnswersRep;
import com.sudarshan.qaplatform.repositories.UsersRep;

@Service
public class AnswersLikesService {

	@Autowired
	AnswersLikesRep answersLikesRep;
	
	@Autowired
	UsersRep usersRep;
	
	@Autowired
	AnswersRep answersRep;
	
	public AnswersLikes createAnswersLikes(AnsLikesIDClass ansLikesIDClass) {
		AnswersLikes answersLikes = new AnswersLikes();
		
		Users user = usersRep.findById(ansLikesIDClass.getUser())
						.orElseThrow(() -> new EntityNotFoundException("User not found"));
		answersLikes.setUser(user);
		
		Answers answer = answersRep.findById(ansLikesIDClass.getAnswers())
							.orElseThrow(()-> new EntityNotFoundException("Answer not found"));
		answersLikes.setAnswers(answer);
		
		return answersLikesRep.save(answersLikes);
		
	}
	
	public List<AnswersLikes> retriveallAnswersLikes() {
		return answersLikesRep.findAll();
	}
}
