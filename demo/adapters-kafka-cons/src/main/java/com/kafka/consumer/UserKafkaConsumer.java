package com.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.kafka.domain.User;

@Component
public class UserKafkaConsumer {

  public static final String TOPIC = "user";

  @KafkaListener(topics = TOPIC, groupId = "user_group", containerFactory = "userListenerFactory")
  public void onMessage(User user) {
    System.out.println("Received user: " + user.getName() + ", " + user.getEmail());
  }

}
