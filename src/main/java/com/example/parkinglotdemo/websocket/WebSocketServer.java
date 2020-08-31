package com.example.parkinglotdemo.websocket;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket")
@Component
public class WebSocketServer {

  private static final Map<String, Session> sessionMap = new ConcurrentHashMap<>();

  private String id;

  @OnOpen
  public void onOpen(Session session) {
    System.out.println("A new user add");
    this.id = UUID.randomUUID().toString();
    sessionMap.put(id, session);
  }

  @OnClose
  public void onClose() {
    if (sessionMap.containsKey(id)) {
      sessionMap.remove(id);
      System.out.println(id + " logout");
    }
  }

  @OnMessage
  public void onMessage(String message, Session session) {
    System.out.println(message);
  }

  @OnError
  public void onError(Session session, Throwable throwable) {
    sessionMap.remove(id);
    System.out.println(throwable.getMessage());
  }

  public void sendMessage(String message) {
    for (Map.Entry<String, Session> entry : sessionMap.entrySet()) {
      try {
        entry.getValue().getBasicRemote().sendText(message);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
