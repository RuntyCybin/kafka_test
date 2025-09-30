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

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Void> createMessage(@RequestBody Message message) {
    createMessageUseCase.createMessage(message);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
}
