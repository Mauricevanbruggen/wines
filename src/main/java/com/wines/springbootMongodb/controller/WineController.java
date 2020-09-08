package com.wines.springbootMongodb.controller;

import com.wines.springbootMongodb.com.service.WineService;
import com.wines.springbootMongodb.model.Wine;
import com.wines.springbootMongodb.repository.WineRepository;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/allwines")
public class WineController {

  @Autowired
  private WineRepository wineRepository;
  @Autowired
  private WineService wineService;

  @GetMapping("/")
  public List<Wine> getAllWines() {
    return wineService.getAllWines();
  }

  @GetMapping("/{id}")
  public Optional<Wine> getWineById(@PathVariable String id) {
    return wineService.findWineById(id);
  }

  @GetMapping("/winename") // still returns a 404
  public Optional<Wine> getWineByName(@RequestParam(name = "winename") String name) {
    return wineService.findWineByName(name);
  }

  @PostMapping("/")
  public Wine addWine(@RequestBody Wine wine) {
    return wineService.addWine(wine);
  }

  @PutMapping("/{id}") // does add a new wine instead of updating
  public Wine updateWine(@RequestBody Wine wine) {
    return wineService.updateWine(wine);
  }

  @DeleteMapping("/{id}")
  public void deleteWine(@PathVariable String id) {
    wineService.delete(id);
  }

  @GetMapping("/page") // doesn't return anything
  public Map<String, Object> getAllWinesInPage(@RequestParam(name = "pageNo", defaultValue = "0")
      int pageNo, @RequestParam(name = "pagesize", defaultValue = "2") int pageSize,
      @RequestParam(name = "sortby", defaultValue = "id") String sortBy) {
    return wineService.getAllWinesInPage(pageNo, pageSize, sortBy);
  }
}
