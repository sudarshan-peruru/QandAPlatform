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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Validated
@Api("CRUD operations on master entities")
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
	
	
	
	@ApiOperation(value = "Create a Company")
	@PostMapping("/company/create")
	public Company createCompany(@Valid @RequestBody Company company) {
		return companyService.createCompany(company);
	}
	
	@ApiOperation(value = "Retrive a Company")
	@GetMapping("/company/retrive/{id}")
	public Optional<Company> retriveCompany(@PathVariable(name = "id") int id) throws InvalidInputException {
		//if(id == 0) throw new InvalidInputException("QAPlatform : invalid ID given.");
		return companyService.retriveCompany(id);
	}

	@ApiOperation(value = "Retrive all Companys")
	@GetMapping("/company/retriveAll")
	public List<Company> retriveAllCompany() {
		return companyService.retriveAllCompany();
	}

	@ApiOperation(value = "Update a Company")
	@PutMapping("/company/update")
	public Company updateCompany(@Valid @RequestBody Company company) {
		return companyService.updateCompany(company);
	}

	@ApiOperation(value = "Delete a Company")
	@DeleteMapping("/company/delete/{id}")
	public void deleteCompany(@PathVariable(name = "id") @NotNull int id) throws InvalidInputException {
		//if(id == 0) throw new InvalidInputException("QAPlatform : invalid ID given.");
		companyService.deleteCompany(id);
	}

	@ApiOperation(value = "Delete all Companys")
	@DeleteMapping("/company/deleteAll")
	public void deleteAllCompany() {
		companyService.deleteAllCompany();
	}
	
	/**********************************************************************************************************
	**	Tags CRUD Controller End Points																	
	***********************************************************************************************************/

	@ApiOperation(value = "Create a Tag")
	@PostMapping("/tags/create")
	public Tags createtag(@Valid @RequestBody Tags tag) {
		return tagService.createTag(tag);
	}

	@ApiOperation(value = "Retrive a Tag")
	@GetMapping("/tags/retrive/{id}")
	public Optional<Tags> retriveTag(@PathVariable(name = "id") @NotNull  int id) throws EntityNotFoundException {
		return tagService.retriveTag(id);
	}

	@ApiOperation(value = "Retrive all Tags")
	@GetMapping("/tags/retriveAll")
	public List<Tags> retriveAllTags() {
		return tagService.retriveAllTags();
	}

	@ApiOperation(value = "Update a Tag")
	@PutMapping("/tags/update")
	public Tags updateTags(@Valid @RequestBody Tags tag) {
		return tagService.updateTags(tag);
	}

	@ApiOperation(value = "Delete a Tag")
	@DeleteMapping("/tags/delete/{id}")
	public void deleteTag(@PathVariable(name = "id") @NotNull int id) {
		tagService.deleteTag(id);
	}

	@ApiOperation(value = "Delete all Tags")
	@DeleteMapping("/tags/deleteAll")
	public void deleteAllTags() {
		tagService.deleteAllTags();
	}
	
	/**********************************************************************************************************
	**	Topics CRUD Controller End Points																	
	***********************************************************************************************************/

	@ApiOperation(value = "Create a Topic")
	@PostMapping("/topics/create")
	public Topics createTopic(@Valid @RequestBody Topics topic) {
		return topicService.createTopic(topic);
	}

	@ApiOperation(value = "Retrive a Topic")
	@GetMapping("/topics/retrive/{id}")
	public Optional<Topics> retriveTopic(@PathVariable(name = "id") @NotNull  int id){
		return topicService.retriveTopic(id);
	}

	@ApiOperation(value = "Retrive all Topics")
	@GetMapping("/topics/retriveAll")
	public List<Topics> retriveAllTopics() {
		return topicService.retriveAllTopics();
	}

	@ApiOperation(value = "Update a Topic")
	@PutMapping("/topics/update")
	public Topics updateTopics(@Valid @RequestBody Topics topic) {
		return topicService.updateTopics(topic);
	}

	@ApiOperation(value = "Delete a Topic")
	@DeleteMapping("/topics/delete/{id}")
	public void deleteTopic(@PathVariable(name = "id") @NotNull int id) {
		topicService.deleteTopic(id);
	}

	@ApiOperation(value = "Delete all Topics")
	@DeleteMapping("/topics/deleteAll")
	public void deleteAllTopics() {
		topicService.deleteAllTopics();
	}
	
	/**********************************************************************************************************
	**	Subtopics CRUD Controller End Points																	
	***********************************************************************************************************/

	@ApiOperation(value = "Create a Subtopic")
	@PostMapping("/subtopics/create")
	public SubTopics createSubTopic(@Valid @RequestBody SubTopicDAO subTopicDAO) {
		//System.out.println("Hello???");
		return subTopicService.createSubTopic(subTopicDAO);
	}

	@ApiOperation(value = "Retrive a Subtopic")
	@GetMapping("/subtopics/retrive/{id}")
	public Optional<SubTopics> retriveSubTopic(@PathVariable(name = "id") @NotNull  int id){
		return subTopicService.retriveSubTopic(id);
	}

	@ApiOperation(value = "Retrive all Subtopics")
	@GetMapping("/subtopics/retriveAll")
	public List<SubTopics> retriveAllSubTopics() {
		return subTopicService.retriveAllSubTopics();
	}

	@ApiOperation(value = "Update a Subtopic")
	@PutMapping("/subtopics/update")
	public SubTopics updateSubTopics(@Valid @RequestBody SubTopicDAO subTopicDAO) {
		return subTopicService.updateTopics(subTopicDAO);
	}

	@ApiOperation(value = "Delete a Subtopic")
	@DeleteMapping("/subtopics/delete/{id}")
	public void deleteSubTopic(@PathVariable(name = "id") @NotNull int id) {
		subTopicService.deleteSubTopic(id);
	}

	@ApiOperation(value = "Delete all Subtopics")
	@DeleteMapping("/subtopics/deleteAll")
	public void deleteAllSubTopics() {
		subTopicService.deleteAllSubTopics();
	}
	
	/**********************************************************************************************************
	**	User CRUD Controller End Points																	
	***********************************************************************************************************/

	@ApiOperation(value = "Create a User")
	@PostMapping("/user/create")
	public Users createUser(@Valid @RequestBody Users user) {
		return userService.createUser(user);
	}

	@ApiOperation(value = "Retrive a User")
	@GetMapping("/user/retrive/{id}")
	public Users retriveUser(@PathVariable(name = "id") @NotNull  int id){
		return userService.retriveUser(id);
	}

	@ApiOperation(value = "Retrive all Users")
	@GetMapping("/user/retriveAll")
	public List<Users> retriveAllUser() {
		return userService.retriveAllUsers();
	}

	@ApiOperation(value = "Update a User")
	@PutMapping("/user/update")
	public Users updateUser(@Valid @RequestBody Users user) {
		return userService.updateUser(user);
	}

	@ApiOperation(value = "Delete a User")
	@DeleteMapping("/user/delete/{id}")
	public void deleteUser(@PathVariable(name = "id") @NotNull int id) {
		userService.deleteUser(id);
	}

	@ApiOperation(value = "Delete all Users")
	@DeleteMapping("/user/deleteAll")
	public void deleteAllUsers() {
		userService.deleteAllUsers();
	}
	
}