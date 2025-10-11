package com.kafka.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.application.port.in.CreateMessageUseCase;
import com.kafka.domain.Message;

@RestController
@RequestMapping("/api/message")
public class MessageController {
  private final CreateMessageUseCase createMessageUseCase;

  public MessageController(CreateMessageUseCase createMessageUseCase) {
    this.createMessageUseCase = createMessageUseCase;
  }

  @PostMapping("/create")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Message> createMessage(@RequestBody Message message) {
    System.out.println("createMessage: " + message.getContent());
    Message resp = createMessageUseCase.createMessage(message);
    return ResponseEntity.status(HttpStatus.CREATED).body(resp);
  }
}
