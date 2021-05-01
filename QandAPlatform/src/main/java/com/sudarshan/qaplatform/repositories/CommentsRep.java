package com.sudarshan.qaplatform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sudarshan.qaplatform.entities.Comments;

public interface CommentsRep extends JpaRepository<Comments, Integer>{

}
