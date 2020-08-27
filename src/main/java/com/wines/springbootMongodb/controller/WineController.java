package com.wines.springbootMongodb.controller;

import com.wines.springbootMongodb.model.Wine;
import com.wines.springbootMongodb.repository.WineRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WineController {

  @Autowired
  private WineRepository wineRepository;

  @GetMapping("/allwines")
  public List<Wine> getAll() {
    return wineRepository.findAll();
  }

  //should be updated to work with wine name
  @GetMapping("/allwines/{id}")
  public Optional<Wine> getWine(@PathVariable String id) {
    return wineRepository.findById(id);
  }

  @PostMapping("/addwine")
  public void addWine(@RequestBody Wine wine) {
    wineRepository.save(wine);
  }

  @DeleteMapping("/delete/{id}")
  public void deleteWine(@PathVariable String id) {
    wineRepository.deleteById(id);
  }

  /*
  use mongodb query classes to create
  - method filter recommendations > n
  - method to see prices below < p
   */
}
