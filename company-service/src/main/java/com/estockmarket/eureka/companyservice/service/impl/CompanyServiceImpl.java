package com.estockmarket.eureka.companyservice.service.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estockmarket.eureka.companyservice.database.CompanyRepository;
import com.estockmarket.eureka.companyservice.model.Company;
import com.estockmarket.eureka.companyservice.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	CompanyRepository companyRepository;

	@Override
	public Company registerCompany(Company company) {
		return companyRepository.save(company);
	}

	@Override
	public Company getCompany(@NotNull String companyCode) {
		Optional<Company> company=companyRepository.findById(companyCode);
		return company.isPresent()?company.get():null;
	}

	@Override
	public List<Company> getAllCompany() {		
		return companyRepository.findAll();
	}

	@Override
	@Transactional
	public void deleteCompany(@NotNull String companyCode) {		
		 companyRepository.deleteById(companyCode);
	}

	@Override
	public Boolean companyExist(@NotNull String companyCode) {
		Optional<Company> company=companyRepository.findById(companyCode);
		return company.isPresent()?Boolean.TRUE:Boolean.FALSE;
	}
	

}
