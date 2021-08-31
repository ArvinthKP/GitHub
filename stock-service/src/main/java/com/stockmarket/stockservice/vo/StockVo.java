package com.stockmarket.stockservice.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel
public class StockVo {

	private String companyCode;
	private Double stockValue;
	
}
