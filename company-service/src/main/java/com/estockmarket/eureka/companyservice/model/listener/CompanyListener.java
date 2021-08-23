package com.estockmarket.eureka.companyservice.model.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.estockmarket.eureka.companyservice.model.Company;
import com.estockmarket.eureka.companyservice.service.SequenceGenerator;

@Component
public class CompanyListener extends AbstractMongoEventListener<Company> {

	@Autowired
	SequenceGenerator sequenceGenerator;

	@Override
	public void onBeforeConvert(BeforeConvertEvent<Company> event) {
//		if (event.getSource().getId() == null || event.getSource().getId() < 1) {
//			event.getSource().setId(sequenceGenerator.generateSequence(Company.SEQUENCE_NAME));
//		}
	}

}
