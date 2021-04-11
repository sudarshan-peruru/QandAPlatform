package com.sudarshan.qaplatform.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudarshan.qaplatform.entities.Company;
import com.sudarshan.qaplatform.exceptions.EntityNotFoundException;
import com.sudarshan.qaplatform.repositories.CompanyRep;

@Service
public class CompanyService {
	
	@Autowired
	CompanyRep companyRep;
	public Company createCompany(Company company) {
		return companyRep.save(company);
	}
	
	public Optional<Company> retriveCompany(int id) throws EntityNotFoundException {
		//System.out.println("hello");
		if(!companyRep.existsById(id)) {
			throw new EntityNotFoundException("QAPlatform : Company with id: " + id + ", not found.");
		}
		return companyRep.findById(id);
	}
	
	public List<Company> retriveAllCompany() {
		return companyRep.findAll();
	}
	
	public Company updateCompany(Company company) throws EntityNotFoundException {
		if(!companyRep.existsById(company.getId())) {
			throw new EntityNotFoundException("QAPlatform : Company with id: " + company.getId() + ", not found.");
		}
		return companyRep.save(company);
	}
	
	public void deleteCompany(int id) throws EntityNotFoundException  {
		if(!companyRep.existsById(id)) {
			throw new EntityNotFoundException("QAPlatform : Company with id: " + id + ", not found.");
		}
		companyRep.deleteById(id);
	}
	
	public void deleteAllCompany() {
		companyRep.deleteAll();
	}
}
