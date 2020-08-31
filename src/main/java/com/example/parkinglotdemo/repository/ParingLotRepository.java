package com.example.parkinglotdemo.repository;


import com.example.parkinglotdemo.entity.ParkingLot;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParingLotRepository extends JpaRepository<ParkingLot, Integer> {

  Page<ParkingLot> findAllByNameLike(Pageable pageable, String name);
}
