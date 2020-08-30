package com.example.parkinglotdemo.controller;

import com.example.parkinglotdemo.entity.ParkingLot;
import com.example.parkinglotdemo.service.impl.ParkingLotService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/parkingLots")
@CrossOrigin("*")
public class parkingLotController {

    @Resource
    ParkingLotService parkingLotService;

    @GetMapping
    public List<ParkingLot> getParkingLots() {
        return parkingLotService.getParkingLots();
    }

    @GetMapping("/{name}")
    public List<ParkingLot> getParkingLots(@PathVariable String name) {
        return parkingLotService.getParkingLots(name);
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