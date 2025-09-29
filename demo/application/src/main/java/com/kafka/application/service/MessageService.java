package com.kafka.application.service;

import org.springframework.stereotype.Service;

import com.kafka.application.port.in.CreateMessageUseCase;
import com.kafka.application.port.out.MesssagePublisher;
import com.kafka.domain.Message;

@Service
public class MessageService implements CreateMessageUseCase {

  private final MesssagePublisher messsagePublisher;

  public MessageService(MesssagePublisher messsagePublisher) {
    this.messsagePublisher = messsagePublisher;
  }

  @Override
  public void createMessage(Message message) {
    // Business logic for creating a message can be added here
    messsagePublisher.publishMessage(message);
  }

}
