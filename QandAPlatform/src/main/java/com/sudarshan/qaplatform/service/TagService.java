package com.sudarshan.qaplatform.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudarshan.qaplatform.entities.Tags;
import com.sudarshan.qaplatform.exceptions.EntityNotFoundException;
import com.sudarshan.qaplatform.repositories.TagsRep;

@Service
public class TagService {
	
	@Autowired
	TagsRep tagsRep;
	
	public Tags createTag(Tags tag) {
		return tagsRep.save(tag);
	}
	
	public Optional<Tags> retriveTag(int id) throws EntityNotFoundException {
		//System.out.println("hello");
		if(!tagsRep.existsById(id)) {
			throw new EntityNotFoundException("QAPlatform : Tag with id: " + id + ", not found.");
		}
		return tagsRep.findById(id);
	}
	
	public List<Tags> retriveAllTags() {
		return tagsRep.findAll();
	}
	
	public Tags updateTags(Tags tag) {
		if(!tagsRep.existsById(tag.getId())) {
			throw new EntityNotFoundException("QAPlatform : Tag with id: " + tag.getId() + ", not found.");
		}
		return tagsRep.save(tag);
	}
	
	public void deleteTag(int id) {
		if(!tagsRep.existsById(id)) {
			throw new EntityNotFoundException("QAPlatform : Tag with id: " + id + ", not found.");
		}
		tagsRep.deleteById(id);
	}
	
	public void deleteAllTags() {
		tagsRep.deleteAll();
	}
}
