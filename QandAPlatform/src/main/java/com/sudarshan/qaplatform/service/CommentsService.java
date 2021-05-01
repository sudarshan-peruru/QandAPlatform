package com.sudarshan.qaplatform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudarshan.qaplatform.DAOs.CommentDAO;
import com.sudarshan.qaplatform.entities.Answers;
import com.sudarshan.qaplatform.entities.Comments;
import com.sudarshan.qaplatform.entities.Users;
import com.sudarshan.qaplatform.exceptions.EntityNotFoundException;
import com.sudarshan.qaplatform.repositories.AnswersRep;
import com.sudarshan.qaplatform.repositories.CommentsRep;
import com.sudarshan.qaplatform.repositories.UsersRep;

@Service
public class CommentsService {
	@Autowired
	UsersRep usersRep;
	@Autowired
	AnswersRep answersRep;
	@Autowired
	CommentsRep commentsRep;
	
	public Comments createComment(CommentDAO commentDAO) {
		Comments comment = new Comments();
		comment.setText(commentDAO.getText());
		Users user = usersRep.findById(commentDAO.getUserID())
				.orElseThrow(() -> new EntityNotFoundException("QAPlatform: Given user id " + commentDAO.getUserID() + " does not exist."));
		comment.setUsers(user);
		Answers answer = answersRep.findById(commentDAO.getAnswerID())
				.orElseThrow(() -> new EntityNotFoundException("QAPlatform: Given answer id " + commentDAO.getAnswerID() + " does not exist."));
		comment.setAnswers(answer);
		return commentsRep.save(comment);
	}

	public List<Comments> retriveAllComments() {
		return commentsRep.findAll();
	}
}
