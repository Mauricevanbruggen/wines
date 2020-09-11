package com.wines.springbootMongodb.com.service;

import com.wines.springbootMongodb.model.Wine;
import com.wines.springbootMongodb.repository.WineRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class WineService {
  
  @Autowired
  WineRepository wineRepository;

  public List<Wine> getAllWines() {
    return wineRepository.findAll();
  }

  public Optional<Wine> findWineById(String id) {
    return wineRepository.findById(id);
  }

  public List<Wine> getAllByWineName(String winename) {
    return wineRepository.findByWineNameStartingWith(winename);
  }

  public List<Wine> getAllByWinemakerName(String wineMakerName) {
    return wineRepository.findByWineMakerName(wineMakerName);
  }

  public List<Wine> getAllByPriceLessThan(int price) {
    return wineRepository.winesLessThan(price);
  }

  public List<Wine> getAllByRatingDsc() {
    return wineRepository.findByOrderByAvReviewDesc();
  }

  public List<Wine> getAllByRatingAsc() {
    return wineRepository.findByOrderByAvReviewAsc();
  }

  public Wine addWine(Wine wine) {
    return wineRepository.insert(wine);
  }

  public Wine updateWine(Wine wine) {
    return wineRepository.save(wine);
  }

  public void delete(String id) {
    wineRepository.deleteById(id);
  }
}
