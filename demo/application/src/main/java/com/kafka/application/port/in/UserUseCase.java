package com.kafka.application.port.in;

import com.kafka.domain.User;

public interface UserUseCase {
  User createUserMessage(User user);
}
