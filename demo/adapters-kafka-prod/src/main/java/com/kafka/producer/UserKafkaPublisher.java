package com.kafka.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import com.kafka.application.port.out.UsersPublisher;
import com.kafka.domain.User;

@Component
public class UserKafkaPublisher implements UsersPublisher {

  public static final String TOPIC = "user";

  private final KafkaTemplate<String, User> kafkaTemplate;

  public UserKafkaPublisher(KafkaTemplate<String, User> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  @Override
  public void createUserMessage(User user) {

    System.out.println("Publishing message: " + user);

    kafkaTemplate.send(TOPIC, user);
  }

}
