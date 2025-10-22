package com.kafka.rest;

import java.util.List;

import com.kafka.rest.mappers.UserToUserUpdateRequestDtoMapper;
import com.kafka.rest.mappers.UserToUserUpdateResponseDtoMapper;
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

@RestController
@RequestMapping("/api/users")
public class UserController {

  private final UserService userService;
  private final UserToUserUpdateResponseDtoMapper userToUserUpdateResponseDtoMapper;
  private final UserToUserUpdateRequestDtoMapper userToUserUpdateRequestDtoMapper;

  UserController(UserService userService,
                 UserToUserUpdateResponseDtoMapper responseMapper,
                 UserToUserUpdateRequestDtoMapper requestMapper) {
    this.userService = userService;
    this.userToUserUpdateResponseDtoMapper = responseMapper;
    this.userToUserUpdateRequestDtoMapper = requestMapper;
  }

  @PostMapping("/create")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<UserUpdateResponseDto> createUser(@RequestBody UserUpdateRequestDto request) {
    final User userRequest = this.userToUserUpdateRequestDtoMapper.toUserRequest(request);
    final var response = this.userService.createUser(userRequest);
    System.out.println("response: " + response);
    final var aux = this.userToUserUpdateResponseDtoMapper.toUserResponseDto(response);
    System.out.println("AUX: " + aux);
    return ResponseEntity.status(HttpStatus.CREATED).body(aux);
  }

  @DeleteMapping
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Void> deleteUser(@RequestBody String userId) {
    this.userService.deleteUser(userId);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @PostMapping("/update")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Boolean> updateUser(@RequestBody UserUpdateRequestDto userRequest) {
    final User request = this.userToUserUpdateRequestDtoMapper.toUserRequest(userRequest);
    final boolean response = this.userService.updateUser(request);
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  @GetMapping("/get")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<User> getUserById(@RequestBody String userId) {
    final User user = this.userService.getUserById(userId);
    return ResponseEntity.status(HttpStatus.OK).body(user);
  }

  @GetMapping("/all")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<List<User>> getAllUsers() {
    final List<User> users = this.userService.getAllUsers();
    return ResponseEntity.status(HttpStatus.OK).body(users);
  }

}
