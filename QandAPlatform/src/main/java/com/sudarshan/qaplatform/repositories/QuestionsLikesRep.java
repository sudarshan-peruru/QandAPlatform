package com.sudarshan.qaplatform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sudarshan.qaplatform.entities.QuesLikesIDClass;
import com.sudarshan.qaplatform.entities.QuestionsLikes;

public interface QuestionsLikesRep extends JpaRepository<QuestionsLikes, QuesLikesIDClass>{

}
