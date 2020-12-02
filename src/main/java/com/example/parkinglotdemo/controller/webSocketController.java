package com.example.parkinglotdemo.controller;

import com.alibaba.fastjson.JSON;
import com.example.parkinglotdemo.websocket.WebSocketServer;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webSocketController")
public class webSocketController {

  @Resource
  WebSocketServer webSocketServer;

  @PostMapping
  public String sendMessage(@RequestParam String message) {
    webSocketServer.sendMessage(JSON.toJSONString(message));
    return "success";
  }
}
