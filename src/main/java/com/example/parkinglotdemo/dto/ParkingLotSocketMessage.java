package com.example.parkinglotdemo.dto;

import java.util.List;

public class ParkingLotSocketMessage {
  private int type;
  List<ParkingLotSocketMessageDto> messageDtos;

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public List<ParkingLotSocketMessageDto> getMessageDtos() {
    return messageDtos;
  }

  public void setMessageDtos(List<ParkingLotSocketMessageDto> messageDtos) {
    this.messageDtos = messageDtos;
  }
}
