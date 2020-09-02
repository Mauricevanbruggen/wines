package com.wines.springbootMongodb.controller;

import com.wines.springbootMongodb.com.service.WineService;
import com.wines.springbootMongodb.model.Wine;
import com.wines.springbootMongodb.repository.WineRepository;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WineController {

  @Autowired
  private WineRepository wineRepository;
  @Autowired
  private WineService wineService;

  @GetMapping("/allwines")
  public List<Wine> getAllWines() {
    return wineService.getAll();
  }

//  @GetMapping("/allwines")
//  public List<Wine> getAll() {
//    return wineRepository.findAll();
//  }

  //should be updated to work with wine name
  @GetMapping("/allwines/{id}")
  public Optional<Wine> getWine(@PathVariable String id) {
    return wineService.findWineById(id);
  }

  @PostMapping("/allwines")
  public Wine addWine(@RequestBody Wine wine) {
    return wineService.addWine(wine);
  }

  @GetMapping("/allwines/page")
  public Map<String, Object> getAllWinesInPage(@RequestParam(name = "pageNo", defaultValue = "0")
      int pageNo, @RequestParam(name = "pagesize", defaultValue = "2") int pageSize,
      @RequestParam(name = "sortby", defaultValue = "id") String sortBy) {
    return wineService.getAllWinesInPage(pageNo, pageSize, sortBy);
  }

//  @PostMapping("/addwine")
//  public void addWine(@RequestBody Wine wine) {
//    wineRepository.save(wine);
//  }
  @PutMapping("/allwines/{id}")
  public Wine updateWine(@RequestBody Wine wine) {
    return wineService.updateWine(wine);
  }

  @DeleteMapping("/allwines/{id}")
  public void deleteWine(@PathVariable String id) {
    wineService.delete(id);
  }

//  @DeleteMapping("/delete/{id}")
//  public void deleteWine(@PathVariable String id) {
//    wineRepository.deleteById(id);
//  }

  /*
  use mongodb query classes to create
  - method filter recommendations > n
  - method to see prices below < p
   */
}
