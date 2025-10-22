package com.kafka.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kafka.application.port.in.UserUseCase;
import com.kafka.domain.User;


@Service
public class UserServiceImpl implements UserService {

  private final UserUseCase usersPublisher;

  public UserServiceImpl(UserUseCase usersCase) {
    this.usersPublisher = usersCase;
  }

  @Override
  public User createUser(User userRequest) {
    // Implementation for creating a user
    System.out.println("UserServiceImpl - createUser - Name:" + userRequest.getName() + " email: " + userRequest.getEmail());
    return this.usersPublisher.createUserMessage(userRequest);
  }

  @Override
  public void deleteUser(String userEmail) {
    System.out.println("User deleted: ");
  }

  @Override
  public boolean updateUser(User userRequest) {
    System.out.println("User updated");
    return false;
  }

  @Override
  public User getUserById(String userEmail) {
    System.out.println("User found");
    return new User("John Doe", "test@test.com");
  }

  @Override
  public List<User> getAllUsers() {
    System.out.println("All users: ");
    return List.of(new User("John Doe", "test@test.com"));
  }
}
