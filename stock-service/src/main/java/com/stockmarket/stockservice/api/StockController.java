package com.stockmarket.stockservice.api;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockmarket.stockservice.mapper.StockMapper;
import com.stockmarket.stockservice.model.Stock;
import com.stockmarket.stockservice.service.StockService;
import com.stockmarket.stockservice.vo.StockVo;

@RestController
@RequestMapping("/api/v1.0/market/stock")
public class StockController {

	@Autowired
	private StockService stockService;

	@Autowired
	private StockMapper stockMapper;

	@PostMapping("/add")
	public Stock postStock(@RequestBody StockVo stockVo) {
		Stock stock = stockMapper.mapStockVoToStock(stockVo);
		return stockService.saveStock(stock);
	}

	@GetMapping("/get/{companyCode}/{startDate}/{endDate}")
	public List<Stock> getListofCompanyStock(@PathVariable("companyCode") String companyCode,
			@PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate) {		
		LocalDate stDate = LocalDate.parse(startDate);
		LocalDate edDate = LocalDate.parse(endDate);
		return stockService.listCompanyStockForTimePeriod(companyCode,stDate,edDate);
	}
}
