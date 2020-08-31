package com.example.parkinglotdemo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.parkinglotdemo.websocket.WebSocketServer;
import javax.annotation.Resource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class WebSocketSenderService {

  @Resource
  WebSocketServer webSocketServer;

  @Resource
  ParkingLotService parkingLotService;

  @Scheduled(cron = "0 0 0/1 * * ?")
  public void hourlyTimer() {
    webSocketServer.sendMessage(
        JSONObject.toJSONString(parkingLotService.getParkingLotMessageInOneHour()));
  }
}
