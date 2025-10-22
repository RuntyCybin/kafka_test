package com.kafka.application.service;

import org.springframework.stereotype.Service;

import com.kafka.application.port.in.UserUseCase;
import com.kafka.application.port.out.UsersPublisher;
import com.kafka.domain.User;

@Service
public class UserServiceUseCaseImpl implements UserUseCase {

  private final UsersPublisher usersPublisher;

  public UserServiceUseCaseImpl(UsersPublisher usersPublisher) {
    this.usersPublisher = usersPublisher;
  }

  @Override
  public User createUserMessage(User user) {
    // Business logic for creating a user can be added here
    System.out.println("Publishing user: " + user);
    this.usersPublisher.createUserMessage(user);
    return user;
  }

}
