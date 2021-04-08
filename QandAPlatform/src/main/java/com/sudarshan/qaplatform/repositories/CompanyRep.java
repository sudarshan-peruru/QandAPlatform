package com.sudarshan.qaplatform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sudarshan.qaplatform.entities.Company;

public interface CompanyRep extends JpaRepository<Company, Integer>{

}
