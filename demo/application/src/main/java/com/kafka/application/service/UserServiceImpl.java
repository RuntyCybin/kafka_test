package com.kafka.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kafka.application.port.in.UserUseCase;
import com.kafka.domain.User;
import com.kafka.rest.UserUpdateRequestDto;
import com.kafka.rest.UserUpdateResponseDto;

@Service
public class UserServiceImpl implements UserService {

  private final UserUseCase usersPublisher;

  public UserServiceImpl(UserUseCase usersCase) {
    this.usersPublisher = usersCase;
  }

  @Override
  public UserUpdateResponseDto createUser(UserUpdateRequestDto userRequest) {
    // Implementation for creating a user
    System.out.println("User created: " + userRequest.name() + ", " + userRequest.email());
    User user = usersPublisher.createUserMessage(new User(userRequest.name(), userRequest.email()));
    UserUpdateResponseDto response = new UserUpdateResponseDto(user.getName(), user.getEmail());
    return response;

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
