package com.sudarshan.qaplatform.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sudarshan.qaplatform.DAOs.SubTopicDAO;
import com.sudarshan.qaplatform.entities.Company;
import com.sudarshan.qaplatform.entities.SubTopics;
import com.sudarshan.qaplatform.entities.Tags;
import com.sudarshan.qaplatform.entities.Topics;
import com.sudarshan.qaplatform.entities.Users;
import com.sudarshan.qaplatform.exceptions.EntityNotFoundException;
import com.sudarshan.qaplatform.exceptions.InvalidInputException;
import com.sudarshan.qaplatform.service.CompanyService;
import com.sudarshan.qaplatform.service.SubTopicService;
import com.sudarshan.qaplatform.service.TagService;
import com.sudarshan.qaplatform.service.TopicService;
import com.sudarshan.qaplatform.service.UserService;

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
	@Autowired
	UserService userService;
	
	
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
	
	@PutMapping("/company/update")
	public Company updateCompany(@Valid @RequestBody Company company) {
		return companyService.updateCompany(company);
	}
	
	@DeleteMapping("/company/delete/{id}")
	public void deleteCompany(@PathVariable(name = "id") @NotNull int id) throws InvalidInputException {
		//if(id == 0) throw new InvalidInputException("QAPlatform : invalid ID given.");
		companyService.deleteCompany(id);
	}
	
	@DeleteMapping("/company/deleteAll")
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
	
	@PutMapping("/tags/update")
	public Tags updateTags(@Valid @RequestBody Tags tag) {
		return tagService.updateTags(tag);
	}
	
	@DeleteMapping("/tags/delete/{id}")
	public void deleteTag(@PathVariable(name = "id") @NotNull int id) {
		tagService.deleteTag(id);
	}
	
	@DeleteMapping("/tags/deleteAll")
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
	
	@PutMapping("/topics/update")
	public Topics updateTopics(@Valid @RequestBody Topics topic) {
		return topicService.updateTopics(topic);
	}
	
	@DeleteMapping("/topics/delete/{id}")
	public void deleteTopic(@PathVariable(name = "id") @NotNull int id) {
		topicService.deleteTopic(id);
	}
	
	@DeleteMapping("/topics/deleteAll")
	public void deleteAllTopics() {
		topicService.deleteAllTopics();
	}
	
	/**********************************************************************************************************
	**	Subtopics CRUD Controller End Points																	
	***********************************************************************************************************/
	
	@PostMapping("/subtopics/create")
	public SubTopics createSubTopic(@Valid @RequestBody SubTopicDAO subTopicDAO) {
		//System.out.println("Hello???");
		return subTopicService.createSubTopic(subTopicDAO);
	}
	
	@GetMapping("/subtopics/retrive/{id}")
	public Optional<SubTopics> retriveSubTopic(@PathVariable(name = "id") @NotNull  int id){
		return subTopicService.retriveSubTopic(id);
	}
	
	@GetMapping("/subtopics/retriveAll")
	public List<SubTopics> retriveAllSubTopics() {
		return subTopicService.retriveAllSubTopics();
	}
	
	@PutMapping("/subtopics/update")
	public SubTopics updateSubTopics(@Valid @RequestBody SubTopicDAO subTopicDAO) {
		return subTopicService.updateTopics(subTopicDAO);
	}
	
	@DeleteMapping("/subtopics/delete/{id}")
	public void deleteSubTopic(@PathVariable(name = "id") @NotNull int id) {
		subTopicService.deleteSubTopic(id);
	}
	
	@DeleteMapping("/subtopics/deleteAll")
	public void deleteAllSubTopics() {
		subTopicService.deleteAllSubTopics();
	}
	
	/**********************************************************************************************************
	**	User CRUD Controller End Points																	
	***********************************************************************************************************/
	
	@PostMapping("/user/create")
	public Users createUser(@Valid @RequestBody Users user) {
		return userService.createUser(user);
	}
	
	@GetMapping("/user/retrive/{id}")
	public Users retriveUser(@PathVariable(name = "id") @NotNull  int id){
		return userService.retriveUser(id);
	}
	
	@GetMapping("/user/retriveAll")
	public List<Users> retriveAllUser() {
		return userService.retriveAllUsers();
	}
	
	@PutMapping("/user/update")
	public Users updateUser(@Valid @RequestBody Users user) {
		return userService.updateUser(user);
	}
	
	@DeleteMapping("/user/delete/{id}")
	public void deleteUser(@PathVariable(name = "id") @NotNull int id) {
		userService.deleteUser(id);
	}
	
	@DeleteMapping("/user/deleteAll")
	public void deleteAllUsers() {
		userService.deleteAllUsers();
	}
	
}