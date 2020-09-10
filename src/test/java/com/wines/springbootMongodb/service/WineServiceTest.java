package com.wines.springbootMongodb.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import com.wines.springbootMongodb.com.service.WineService;
import com.wines.springbootMongodb.model.Wine;
import com.wines.springbootMongodb.repository.WineRepository;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class WineServiceTest {

  @Autowired
  private WineService wineService;

  @MockBean
  private WineRepository wineRepository;

  private Wine wine1, wine2;

  @Test
  @DisplayName("test find all wines")
  public void testGetAllWines() {
    Wine wine1 = new Wine();
    Wine wine2 = new Wine();

    doReturn(Arrays.asList(wine1, wine2)).when(wineRepository).findAll();
    List<Wine> allWines = wineService.getAllWines();
    assertEquals(2, allWines.size());
  }

//  @Test
//  @DisplayName("test find wine by name")
//  public void testGetWineByName() {
//    Wine wine1 = new Wine();
//    wine1.setName("test wine 1");
//    wine1.setId("1");
//    wine1.setPrice(1);
//
//    doReturn(Arrays.asList(wine1)).when(wineRepository).findbyNameInWineList("test wine 1");
//
//    List<Wine> resultWine = wineService.findWineByName("test wine 1");
//
//    assertEquals("test wine 1" ,resultWine.get(0).getName());
//  }

  @Test
  @DisplayName("test a find wine by id ")
  public void testFindWineById() {
    Wine wine1 = new Wine();
    wine1.setId("1");
    wine1.setName("test wine 1");
    doReturn(Optional.of(wine1)).when(wineRepository).findById("1");

    Optional<Wine> returnedWine = wineService.findWineById("1");

    assertTrue(returnedWine.isPresent(), "Wine not found");
    assertSame(returnedWine.get(), wine1, "returned wine was not the same as the mock");
  }


  @Test
  @DisplayName("test add a wine")
  public void testAddWine() {
    Wine wine1 = new Wine();
    wine1.setName("test wine 1");
    wine1.setPrice(1);
    when(wineRepository.insert(any(Wine.class))).thenReturn(new Wine());

    Wine resultWine = wineService.addWine(wine1);
    resultWine.setPrice(1);

    assertNotNull(resultWine, "Wine not found");
    assertEquals(1, resultWine.getPrice(), "the price is not equal to 1");
  }

  @Test
  @DisplayName("test update a wine")
  public void testUpdateWine() {
    Wine wine1 = new Wine();
    wine1.setName("test wine 1");
    wine1.setPrice(1);

    //add wine
    when(wineRepository.insert(any(Wine.class))).thenReturn(new Wine());
    Wine resultWine = wineService.addWine(wine1);
    resultWine.setPrice(1);

    assertEquals(1, resultWine.getPrice(), "the price is not equal to 1");

    //update
    wine1.setPrice(2);
    when(wineRepository.save(any(Wine.class))).thenReturn(new Wine());
    resultWine = wineService.updateWine(wine1);
    resultWine.setPrice(2);

    assertEquals(2, resultWine.getPrice(), "the price is not equal to 2");
  }

  @Test
  public void testDeleteWine() {
    Wine wine1 = new Wine();
    Wine wine2 = new Wine();

    doReturn(Arrays.asList(wine1, wine2)).when(wineRepository).findAll();
    List<Wine> allWines = wineService.getAllWines();

    assertEquals(2, allWines.size());

    doReturn(Arrays.asList(wine2)).when(wineRepository).findAll();
    wineService.delete("1");
    allWines = wineService.getAllWines();

    assertEquals(1, allWines.size());
  }
}
