package com.estockmarket.eureka.companyservice.api;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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
import com.estockmarket.eureka.companyservice.service.StockService;
import com.estockmarket.eureka.companyservice.vo.ApiError;
import com.estockmarket.eureka.companyservice.vo.CompanyVo;
import com.estockmarket.eureka.companyservice.vo.RegisterCompanyVo;

@RestController
@RequestMapping("/api/v1.0/market/company")
@CrossOrigin("*")
public class CompanyController {
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	CompanyMapper companyMapper;
	
	@Autowired
	StockService stockService;
	
		
	@PostMapping("/register")
	public Company registerCompany(@Valid @RequestBody RegisterCompanyVo registerCompany) {
		Company company=companyMapper.mapRegisterCompanyVoToCompany(registerCompany);
		validateCompany(registerCompany);
		return companyService.registerCompany(company);
	}
	
	@GetMapping("/info/{companyCode}")
	public CompanyVo getCompany(@PathVariable("companyCode") @NotNull String companyCode) {
		CompanyVo companyVo=companyMapper.mapCompanyToCompanyVo(companyService.getCompany(companyCode));
		companyVo.setStockValue(stockService.getLatestStockPrice(companyCode));
		return companyVo;
	}
	
	@GetMapping("/getAll")
	public List<CompanyVo> getAllCompany() {
		List<CompanyVo> listCompanyVo=companyMapper.mapCompanyListToCompany(companyService.getAllCompany());
		listCompanyVo.forEach(data->{
			data.setStockValue(stockService.getLatestStockPrice(data.getCompanyCode()));
		});
		return listCompanyVo;
	}
	
	@DeleteMapping("/delete/{companyCode}")
	@Transactional
	public void deleteCompany(@PathVariable("companyCode") @NotNull String companyCode) {		
		 if(stockService.deleteStock(companyCode)==1) {
		 companyService.deleteCompany(companyCode);
		 }
	}
	
	@GetMapping("/exists/{companyCode}")
	public Boolean companyExist(@PathVariable("companyCode") @NotNull String companyCode) {		
		return companyService.companyExist(companyCode);
	}

	private void validateCompany(@Valid RegisterCompanyVo registerCompany) {
		if(registerCompany.getTurnOver()<ApplicationConstants.turnOver) {
			ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, "turn over is less than 10", null);
	        throw new RuntimeException("turn over is less than 10");
		}
	}

}
