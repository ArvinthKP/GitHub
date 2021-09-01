package com.stockmarket.stockservice.service.impl;

import org.springframework.stereotype.Service;

import com.stockmarket.stockservice.clients.CompanyClient;
import com.stockmarket.stockservice.service.CompanyService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

	private final CompanyClient companyClient;

	@Override
	public boolean companyExist(String companyCode) {		
		return companyClient.companyExist(companyCode);
	}
	
	
}
