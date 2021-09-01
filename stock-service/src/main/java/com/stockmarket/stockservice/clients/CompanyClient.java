package com.stockmarket.stockservice.clients;

import javax.validation.constraints.NotNull;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "${companyservice.name}")
public interface CompanyClient {

	@GetMapping("/api/v1.0/market/company/exists/{companyCode}")
	Boolean companyExist(@PathVariable("companyCode") @NotNull String companyCode);
	
}
