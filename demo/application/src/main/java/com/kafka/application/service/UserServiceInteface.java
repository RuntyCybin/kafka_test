package com.kafka.application.service;

import java.util.List;

import com.kafka.domain.User;

public interface UserServiceInteface {

  void createUser(String name, String email);

  void deleteUser(String userId);

  boolean updateUser(String userId, String name, String email);

  User getUserById(String userId);

  List<User> getAllUsers();
}
