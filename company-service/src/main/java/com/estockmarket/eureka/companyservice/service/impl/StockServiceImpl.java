package com.estockmarket.eureka.companyservice.service.impl;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

import com.estockmarket.eureka.companyservice.clients.StockClient;
import com.estockmarket.eureka.companyservice.service.StockService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {

	private final StockClient stockClient;

	@Override
	public int deleteStock(@NotNull String companyCode) {		
		return stockClient.deleteStock(companyCode);
	}

	@Override
	public String getLatestStockPrice(@NotNull String companyCode) {		
		return stockClient.getCompanyStockPrice(companyCode);
	}
	
	
}
