package com.sudarshan.qaplatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudarshan.qaplatform.DAOs.AnswerDAO;
import com.sudarshan.qaplatform.entities.Answers;
import com.sudarshan.qaplatform.entities.Questions;
import com.sudarshan.qaplatform.entities.Users;
import com.sudarshan.qaplatform.exceptions.EntityNotFoundException;
import com.sudarshan.qaplatform.repositories.AnswersRep;
import com.sudarshan.qaplatform.repositories.QuestionsRep;
import com.sudarshan.qaplatform.repositories.UsersRep;

@Service
public class AnswersService {
	
	@Autowired
	UsersRep usersRep;
	@Autowired
	QuestionsRep questionsRep;
	@Autowired
	AnswersRep answersRep;
	
	
	public Answers createAnswers(AnswerDAO answerDAO) {
		Answers answer = new Answers();
		answer.setText(answerDAO.getText());
		Users users = usersRep.findById(answerDAO.getUser_ID())
				.orElseThrow(() -> new EntityNotFoundException("QAPlatform : User with ID: " + answerDAO.getUser_ID() + " does not exist."));
		answer.setUsers(users);
		Questions questions = questionsRep.findById(answerDAO.getQuestions_ID())
				.orElseThrow(() -> new EntityNotFoundException("QAPlatform : Question with ID: " + answerDAO.getQuestions_ID() + " does not exist."));
		answer.setQuestions(questions);
		return answersRep.save(answer);
	}
}
