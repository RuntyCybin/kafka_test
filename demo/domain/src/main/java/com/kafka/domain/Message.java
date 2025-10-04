package com.kafka.domain;

import java.time.LocalDateTime;

public class Message {

  private String content;
  private LocalDateTime timestamp = LocalDateTime.now();

  public Message() {
  }

  public Message(String content) {
    this.content = content;
  }

  public Message(String content, LocalDateTime timestamp) {
    this.content = content;
    this.timestamp = timestamp;
  }

  public String getContent() {
    return content;
  }

  public LocalDateTime getTimestamp() {
    return LocalDateTime.now();
  }

  @Override
  public String toString() {
    return "Message{" +
        "content='" + content + '\'' +
        '}';
  }

}
