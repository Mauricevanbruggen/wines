package com.wines.springbootMongodb.model;

import java.util.ArrayList;
import java.util.List;

public class Wine {

  private int id;
  private String name;
  private int year;
  private Winemaker wineMaker;
  private List<Review> reviews;

  public Wine() {
    reviews = new ArrayList<>();
  }

  public Wine(int id, String name, int year, Winemaker wineMaker,
      List<Review> reviews) {
    this.id = id;
    this.name = name;
    this.year = year;
    this.wineMaker = wineMaker;
    this.reviews = reviews;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getYear() {
    return year;
  }

  public Winemaker getWineMaker() {
    return wineMaker;
  }

  public void setWineMaker(Winemaker wineMaker) {
    this.wineMaker = wineMaker;
  }

  public List<Review> getReviews() {
    return reviews;
  }

  @Override
  public String toString() {
    return "id: " + id + ", namelkhads: " + name + ", year: " + year + "," +
             '\n' + "winemaker: " + wineMaker.toString() + "," +
              '\n' + "reviews: " + reviews;
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof Wine) {
      Wine that = (Wine) other;
      return id == that.id && name.equals(that.name) &&
          year == that.year &&
          wineMaker.equals(that.wineMaker) &&
          reviews.equals(that.reviews);
    }
    return false;
  }
}
