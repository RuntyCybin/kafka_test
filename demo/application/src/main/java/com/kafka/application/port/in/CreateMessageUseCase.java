package com.kafka.application.port.in;

import com.kafka.domain.Message;

public interface CreateMessageUseCase {

  void createMessage(Message message);

}
