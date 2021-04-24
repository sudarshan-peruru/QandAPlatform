package com.sudarshan.qaplatform.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sudarshan.qaplatform.DAOs.AnswerDAO;
import com.sudarshan.qaplatform.DAOs.QuestionDAO;
import com.sudarshan.qaplatform.entities.Answers;
import com.sudarshan.qaplatform.entities.Questions;
import com.sudarshan.qaplatform.service.AnswersService;
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
	
	@ApiOperation(value = "Create a Question")
	@PostMapping(value = "/question/create")
	public Questions createQuestion(@Valid @RequestBody QuestionDAO questionDAO) {
		return questionsService.createQuestion(questionDAO);
	}

	@ApiOperation(value = "Create an Answer")
	@PostMapping(value = "/answer/create")
	public Answers createAnswer(@Valid @RequestBody AnswerDAO answerDAO) {
		return answersService.createAnswers(answerDAO);
	}
}
