package com.example.parkinglotdemo.repository;


import com.example.parkinglotdemo.entity.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParingLotRepository extends JpaRepository<ParkingLot, Integer> {
    List<ParkingLot> findAllByNameLike(String name);
}
