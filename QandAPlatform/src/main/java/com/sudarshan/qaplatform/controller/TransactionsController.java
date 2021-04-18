package com.sudarshan.qaplatform.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sudarshan.qaplatform.DAOs.QuestionCreateDAO;
import com.sudarshan.qaplatform.entities.Questions;
import com.sudarshan.qaplatform.service.QuestionsService;


@Validated
@RestController
@RequestMapping("/transactions")
public class TransactionsController {
	
	
	@Autowired
	QuestionsService questionsService;
	
	
	@PostMapping(value = "/question/create")
	public Questions createQuestion(@Valid @RequestBody QuestionCreateDAO questionCreateDAO) {
		return questionsService.createQuestion(questionCreateDAO);
	}

}
