package com.kafka.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.application.service.UserService;
import com.kafka.domain.User;
import com.kafka.domain.UserUpdateRequestDto;

@RestController
@RequestMapping("/api/users")
public class UserController {

  private final UserService userService;

  UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/create")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<User> createUser(@RequestBody UserUpdateRequestDto userRequest) {
    User user = userService.createUser(userRequest);
    return ResponseEntity.status(HttpStatus.CREATED).body(user);
  }

  @DeleteMapping
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Void> deleteUser(@RequestBody String userId) {
    userService.deleteUser(userId);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @PostMapping("/update")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Boolean> updateUser(@RequestBody UserUpdateRequestDto userRequest) {
    boolean updated = userService.updateUser(userRequest);
    return ResponseEntity.status(HttpStatus.OK).body(updated);
  }

  @GetMapping("/get")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<User> getUserById(@RequestBody String userId) {
    User user = userService.getUserById(userId);
    return ResponseEntity.status(HttpStatus.OK).body(user);
  }

  @GetMapping("/all")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<List<User>> getAllUsers() {
    List<User> users = userService.getAllUsers();
    return ResponseEntity.status(HttpStatus.OK).body(users);
  }

}
