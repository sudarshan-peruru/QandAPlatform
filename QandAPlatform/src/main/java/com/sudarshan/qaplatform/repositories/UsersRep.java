package com.sudarshan.qaplatform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sudarshan.qaplatform.entities.Users;

public interface UsersRep extends JpaRepository<Users, Integer>{
	
}
