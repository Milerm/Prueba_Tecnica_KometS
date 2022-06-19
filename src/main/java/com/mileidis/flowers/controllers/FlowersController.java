package com.mileidis.flowers.controllers;

import com.mileidis.flowers.model.Flower;
import com.mileidis.flowers.model.FlowerDTO;
import com.mileidis.flowers.service.FlowerService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mileidis Ruiz
 */
@RestController
@RequestMapping("/flowers")
public class FlowersController {

  @Autowired
  FlowerService flowerService;

  @GetMapping("/")
  public ResponseEntity<ArrayList<FlowerDTO>> getFlowers() {
    return new ResponseEntity<>(flowerService.getFlowers(), HttpStatus.OK);
  }

  @PostMapping("/")
  public ResponseEntity<ArrayList<Flower>> createFlower(@RequestBody ArrayList<Flower> flowers) {
    return new ResponseEntity<>(flowerService.createFlowers(flowers), HttpStatus.OK);
  }

  @GetMapping("/price/{price}")
  public ResponseEntity<ArrayList<Flower>> getFlowersByPrice(@PathVariable float price) {
    return new ResponseEntity<>(flowerService.getFlowersByPrice(price), HttpStatus.OK);
  }

  @GetMapping("/name/{name}")
  public ResponseEntity<ArrayList<Flower>> getFlowersByName(@PathVariable String name) {
    return new ResponseEntity<>(flowerService.getFlowersByName(name), HttpStatus.OK);
  }

  @DeleteMapping ("/{id}")
  public ResponseEntity<Flower> deleteFlowerById(@PathVariable String id) {
    return new ResponseEntity<>(flowerService.deleteFlowerById(id), HttpStatus.OK);
  }

}
