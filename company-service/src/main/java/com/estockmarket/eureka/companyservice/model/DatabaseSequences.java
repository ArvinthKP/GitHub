package com.estockmarket.eureka.companyservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "db_sequences")
@Data
public class DatabaseSequences {

    @Id
    private String id;

    private long seq;

}
