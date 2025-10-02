package com.kafka.application.service;

import java.util.List;

import com.kafka.domain.User;
import com.kafka.domain.UserUpdateRequestDto;

public class UserServiceImpl implements UserService {
  @Override
  public void createUser(UserUpdateRequestDto userRequest) {
    // Implementation for creating a user
    System.out.println("User created: " + userRequest.name() + ", " + userRequest.email());
  }

  @Override
  public void deleteUser(String userEmail) {
    System.out.println("User deleted: ");
  }

  @Override
  public boolean updateUser(UserUpdateRequestDto userRequest) {
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
