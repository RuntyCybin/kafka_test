package com.kafka.application.service;

import org.springframework.stereotype.Service;

import com.kafka.application.port.in.CreateMessageUseCase;
import com.kafka.application.port.out.MessagePublisher;
import com.kafka.domain.Message;

@Service
public class MessageService implements CreateMessageUseCase {

  private final MessagePublisher messsagePublisher;

  public MessageService(MessagePublisher messsagePublisher) {
    this.messsagePublisher = messsagePublisher;
  }

  @Override
  public Message createMessage(Message message) {
    // Business logic for creating a message can be added here
    messsagePublisher.publishMessage(message);
    return message;
  }

}
