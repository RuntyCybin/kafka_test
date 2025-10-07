package com.kafka.application.port.out;

import com.kafka.domain.User;

public interface UsersPublisher {

  void createUserMessage(User user);

}
