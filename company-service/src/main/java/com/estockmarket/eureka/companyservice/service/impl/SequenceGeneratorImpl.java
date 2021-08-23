package com.estockmarket.eureka.companyservice.service.impl;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.estockmarket.eureka.companyservice.model.DatabaseSequences;
import com.estockmarket.eureka.companyservice.service.SequenceGenerator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SequenceGeneratorImpl implements SequenceGenerator {

	@Autowired
	private MongoOperations mongoOperations;
	
	public long generateSequence(String seqName) {
		log.info("Sequence Generated");
	    DatabaseSequences counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
	      new Update().inc("seq",1), options().returnNew(true).upsert(true),
	      DatabaseSequences.class);
	    return !Objects.isNull(counter) ? counter.getSeq() : 1;
	}
}
