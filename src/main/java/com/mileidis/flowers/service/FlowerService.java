package com.mileidis.flowers.service;

import com.mileidis.flowers.model.Flower;
import com.mileidis.flowers.model.FlowerDTO;
import java.util.ArrayList;

/**
 * @author Mileidis Ruiz
 */
public interface FlowerService {

  ArrayList<Flower> createFlowers(ArrayList<Flower> flowers);

  ArrayList<FlowerDTO> getFlowers();

  ArrayList<Flower> getFlowersByPrice(float price);

  ArrayList<Flower> getFlowersByName(String name);

  Flower deleteFlowerById(String id);

  ArrayList<Flower> updateFlowerById(Flower flower,String id);
}
