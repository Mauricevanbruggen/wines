package com.wines.springbootMongodb.repository;

import com.wines.springbootMongodb.model.Wine;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WineRepository extends MongoRepository<Wine,String> {

   Optional<Wine> findByName(String wineName);
}
