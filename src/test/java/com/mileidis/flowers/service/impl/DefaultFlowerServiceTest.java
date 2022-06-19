package com.mileidis.flowers.service.impl;

import com.mileidis.flowers.model.Flower;
import com.mileidis.flowers.model.FlowerDTO;
import com.mileidis.flowers.service.FlowerService;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Mileidis Ruiz
 */
class DefaultFlowerServiceTest {

  ArrayList<Flower> flowers;
  FlowerService flowerService;

  @BeforeEach
  void setUp() {
    flowerService = new DefaultFlowerService();
    flowers = new ArrayList<>();
    flowers.add(new Flower("1","rosa",15.7f));
    flowers.add(new Flower("2","girasol",20.5f));
    flowers.add(new Flower("3","clavel",25.2f));
    flowers.add(new Flower("4","gardenia",30.3f));
    flowerService.createFlowers(flowers);
  }

  @Test
  void createFlowers() {
    Assertions.assertEquals(flowers.toString(), DefaultFlowerService.flowerList.toString());
  }

  @Test
  void getFlowers() {
    ArrayList<FlowerDTO> flowersResultExpected = new ArrayList<>();
    flowersResultExpected.add(new FlowerDTO("rosa-kometsales",15.7f));
    flowersResultExpected.add(new FlowerDTO("girasol-kometsales",20.5f));
    flowersResultExpected.add(new FlowerDTO("gardenia-kometsales",30.3f));
    flowersResultExpected.add(new FlowerDTO("clavel-kometsales",25.2f));
    ArrayList<FlowerDTO> flowerDtoList = flowerService.getFlowers();

    Assertions.assertEquals(flowerDtoList.toString(), flowersResultExpected.toString());
  }

  @Test
  void getFlowersByPrice() {
    ArrayList<Flower> flowersResultExpected = new ArrayList<>();
    flowersResultExpected.add(new Flower("3","clavel",25.2f));
    flowersResultExpected.add(new Flower("4","gardenia",30.3f));
    ArrayList<Flower> flowerList = flowerService.getFlowersByPrice(25f);

    Assertions.assertEquals(flowerList.toString(), flowersResultExpected.toString());
  }

  @Test
  void getFlowersByName() {
    ArrayList<Flower> flowersResultExpected = new ArrayList<>();
    flowersResultExpected.add(new Flower("3","clavel",25.2f));
    ArrayList<Flower> flowerList = flowerService.getFlowersByName("clavel");

    Assertions.assertEquals(flowerList.toString(), flowersResultExpected.toString());
  }

  @Test
  void deleteFlowerById() {
    Flower flowerExpected = new Flower("1","rosa",15.7f);
    Flower flower = flowerService.deleteFlowerById("1");

    Assertions.assertEquals(flower.toString(), flowerExpected.toString());
  }
}