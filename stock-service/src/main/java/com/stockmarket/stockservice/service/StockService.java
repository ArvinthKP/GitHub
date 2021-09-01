package com.stockmarket.stockservice.service;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.stockmarket.stockservice.model.Stock;

public interface StockService {

	Stock saveStock(Stock stock);

	List<Stock> listCompanyStockForTimePeriod(String companyCode, LocalDate startDate, LocalDate endDate);

	int deleteCompany(@NotNull String companyCode);

	String getStockPrice(@NotNull String companyCode);

}
