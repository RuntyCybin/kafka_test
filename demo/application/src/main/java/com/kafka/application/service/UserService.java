package com.kafka.application.service;

import java.util.List;
import com.kafka.domain.User;
import com.kafka.rest.UserUpdateRequestDto;
import com.kafka.rest.UserUpdateResponseDto;

public interface UserService {

  UserUpdateResponseDto createUser(UserUpdateRequestDto userRequest);

  void deleteUser(String userId);

  boolean updateUser(UserUpdateRequestDto userRequest);

  User getUserById(String userId);

  List<User> getAllUsers();
}
