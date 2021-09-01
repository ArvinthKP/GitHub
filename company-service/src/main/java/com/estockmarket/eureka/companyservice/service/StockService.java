package com.estockmarket.eureka.companyservice.service;

import javax.validation.constraints.NotNull;

public interface StockService {

	int deleteStock(@NotNull String companyCode);
	
	String getLatestStockPrice(@NotNull String companyCode);

}
