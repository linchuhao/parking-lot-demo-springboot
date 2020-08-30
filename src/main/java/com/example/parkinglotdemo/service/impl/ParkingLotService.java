package com.example.parkinglotdemo.service.impl;

import com.example.parkinglotdemo.entity.ParkingLot;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ParkingLotService {

    List<ParkingLot> getParkingLots();

    List<ParkingLot>  getParkingLots(String name);

    void deleteParkingLot(int id);

    void addParkingLot(ParkingLot parkingLot);

    void updateParkingLot(int id, ParkingLot parkingLot);

    Page<ParkingLot> getParkingLotsByPage(Pageable pageable);
}
