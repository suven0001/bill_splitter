package com.apt.billsplitter.configuration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = "com.apt.billsplitter.repository")
@Configuration
public class MongoConfig {

    @Value("{spring.data.mongodb.uri}")
    private String uri;

    @Value("${spring.data.mongodb.database}")
    private String database;

    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), database);
    }

    public MongoClient mongoClient() {
        return MongoClients.create(uri);
    }
}
