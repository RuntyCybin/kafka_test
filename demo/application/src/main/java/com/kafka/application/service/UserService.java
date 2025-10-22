package com.kafka.application.service;

import java.util.List;
import com.kafka.domain.User;

public interface UserService {

  User createUser(User userRequest);

  void deleteUser(String userId);

  boolean updateUser(User userRequest);

  User getUserById(String userId);

  List<User> getAllUsers();
}
