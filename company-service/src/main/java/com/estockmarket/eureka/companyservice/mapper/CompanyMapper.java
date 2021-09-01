package com.estockmarket.eureka.companyservice.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.estockmarket.eureka.companyservice.model.Company;
import com.estockmarket.eureka.companyservice.vo.CompanyVo;
import com.estockmarket.eureka.companyservice.vo.RegisterCompanyVo;

@Mapper(
	    componentModel = "spring"
	)
public interface CompanyMapper {

	Company mapRegisterCompanyVoToCompany(RegisterCompanyVo registerCompany);

	CompanyVo mapCompanyToCompanyVo(Company company);

	List<CompanyVo> mapCompanyListToCompany(List<Company> allCompany);

}
