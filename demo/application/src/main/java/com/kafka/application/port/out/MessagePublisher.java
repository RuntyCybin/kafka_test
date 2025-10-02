package com.kafka.application.port.out;

import com.kafka.domain.Message;

public interface MessagePublisher {

  void publishMessage(Message message);

}
