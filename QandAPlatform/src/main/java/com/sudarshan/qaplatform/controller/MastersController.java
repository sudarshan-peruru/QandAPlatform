package com.sudarshan.qaplatform.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sudarshan.qaplatform.entities.Company;
import com.sudarshan.qaplatform.entities.SubTopics;
import com.sudarshan.qaplatform.entities.Tags;
import com.sudarshan.qaplatform.entities.Topics;
import com.sudarshan.qaplatform.exceptions.EntityNotFoundException;
import com.sudarshan.qaplatform.exceptions.InvalidInputException;
import com.sudarshan.qaplatform.service.CompanyService;
import com.sudarshan.qaplatform.service.SubTopicService;
import com.sudarshan.qaplatform.service.TagService;
import com.sudarshan.qaplatform.service.TopicService;

@RestController
@Validated
@RequestMapping("/master")
public class MastersController {
	
	@Autowired
	CompanyService companyService;
	@Autowired
	TagService tagService;
	@Autowired
	TopicService topicService;
	@Autowired
	SubTopicService subTopicService;
	
	
	/**********************************************************************************************************
	**	Company CRUD Controller End Points																	
	***********************************************************************************************************/
	
	
	@PostMapping("/company/create")
	public Company createCompany(@Valid @RequestBody Company company) {
		return companyService.createCompany(company);
	}
	
	@GetMapping("/company/retrive/{id}")
	public Optional<Company> retriveCompany(@PathVariable(name = "id") int id) throws InvalidInputException {
		//if(id == 0) throw new InvalidInputException("QAPlatform : invalid ID given.");
		return companyService.retriveCompany(id);
	}
	
	@GetMapping("/company/retriveAll")
	public List<Company> retriveAllCompany() {
		return companyService.retriveAllCompany();
	}
	
	@PostMapping("/company/update")
	public Company updateCompany(@Valid @RequestBody Company company) {
		return companyService.updateCompany(company);
	}
	
	@GetMapping("/company/delete/{id}")
	public void deleteCompany(@PathVariable(name = "id") @NotNull int id) throws InvalidInputException {
		//if(id == 0) throw new InvalidInputException("QAPlatform : invalid ID given.");
		companyService.deleteCompany(id);
	}
	
	@GetMapping("/company/deleteAll")
	public void deleteAllCompany() {
		companyService.deleteAllCompany();
	}
	
	/**********************************************************************************************************
	**	Tags CRUD Controller End Points																	
	***********************************************************************************************************/
	
	@PostMapping("/tags/create")
	public Tags createtag(@Valid @RequestBody Tags tag) {
		return tagService.createTag(tag);
	}
	
	@GetMapping("/tags/retrive/{id}")
	public Optional<Tags> retriveTag(@PathVariable(name = "id") @NotNull  int id) throws EntityNotFoundException {
		return tagService.retriveTag(id);
	}
	
	@GetMapping("/tags/retriveAll")
	public List<Tags> retriveAllTags() {
		return tagService.retriveAllTags();
	}
	
	@PostMapping("/tags/update")
	public Tags updateTags(@Valid @RequestBody Tags tag) {
		return tagService.updateTags(tag);
	}
	
	@GetMapping("/tags/delete/{id}")
	public void deleteTag(@PathVariable(name = "id") @NotNull int id) {
		tagService.deleteTag(id);
	}
	
	@GetMapping("/tags/deleteAll")
	public void deleteAllTags() {
		tagService.deleteAllTags();
	}
	
	/**********************************************************************************************************
	**	Topics CRUD Controller End Points																	
	***********************************************************************************************************/
	
	@PostMapping("/topics/create")
	public Topics createTopic(@Valid @RequestBody Topics topic) {
		return topicService.createTopic(topic);
	}
	
	@GetMapping("/topics/retrive/{id}")
	public Optional<Topics> retriveTopic(@PathVariable(name = "id") @NotNull  int id){
		return topicService.retriveTopic(id);
	}
	
	@GetMapping("/topics/retriveAll")
	public List<Topics> retriveAllTopics() {
		return topicService.retriveAllTopics();
	}
	
	@PostMapping("/topics/update")
	public Topics updateTopics(@Valid @RequestBody Topics topic) {
		return topicService.updateTopics(topic);
	}
	
	@GetMapping("/topics/delete/{id}")
	public void deleteTopic(@PathVariable(name = "id") @NotNull int id) {
		topicService.deleteTopic(id);
	}
	
	@GetMapping("/topics/deleteAll")
	public void deleteAllTopics() {
		topicService.deleteAllTopics();
	}
	
	/**********************************************************************************************************
	**	Subtopics CRUD Controller End Points																	
	***********************************************************************************************************/
	
	@PostMapping("/subtopics/create/{id}")
	public SubTopics createSubTopic(@Valid @RequestBody SubTopics subTopic,@PathVariable(name = "id") @NotNull  int id) {
		//System.out.println("Hello???");
		return subTopicService.createSubTopic(subTopic, id);
	}
	
	@GetMapping("/subtopics/retrive/{id}")
	public Optional<SubTopics> retriveSubTopic(@PathVariable(name = "id") @NotNull  int id){
		return subTopicService.retriveSubTopic(id);
	}
	
	@GetMapping("/subtopics/retriveAll")
	public List<SubTopics> retriveAllSubTopics() {
		return subTopicService.retriveAllSubTopics();
	}
	
	@PostMapping("/subtopics/update/{id}")
	public SubTopics updateSubTopics(@Valid @RequestBody SubTopics subTopic,@PathVariable(name = "id") @NotNull  int id) {
		return subTopicService.updateTopics(subTopic, id);
	}
	
	@GetMapping("/subtopics/delete/{id}")
	public void deleteSubTopic(@PathVariable(name = "id") @NotNull int id) {
		subTopicService.deleteSubTopic(id);
	}
	
	@GetMapping("/subtopics/deleteAll")
	public void deleteAllSubTopics() {
		subTopicService.deleteAllSubTopics();
	}
}
