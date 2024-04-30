package com.veladaano.programandoenjava.votacionveladaano2024.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends MongoRepository<VoteDocument, String> {}
