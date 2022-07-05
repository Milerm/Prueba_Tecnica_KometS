package com.mileidis.flowers.controllers;

import com.mileidis.flowers.model.Flower;
import com.mileidis.flowers.model.FlowerDTO;
import com.mileidis.flowers.service.FlowerService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

  @PutMapping("/{id}")
  public ResponseEntity <ArrayList<Flower>> updateFlowerById(@RequestBody Flower flower,@PathVariable String id) {
    return new ResponseEntity<>(flowerService.updateFlowerById(flower, id), HttpStatus.OK);
  }

}
