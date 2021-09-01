package com.estockmarket.eureka.companyservice.service;


import java.util.List;

import javax.validation.constraints.NotNull;

import com.estockmarket.eureka.companyservice.model.Company;

public interface CompanyService {

	Company registerCompany(Company company);

	Company getCompany(@NotNull String companyCode);

	List<Company> getAllCompany();

	void deleteCompany(@NotNull String companyCode);

	Boolean companyExist(@NotNull String companyCode);

}
