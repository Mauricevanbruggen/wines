package com.wines.springbootMongodb.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WineTest {
  private Wine wine1, wine2, wine3;

  @BeforeEach
  void beforeEach() {

    wine1 = new Wine("pol roger", 2012, 40,
        new Winemaker(
            "John",
            "Dutch",
            23),
    Arrays.asList(
        new Review("John", 8, true),
        new Review("Theo", 5, false),
        new Review("Claus", 7, true)
    ));

    wine2 = new Wine("pol roger", 2012, 40,
        new Winemaker(
            "John",
            "Dutch",
            23),
        Arrays.asList(
            new Review("John", 8, true),
            new Review("Theo", 5, false),
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
