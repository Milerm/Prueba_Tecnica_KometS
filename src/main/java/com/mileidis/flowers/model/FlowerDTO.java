package com.mileidis.flowers.model;

/**
 * @author Mileidis Ruiz
 */
public class FlowerDTO {
  private String name;
  private float price;

  public FlowerDTO(String name, float price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "FlowerDTO{" +
        "name='" + name + '\'' +
        ", price=" + price +
        '}';
  }
}
