package com.estockmarket.eureka.companyservice.api;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estockmarket.eureka.companyservice.constant.ApplicationConstants;
import com.estockmarket.eureka.companyservice.mapper.CompanyMapper;
import com.estockmarket.eureka.companyservice.model.Company;
import com.estockmarket.eureka.companyservice.service.CompanyService;
import com.estockmarket.eureka.companyservice.vo.RegisterCompanyVo;

@RestController
@RequestMapping("/api/v1.0/market/company")
@CrossOrigin("*")
public class CompanyController {
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	CompanyMapper companyMapper;
		
	@PostMapping("/register")
	public Company registerCompany(@Valid @RequestBody RegisterCompanyVo registerCompany) {
		Company company=companyMapper.mapRegisterCompanyVoToCompany(registerCompany);
		validateCompany(registerCompany);
		return companyService.registerCompany(company);
	}
	
	@GetMapping("/info/{companyCode}")
	public Company getCompany(@PathVariable("companyCode") @NotNull String companyCode) {		
		return companyService.getCompany(companyCode);
	}
	
	@GetMapping("/getAll")
	public List<Company> getAllCompany() {		
		return companyService.getAllCompany();
	}
	
	@DeleteMapping("/delete/{companyCode}")
	public void deleteCompany(@PathVariable("companyCode") @NotNull String companyCode) {
		 companyService.deleteCompany(companyCode);
	}

	private void validateCompany(@Valid RegisterCompanyVo registerCompany) {
		if(registerCompany.getTurnOver()<ApplicationConstants.turnOver) {
			return;
		}
	}

}
