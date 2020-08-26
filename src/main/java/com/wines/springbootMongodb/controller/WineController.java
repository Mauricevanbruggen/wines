package com.wines.springbootMongodb.controller;

import com.wines.springbootMongodb.model.Wine;
import com.wines.springbootMongodb.repository.WineRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

  @PostMapping("/addwine")
  public void addWine(@RequestBody Wine wine, @PathVariable String id) {
    wineRepository.save(wine);
  }


}
