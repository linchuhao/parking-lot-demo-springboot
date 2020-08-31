package com.example.parkinglotdemo.controller;

import com.example.parkinglotdemo.entity.ParkingLot;
import com.example.parkinglotdemo.service.impl.ParkingLotService;
import javax.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parkingLots")
@CrossOrigin("*")
public class parkingLotController {

  @Resource
  ParkingLotService parkingLotService;

  @GetMapping
  public Page<ParkingLot> getParkingLotsByPage(Pageable pageable,
      @RequestParam(required = false) String name) {
    if (StringUtils.isEmpty(name)) {
      return parkingLotService.getParkingLotsByPage(pageable);
    }
    return parkingLotService.getParkingLotsByPage(pageable, name);
  }

  @DeleteMapping("/{id}")
  public void getParkingLots(@PathVariable int id) {
    parkingLotService.deleteParkingLot(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void addParkingLots(@RequestBody ParkingLot parkingLot) {
    parkingLotService.addParkingLot(parkingLot);
  }

  @PutMapping("/{id}")
  public void updateParkingLots(@PathVariable int id, @RequestBody ParkingLot parkingLot) {
    parkingLotService.updateParkingLot(id, parkingLot);
  }
}
