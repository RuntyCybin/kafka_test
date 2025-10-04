package com.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.kafka.domain.Message;

@Component
public class MessageKafkaConsumer {

  public static final String TOPIC = "message";

  @KafkaListener(topics = TOPIC, groupId = "message_group", containerFactory = "messageListenerFactory")
  public void onMessage(Message message) {
    System.out.println("Received message: " + message.getContent());
  }

}
