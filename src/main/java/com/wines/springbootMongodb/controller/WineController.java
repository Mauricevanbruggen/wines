package com.wines.springbootMongodb.controller;

import com.wines.springbootMongodb.com.service.WineService;
import com.wines.springbootMongodb.model.Wine;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/allwines")
public class WineController {

  @Autowired
  private WineService wineService;

  @GetMapping("/")
  public List<Wine> getAllWines() {
    return wineService.getAllWines();
  }

  @GetMapping("/id/{id}")
  public Optional<Wine> getWineById(@PathVariable String id) {
    return wineService.findWineById(id);
  }

  @GetMapping("/winename")
  public List<Wine> getAllByName(@RequestParam(required = false, name = "winename") String wineName) {
    return wineService.getAllByWineName(wineName);
  }

  @GetMapping("/winemakername")
  public List<Wine> getAllByWinemakerName(
      @RequestParam(name = "winemakername") String wineMakerName) {
    return wineService.getAllByWinemakerName(wineMakerName);
  }

  @GetMapping("/price")
  public List<Wine> getAllByPrice(@RequestParam(name = "price") int price) {
    return wineService.getAllByPriceLessThan(price);
  }

  @PostMapping("/allwines")
  public Wine addWine(@RequestBody Wine wine) {
    return wineService.addWine(wine);
  }

  @PutMapping("/allwines")// note: use a json file with id or else a new wine is inserted
  public Wine updateWine(@RequestBody Wine wine) {
    return wineService.updateWine(wine);
  }

  @DeleteMapping("/{id}")
  public void deleteWine(@PathVariable("id") String id) {
    wineService.delete(id);
  }

  @GetMapping("/sortdesc")
  public List<Wine> getAllByReviewDsc() {
    return wineService.getAllByRatingDsc();
  }

  @GetMapping("/sortasc")
  public List<Wine> getAllByReviewAsc() {
    return wineService.getAllByRatingAsc();
  }
}
