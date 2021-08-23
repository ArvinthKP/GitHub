package com.estockmarket.eureka.companyservice.vo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class RegisterCompanyVo {
	
	@NotEmpty
	private String companyCode;

	@NotEmpty
	private String companyName;

	@NotEmpty
	private String companyCEO;	

	@NotNull
	private Double turnOver;

	@NotEmpty
	private String companyWebsite;

	@NotEmpty
	private String stockExchange;

}
