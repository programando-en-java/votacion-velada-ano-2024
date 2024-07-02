package com.veladaano.programandoenjava.votacionveladaano2024.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.veladaano.programandoenjava.votacionveladaano2024.repositories")
public class MongoConfig {}
