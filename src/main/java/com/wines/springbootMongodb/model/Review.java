package com.wines.springbootMongodb.model;

public class Review {

  private String user;
  private int rating;
  private boolean approved;

  public Review() {

  }

  public Review(String user, int rating, boolean approved) {
    this.user = user;
    this.rating = rating;
    this.approved = approved;
  }

  public String getUser() {
    return user;
  }

  public int getRating() {
    return rating;
  }

  public boolean isApproved() {
    return approved;
  }

  @Override
  public String toString() {
    return "user: " + user +
        ", rating: " + rating +
        ", approved: " + approved;
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof Review) {
      Review that = (Review) other;
      return user.equals(that.user) && rating == that.rating
          && approved == that.approved;
    }
    return false;
  }
}
