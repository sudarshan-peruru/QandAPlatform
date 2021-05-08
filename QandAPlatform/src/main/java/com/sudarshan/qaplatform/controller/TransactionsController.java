package com.sudarshan.qaplatform.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sudarshan.qaplatform.DAOs.AnswerDAO;
import com.sudarshan.qaplatform.DAOs.CommentDAO;
import com.sudarshan.qaplatform.DAOs.QueryInDAO;
import com.sudarshan.qaplatform.DAOs.QueryOutDAO;
import com.sudarshan.qaplatform.DAOs.QuestionDAO;
import com.sudarshan.qaplatform.entities.AnsLikesIDClass;
import com.sudarshan.qaplatform.entities.Answers;
import com.sudarshan.qaplatform.entities.AnswersLikes;
import com.sudarshan.qaplatform.entities.Comments;
import com.sudarshan.qaplatform.entities.QuesLikesIDClass;
import com.sudarshan.qaplatform.entities.Questions;
import com.sudarshan.qaplatform.entities.QuestionsLikes;
import com.sudarshan.qaplatform.service.AnswersLikesService;
import com.sudarshan.qaplatform.service.AnswersService;
import com.sudarshan.qaplatform.service.CommentsService;
import com.sudarshan.qaplatform.service.QuestionsLikesService;
import com.sudarshan.qaplatform.service.QuestionsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Validated
@RestController
@Api
@RequestMapping("/transactions")
public class TransactionsController {
	
	
	@Autowired
	QuestionsService questionsService;
	@Autowired
	AnswersService answersService;
	@Autowired
	CommentsService commentsService;
	@Autowired
	AnswersLikesService answersLikesService;
	@Autowired
	QuestionsLikesService questionsLikesService;
	
	/**********************************************************************************************************
	**	Question Controller 															
	***********************************************************************************************************/
	
	@ApiOperation(value = "Create a Question")
	@PostMapping(value = "/question/create")
	public Questions createQuestion(@Valid @RequestBody QuestionDAO questionDAO) {
		return questionsService.createQuestion(questionDAO);
	}
	
	@ApiOperation(value = "Retrive all Questions")
	@GetMapping(value = "/question/retriveAll")
	public List<Questions> retriveAllQuestions() {
		return questionsService.retriveAllQuestions();
	}
	
	@ApiOperation(value = "Retrive a Question")
	@GetMapping(value = "/question/retrive/{id}")
	public Questions retriveQuestion(@PathVariable(name = "id") int id) {
		return questionsService.retriveQuestion(id);
	}
	
	@ApiOperation(value = "Filter Questions")
	@PostMapping(value = "/question/filter")
	public List<QueryOutDAO> filterQuestions(@Valid @RequestBody QueryInDAO queryInDAO) {
		return questionsService.filterQuestions(queryInDAO);	
	}
	
	/**********************************************************************************************************
	**	Answer Controller 															
	***********************************************************************************************************/

	@ApiOperation(value = "Create an Answer")
	@PostMapping(value = "/answer/create")
	public Answers createAnswer(@Valid @RequestBody AnswerDAO answerDAO) {
		return answersService.createAnswers(answerDAO);
	}
	
	@ApiOperation(value = "Retrive all Answers")
	@GetMapping(value = "/answer/retriveAll")
	public List<Answers> retriveAllAnswers() {
		return answersService.retriveAllAnswers();
	}
	
	/**********************************************************************************************************
	**	Comment Controller 															
	***********************************************************************************************************/
	
	@ApiOperation(value = "Create a Comment")
	@PostMapping(value = "/comment/create")
	public Comments createComment(@Valid @RequestBody CommentDAO commentDAO) {
		return commentsService.createComment(commentDAO);
	}
	
	@ApiOperation(value = "Retrive all Comments")
	@GetMapping(value = "/comment/retriveAll")
	public List<Comments> retriveAllComments() {
		return commentsService.retriveAllComments();
	}
	
	/**********************************************************************************************************
	**	Answer Likes Controller 															
	***********************************************************************************************************/
	
	@ApiOperation(value = "Create Like to an Answer")
	@PostMapping(value = "/answersLikes/create")
	public AnswersLikes createAnswersLikes(@Valid @RequestBody AnsLikesIDClass ansLikesIDClass) {
		
		return answersLikesService.createAnswersLikes(ansLikesIDClass);
	}
	
	@ApiOperation(value = "Retrive all Likes to all Answers")
	@GetMapping(value = "/answersLikes/retriveAll")
	public List<AnswersLikes> retriveAllAnswersLikes() {
		
		return answersLikesService.retriveallAnswersLikes();
	}
	
	/**********************************************************************************************************
	**	Question Likes Controller 															
	***********************************************************************************************************/
	
	@ApiOperation(value = "Create Like to a Question")
	@PostMapping(value = "/questionsLikes/create")
	public QuestionsLikes createQuestionLikes(@Valid @RequestBody QuesLikesIDClass quesLikesIDClass) {
		
		return questionsLikesService.createQuestionsLikes(quesLikesIDClass);
	}
	
	@ApiOperation(value = "Retrive all Likes to all Questions")
	@GetMapping(value = "/questionsLikes/retriveAll")
	public List<QuestionsLikes> retriveAllQuestionLikes() {
		
		return questionsLikesService.retriveAllQuestionsLikes();
	}
}
