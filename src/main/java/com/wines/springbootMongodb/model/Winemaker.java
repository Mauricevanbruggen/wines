package com.wines.springbootMongodb.model;

public class Winemaker {

  private String name;
  private String nationality;
  private int age;

  public Winemaker() {

  }

  public Winemaker(String name, String nationality, int age) {
    this.name = name;
    this.nationality = nationality;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public String getNationality() {
    return nationality;
  }

  public int getAge() {
    return age;
  }

  @Override
  public String toString() {
    return "(name: " + name +
        ", nationality: " + nationality +
        ", age: " + age +")";
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof Winemaker) {
      Winemaker that = (Winemaker) other;
      return name.equals(that.name) &&
          nationality.equals(that.nationality) &&
          age == that.age;
    }
    return false;
  }
}
