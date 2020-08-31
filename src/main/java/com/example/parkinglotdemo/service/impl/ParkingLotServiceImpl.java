package com.example.parkinglotdemo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.parkinglotdemo.dto.ParkingLotSocketMessage;
import com.example.parkinglotdemo.dto.ParkingLotSocketMessageDto;
import com.example.parkinglotdemo.entity.ParkingLot;
import com.example.parkinglotdemo.exception.ParkingLotNotFoundException;
import com.example.parkinglotdemo.repository.ParingLotRepository;
import com.example.parkinglotdemo.websocket.WebSocketServer;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {

  @Resource
  private ParingLotRepository paringLotRepository;


  @Resource
  private WebSocketServer webSocketServer;

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
    ParkingLot saveParkingLot = paringLotRepository.save(parkingLot);
    ParkingLotSocketMessageDto parkingLotSocketMessageDto = new ParkingLotSocketMessageDto();
    BeanUtils.copyProperties(saveParkingLot, parkingLotSocketMessageDto);
    webSocketServer.sendMessage(JSONObject.toJSONString(parkingLotSocketMessageDto));
  }

  @Override
  public void updateParkingLot(int id, ParkingLot parkingLot) {
    paringLotRepository.findById(id).orElseThrow(ParkingLotNotFoundException::new);
    parkingLot.setId(id);
    ParkingLot saveParkingLot = paringLotRepository.save(parkingLot);
    ParkingLotSocketMessageDto parkingLotSocketMessageDto = new ParkingLotSocketMessageDto();
    BeanUtils.copyProperties(saveParkingLot, parkingLotSocketMessageDto);
    webSocketServer.sendMessage(JSONObject.toJSONString(parkingLotSocketMessageDto));
  }

  @Override
  public Page<ParkingLot> getParkingLotsByPage(Pageable pageable) {
    Page<ParkingLot> parkingLots = paringLotRepository.findAll(pageable);
    String parkingSpaceResponseJson = JSON.toJSONString(parkingLots);
    webSocketServer.sendMessage(parkingSpaceResponseJson);
    return parkingLots;
  }

  @Override
  public ParkingLotSocketMessage getParkingLotMessageInOneHour() {
    List<ParkingLotSocketMessageDto> parkingLotSocketMessageDtos =
        paringLotRepository.findAll().stream()
            .map(
                item -> {
                  ParkingLotSocketMessageDto parkingLotSocketMessageDto =
                      new ParkingLotSocketMessageDto();
                  BeanUtils.copyProperties(item, parkingLotSocketMessageDto);
                  return parkingLotSocketMessageDto;
                })
            .collect(Collectors.toList());
    ParkingLotSocketMessage message = new ParkingLotSocketMessage();
    message.setMessageDtos(parkingLotSocketMessageDtos);
    return message;
  }
}
