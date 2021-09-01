package com.estockmarket.eureka.companyservice.vo;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CompanyVo {
	
	private String companyCode;
	
	private String companyName;
	
	private String companyCEO;
	
	private Double turnOver;
	
	private String companyWebsite;
	
	private String stockExchange;
	
	private LocalDateTime createdDate;
	
	private LocalDateTime lastUpdatedDate;
	
	private String stockValue;
	
}
