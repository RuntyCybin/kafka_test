package com.kafka.producer;

import com.kafka.domain.Message;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import com.kafka.application.port.out.MessagePublisher;

@Component
public class MessageKafkaPublisher implements MessagePublisher {

  public static final String TOPIC = "message";

  private final KafkaTemplate<String, Message> kafkaTemplate;

  public MessageKafkaPublisher(KafkaTemplate<String, Message> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  @Override
  public void publishMessage(Message message) {
    System.out.println("Publishing message: " + message);

    kafkaTemplate.send(TOPIC, message);
  }

}
