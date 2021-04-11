package com.sudarshan.qaplatform.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudarshan.qaplatform.entities.Topics;
import com.sudarshan.qaplatform.exceptions.EntityNotFoundException;
import com.sudarshan.qaplatform.repositories.TopicsRep;

@Service
public class TopicService {
	@Autowired
	TopicsRep topicsRep;
	
	public Topics createTopic(Topics topic) {
		return topicsRep.save(topic);
	}
	
	public Optional<Topics> retriveTopic(int id) throws EntityNotFoundException {
		//System.out.println("hello");
		if(!topicsRep.existsById(id)) {
			throw new EntityNotFoundException("QAPlatform : Topic with id: " + id + ", not found.");
		}
		return topicsRep.findById(id);
	}
	
	public List<Topics> retriveAllTopics() {
		return topicsRep.findAll();
	}
	
	public Topics updateTopics(Topics topic) {
		if(!topicsRep.existsById(topic.getId())) {
			throw new EntityNotFoundException("QAPlatform : Topic with id: " + topic.getId() + ", not found.");
		}
		return topicsRep.save(topic);
	}
	
	public void deleteTopic(int id) {
		if(!topicsRep.existsById(id)) {
			throw new EntityNotFoundException("QAPlatform : Topic with id: " + id + ", not found.");
		}
		topicsRep.deleteById(id);
	}
	
	public void deleteAllTopics() {
		topicsRep.deleteAll();
	}
}
