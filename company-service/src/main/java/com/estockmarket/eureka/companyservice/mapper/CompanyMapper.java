package com.estockmarket.eureka.companyservice.mapper;

import org.mapstruct.Mapper;

import com.estockmarket.eureka.companyservice.model.Company;
import com.estockmarket.eureka.companyservice.vo.RegisterCompanyVo;

@Mapper(
	    componentModel = "spring"
	)
public interface CompanyMapper {

	Company mapRegisterCompanyVoToCompany(RegisterCompanyVo registerCompany);

}
