package com.sudarshan.qaplatform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sudarshan.qaplatform.entities.Questions;


public interface QuestionsRep extends JpaRepository<Questions, Integer>{

}
