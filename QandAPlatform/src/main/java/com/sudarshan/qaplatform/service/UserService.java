package com.sudarshan.qaplatform.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudarshan.qaplatform.entities.Users;
import com.sudarshan.qaplatform.repositories.UsersRep;

@Service
public class UserService {
	
	@Autowired
	UsersRep usersRep;
	
	public Users createUser(Users users) {
		//This code is not working.
		//if(users.getName() == null || users.getName() == "") throw new EntityNotFoundException("QAPlatform : Invalid details given.");
		return usersRep.save(users);
	}
	
	public Users retriveUser(int id) {
		return usersRep.findById(id).orElseThrow(() -> new EntityNotFoundException("QAPlatform : User with ID: " + id + " does not exist."));
	}
	
	public List<Users> retriveAllUsers() {
		return usersRep.findAll();
	}
	
	public Users updateUser(Users users) {
		usersRep.findById(users.getId()).orElseThrow(() -> new EntityNotFoundException("QAPlatform : User with ID: " + users.getId() + " does not exist."));
		return usersRep.save(users);
	}
	
	public void deleteUser(int id) {
		usersRep.findById(id).orElseThrow(() -> new EntityNotFoundException("QAPlatform : User with ID: " + id + " does not exist."));
		usersRep.deleteById(id);
	}
	
	public void deleteAllUsers() {
		usersRep.deleteAll();
	}
}
