package com.wines.springbootMongodb.repository;

import com.wines.springbootMongodb.model.Wine;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WineRepository extends MongoRepository<Wine,String> {

  List<Wine> findByWineNameStartingWith(String wineMakerName);

  List<Wine> findByWineMakerName(String winemakerName);

  @Query(value ="{'price': {$lt : ?0}}}")
  List<Wine> winesLessThan(int price);

  List<Wine> findByOrderByAvReviewDesc();

  List<Wine> findByOrderByAvReviewAsc();
}
