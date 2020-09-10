package com.wines.springbootMongodb.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.OptionalDouble;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "Wines")
public class Wine {

  @Id
  private String id;
  private String wineName;
  private int year;
  private int price;
  private Winemaker wineMaker;
  private List<Review> reviews;
  public int avReview;

  public Wine() {
    reviews = new ArrayList<>();
  }

  public Wine(String name, int year, int price, Winemaker wineMaker,
      List<Review> reviews) {
    this.wineName = name;
    this.year = year;
    this.price = price;
    this.wineMaker = wineMaker;
    this.reviews = reviews;
    this.avReview = createAverageReview();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return wineName;
  }

  public void setName(String name) {
    this.wineName = name;
  }

  public int getYear() {
    return year;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
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

  public int getAvReview() {
    return avReview;
  }

  public int createAverageReview() {
    OptionalDouble averageReview = reviews.stream()
        .mapToInt(x -> x.getRating())
        .average();

    return averageReview.isPresent() ? ((int) averageReview.getAsDouble()) : 0;
  }

  @Override
  public String toString() {
    return ", Wine name: " + wineName + ", year: " + year + "," +
             '\n' + "winemaker: " + wineMaker.toString() + "," +
              '\n' + "reviews: " + reviews;
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof Wine) {
      Wine that = (Wine) other;
      return wineName.equals(that.wineName) &&
          year == that.year && price == that.price &&
          wineMaker.equals(that.wineMaker) &&
          reviews.equals(that.reviews);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, wineName, year, price, wineMaker, reviews);
  }
}
