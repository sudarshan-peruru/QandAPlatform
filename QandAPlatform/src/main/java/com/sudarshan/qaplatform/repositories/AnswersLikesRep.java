package com.sudarshan.qaplatform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sudarshan.qaplatform.entities.AnsLikesIDClass;
import com.sudarshan.qaplatform.entities.AnswersLikes;

public interface AnswersLikesRep extends JpaRepository<AnswersLikes, AnsLikesIDClass>{

}
