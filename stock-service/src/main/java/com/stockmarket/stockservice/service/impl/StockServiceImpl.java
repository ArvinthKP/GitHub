package com.stockmarket.stockservice.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockmarket.stockservice.clients.CompanyClient;
import com.stockmarket.stockservice.database.StockReposittory;
import com.stockmarket.stockservice.model.Stock;
import com.stockmarket.stockservice.service.CompanyService;
import com.stockmarket.stockservice.service.StockService;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	private StockReposittory stockRepository;
	
	@Autowired
	CompanyService companyService;
	
	@Override
	public Stock saveStock(Stock stock) {
		if(companyService.companyExist(stock.getCompanyCode())) {
		return stockRepository.save(stock);
		}
		return null;
	}

	@Override
	public List<Stock> listCompanyStockForTimePeriod(String companyCode, LocalDate startDate, LocalDate endDate) {	
		LocalDateTime startDateTime=startDate.atStartOfDay();
		LocalDateTime endDateTime=endDate.atTime(23,59);
		return stockRepository.findByCompanyCodeAndStartDateAndEndDate(companyCode,startDateTime,endDateTime);
	}

	@Override
	public int deleteCompany(@NotNull String companyCode) {
		stockRepository.deleteByCompanyCode(companyCode);
		return 1;
	}

	@Override
	public String getStockPrice(@NotNull String companyCode) {
		Optional<List<Stock>> listStockPrice = stockRepository.findByCompanyCodeOrderByIdDesc(companyCode);
		return listStockPrice.isPresent()?listStockPrice.get().get(0).getStockValue():"";
	}

}
