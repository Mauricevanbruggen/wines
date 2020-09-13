package com.wines.springbootMongodb.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class WineTest {
  private Wine wine1, wine2, wine3, wine4;

  @BeforeEach
  void beforeEach() {

    wine1 = new Wine("pol roger", 2012, 40,
        new Winemaker(
            "John",
            "Dutch",
            23),
    Arrays.asList(
        new Review("John", 8, true),
        new Review("Theo", 6, false),
        new Review("Claus", 7, true)
    ));

    wine2 = new Wine("pol roger", 2012, 40,
        new Winemaker(
            "John",
            "Dutch",
            23),
        Arrays.asList(
            new Review("John", 8, true),
            new Review("Theo", 6, false),
            new Review("Claus", 7, true)
        ));

    wine3 = new Wine("moet", 2019, 27,
        new Winemaker(
            "John",
            "Dutch",
            23),
        Arrays.asList(
            new Review("John", 8, true)

        ));

    wine4 = new Wine("apostelhoeve", 2020, 5,
        new Winemaker(
            "Henk",
            "Dutch",
            45),
            Arrays.asList(
                new Review()
        ));
  }

  @Test
  void testWineAttributes() {
    assertEquals("pol roger", wine1.getName());
    assertEquals(23, wine1.getWineMaker().getAge());
    assertEquals(7, wine1.getAvReview());
  }

  @Test
  void calculateAverageReview() {
    assertEquals(7, wine2.createAverageReview());
    assertEquals(0, wine4.createAverageReview());
  }

  @Test
  void equals() {
    assertEquals(wine1, wine1);
    assertEquals(wine1, wine2);
    assertNotEquals(wine1, wine3);
    assertNotEquals(wine1, null);
  }

  @Test
  void testChangeWinemaker() {
    Winemaker henk = new Winemaker("Henk", "Belgian", 20);
    wine1.setWineMaker(henk);
    assertEquals("Henk", wine1.getWineMaker().getName());
    assertNotEquals("John", wine1.getWineMaker().getName());
  }

  @Test
  void testToString() {
    assertTrue(wine2.toString().equals(wine1.toString()));
  }

}
