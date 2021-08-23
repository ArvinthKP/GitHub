package com.estockmarket.eureka.companyservice.database;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.estockmarket.eureka.companyservice.model.Company;

public interface CompanyRepository extends MongoRepository<Company, String> {

}
