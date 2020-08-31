package com.example.parkinglotdemo.service.impl;

import com.example.parkinglotdemo.entity.ParkingLot;
import com.example.parkinglotdemo.exception.ParkingLotNotFoundException;
import com.example.parkinglotdemo.repository.ParingLotRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {

  @Resource
  private ParingLotRepository paringLotRepository;

  @Override
  public Page<ParkingLot> getParkingLotsByPage(Pageable pageable, String name) {
    return paringLotRepository.findAllByNameLike(pageable, "%" + name + "%");
  }

  @Override
  public void deleteParkingLot(int id) {
    paringLotRepository.findById(id).orElseThrow(ParkingLotNotFoundException::new);
    paringLotRepository.deleteById(id);
  }

  @Override
  public void addParkingLot(ParkingLot parkingLot) {
    paringLotRepository.save(parkingLot);
  }

  @Override
  public void updateParkingLot(int id, ParkingLot parkingLot) {
    paringLotRepository.findById(id).orElseThrow(ParkingLotNotFoundException::new);
    parkingLot.setId(id);
    paringLotRepository.save(parkingLot);
  }

  @Override
  public Page<ParkingLot> getParkingLotsByPage(Pageable pageable) {
    return paringLotRepository.findAll(pageable);
  }
}
