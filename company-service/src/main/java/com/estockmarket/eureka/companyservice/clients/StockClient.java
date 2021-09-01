package com.estockmarket.eureka.companyservice.clients;

import javax.validation.constraints.NotNull;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "${stockservice.name}")
public interface StockClient {
	
	@DeleteMapping("/api/v1.0/market/stock/delete/{companyCode}")
	int deleteStock(@PathVariable("companyCode") @NotNull String companyCode);

	@GetMapping("/api/v1.0/market/stock/getStockPrice/{companyCode}")
	String getCompanyStockPrice(@PathVariable("companyCode") @NotNull String companyCode);
}
