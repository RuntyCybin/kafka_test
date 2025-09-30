package com.kafka.application.service;

import java.util.List;

import com.kafka.domain.User;

public class UserServiceImpl implements UserService {
  @Override
  public void createUser(String name, String email) {
    // Implementation for creating a user
    System.out.println("User created: " + name + ", " + email);
  }

  @Override
  public void deleteUser(String userId) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
  }

  @Override
  public boolean updateUser(String name, String email) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
  }

  @Override
  public User getUserById(String userId) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getUserById'");
  }

  @Override
  public List<User> getAllUsers() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAllUsers'");
  }
}
