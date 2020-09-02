package com.wines.springbootMongodb.repository;

import com.wines.springbootMongodb.model.Wine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WineRepository extends MongoRepository<Wine,String> {
}
