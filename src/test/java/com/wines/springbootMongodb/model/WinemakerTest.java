package com.wines.springbootMongodb.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WinemakerTest {
  private Winemaker john, claus, theo;

  @BeforeEach
  void beforeEach() {
    john = new Winemaker("John", "Dutch", 23);
    theo = new Winemaker("John", "Dutch", 23);
    claus = new Winemaker("Claus", "Dutch", 23);
  }

  @Test
  void equals() {
    assertEquals(john, theo);
    assertNotEquals(theo, claus);
    assertNotEquals(null, john);
  }

  @Test
  void toStringTest() {
    assertEquals("(name: John, nationality: Dutch, age: 23)", john.toString());
    assertNotEquals("foo", theo.toString());
  }
}
