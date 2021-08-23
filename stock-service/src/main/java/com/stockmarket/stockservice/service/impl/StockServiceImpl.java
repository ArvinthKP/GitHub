package com.stockmarket.stockservice.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockmarket.stockservice.database.StockReposittory;
import com.stockmarket.stockservice.model.Stock;
import com.stockmarket.stockservice.service.StockService;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	private StockReposittory stockRepository;
	
	@Override
	public Stock saveStock(Stock stock) {		
		return stockRepository.save(stock);
	}

	@Override
	public List<Stock> listCompanyStockForTimePeriod(String companyCode, LocalDate startDate, LocalDate endDate) {	
		LocalDateTime startDateTime=startDate.atStartOfDay();
		LocalDateTime endDateTime=endDate.atTime(23,59);
		return stockRepository.findByCompanyCodeAndStartDateAndEndDate(companyCode,startDateTime,endDateTime);
	}

}
