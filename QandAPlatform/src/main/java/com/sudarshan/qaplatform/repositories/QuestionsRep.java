package com.sudarshan.qaplatform.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sudarshan.qaplatform.DAOs.QueryInDAO;
import com.sudarshan.qaplatform.DAOs.QueryOutDAO;
import com.sudarshan.qaplatform.entities.Questions;


public interface QuestionsRep extends JpaRepository<Questions, Integer>{
	
	@Query(value="select q.id questionID, q.text questionText, c.id companyID, c.name companyName from Questions q, Company c, questions_company_map qc " + 
			" where q.id = qc.questions_ID and qc.Company_ID = c.ID  and c.ID = :q_param", nativeQuery=true)
	List<QueryOutDAO> filterBy(@Param("q_param") Integer q_param);
}
