package com.sudarshan.qaplatform.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudarshan.qaplatform.DAOs.SubTopicDAO;
import com.sudarshan.qaplatform.entities.SubTopics;
import com.sudarshan.qaplatform.entities.Topics;
import com.sudarshan.qaplatform.exceptions.EntityNotFoundException;
import com.sudarshan.qaplatform.repositories.SubTopicsRep;
import com.sudarshan.qaplatform.repositories.TopicsRep;

@Service
public class SubTopicService {
	@Autowired
	SubTopicsRep subTopicsRep;
	@Autowired
	TopicsRep topicsRep;
	
	public SubTopics createSubTopic(SubTopicDAO subTopicDAO) {
		SubTopics subTopic = new SubTopics();
		subTopic.setName(subTopicDAO.getName());
		Topics topics = topicsRep.findById(subTopicDAO.getTopicID())
				.orElseThrow( () -> new EntityNotFoundException("QAPlatform : Topic with id: " + subTopicDAO.getTopicID() + ", not found. Invalid Foreign Key."));
		subTopic.setTopics(topics);
		return subTopicsRep.save(subTopic);
	}
	
	public Optional<SubTopics> retriveSubTopic(int id) throws EntityNotFoundException {
		//System.out.println("hello");
		if(!subTopicsRep.existsById(id)) {
			throw new EntityNotFoundException("QAPlatform : Subtopic with id: " + id + ", not found.");
		}
		return subTopicsRep.findById(id);
	}
	
	public List<SubTopics> retriveAllSubTopics() {
		return subTopicsRep.findAll();
	}
	
	public SubTopics updateTopics(SubTopicDAO subTopicDAO) {
//		if(!subTopicsRep.existsById(subTopicDAO.getId())) {
//			throw new EntityNotFoundException("QAPlatform : Subtopic with id: " + subTopicDAO.getId() + ", not found.");
//		}
		Topics topics = topicsRep.findById(subTopicDAO.getTopicID())
				.orElseThrow( () -> new EntityNotFoundException("QAPlatform : Topic with id: " + subTopicDAO.getTopicID() + ", not found. Invalid Foreign Key."));
		SubTopics subTopic = subTopicsRep.findById(subTopicDAO.getId())
				.orElseThrow(() -> new EntityNotFoundException("QAPlatform : Subtopic with id: " + subTopicDAO.getId() + ", not found."));
		subTopic.setName(subTopicDAO.getName());
		subTopic.setTopics(topics);
		return subTopicsRep.save(subTopic);
	}
	
	public void deleteSubTopic(int id) {
		if(!subTopicsRep.existsById(id)) {
			throw new EntityNotFoundException("QAPlatform : Subtopic with id: " + id + ", not found.");
		}
		subTopicsRep.deleteById(id);
	}
	
	public void deleteAllSubTopics() {
		subTopicsRep.deleteAll();
	}
}
