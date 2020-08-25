package com.wines.springbootMongodb.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReviewTest {

  private Review review1, review2, review3;
  private String s = "user: John, rating: 10, approved: true";

  @BeforeEach
  void before() {
    review1 = new Review("John", 10, true);
    review2 = new Review("John", 10, true);
    review3 = new Review("Claus", 9, false);
  }

  @Test
  void equals() {
    assertEquals(review2, review1);
    assertNotEquals(review1, review3);
    assertNotEquals(null, review1);
  }

  @Test
  void toStringTest() {
    assertEquals(s, review1.toString());
    assertNotEquals("foo", review1.toString());
  }
}
