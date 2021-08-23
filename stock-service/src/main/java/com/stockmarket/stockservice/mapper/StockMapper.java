package com.stockmarket.stockservice.mapper;

import org.mapstruct.Mapper;

import com.stockmarket.stockservice.model.Stock;
import com.stockmarket.stockservice.vo.StockVo;

@Mapper(
	    componentModel = "spring"
	)
public interface StockMapper {

	Stock mapStockVoToStock(StockVo stockVo);

}
