package com.estockmarket.eureka.companyservice.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.ToString;


@Data
@Document(collection = "company")
@ToString
public class Company {
	
//	@Transient
//    public static final String SEQUENCE_NAME = "company_sequence";

	
//	private Long id;
	@Id
	private String companyCode;
	
	private String companyName;
	
	private String companyCEO;
	
	private Double turnOver;
	
	private String companyWebsite;
	
	private String stockExchange;
	
	private LocalDateTime createdDate;
	
	private LocalDateTime lastUpdatedDate;
	
}
