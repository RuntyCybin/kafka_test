package com.kafka.application.port.out;

import com.kafka.domain.Message;

public interface MesssagePublisher {

  void publishMessage(Message message);

}
