package com.mileidis.flowers.service.impl;

import com.mileidis.flowers.model.Flower;
import com.mileidis.flowers.model.FlowerDTO;
import com.mileidis.flowers.service.FlowerService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * @author Mileidis Ruiz
 */
@Service
public class DefaultFlowerService implements FlowerService {
  public static ArrayList<Flower> flowerList;

  private static final String KOMET = "-kometsales";

  @Override
  public ArrayList<Flower> createFlowers(ArrayList<Flower> flowers) {
    return DefaultFlowerService.flowerList = flowers;
  }

  @Override
  public ArrayList<FlowerDTO> getFlowers() {
    ArrayList<FlowerDTO> flowerDtoList = new ArrayList<>();
    DefaultFlowerService.flowerList.stream().sorted(Comparator.comparing(Flower::getName)).forEach(flower -> {
      flowerDtoList.add(new FlowerDTO(flower.getName() + KOMET, flower.getPrice()));
    });
    Collections.reverse(flowerDtoList);

    return flowerDtoList;
  }

  @Override
  public ArrayList<Flower> getFlowersByPrice(float price) {
    ArrayList<Flower> flowerList = new ArrayList<>();
    DefaultFlowerService.flowerList.stream().filter(flower -> flower.getPrice() > price).forEach(flower -> flowerList.add(flower));

    return flowerList;
  }

  @Override
  public ArrayList<Flower> getFlowersByName(String name) {
    ArrayList<Flower> flowerList = new ArrayList<>();
    DefaultFlowerService.flowerList.stream().filter(flower -> flower.getName().contains(name)).forEach(flower -> flowerList.add(flower));

    return flowerList;
  }

  @Override
  public Flower deleteFlowerById(String id) {
    Optional<Flower> flowerDeleted = DefaultFlowerService.flowerList.stream().filter(flower -> flower.getId().equals(id)).findFirst();
    DefaultFlowerService.flowerList.removeIf(flower -> flower.getId().equals(id));

    return flowerDeleted.get();
  }

}
