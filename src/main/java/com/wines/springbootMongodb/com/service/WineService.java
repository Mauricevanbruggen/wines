package com.wines.springbootMongodb.com.service;

import com.wines.springbootMongodb.model.Wine;
import com.wines.springbootMongodb.repository.WineRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class WineService {
  
  @Autowired
  WineRepository wineRepository;
  
  public List<Wine> getAll() {
    return wineRepository.findAll();
  }

  public Wine addWine(Wine wine) {
    return wineRepository.insert(wine);
  }

  public Optional<Wine> findWineById(String id) {
    return wineRepository.findById(id);
  }

  public Wine updateWine(Wine wine) {
    return wineRepository.save(wine);
  }

  public void delete(String id) {
    wineRepository.deleteById(id);
  }


  public Map<String, Object> getAllWinesInPage(int pageNo, int pageSize, String sortBy) {
    Map<String, Object> response = new HashMap<>();

    Sort sort = Sort.by(sortBy);
    Pageable page = PageRequest.of(pageNo, pageSize, sort);
    Page<Wine> winePage = wineRepository.findAll(page);
    response.put("data", winePage.getContent());
    response.put("Total number of page", winePage.getTotalPages());
    response.put("Total number of Elements", winePage.getNumberOfElements());
    response.put("data", winePage.getNumber());

    return response;

  }
}
