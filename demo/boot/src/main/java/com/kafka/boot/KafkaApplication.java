package com.kafka.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.kafka")
public class KafkaApplication {
  public static void main(String[] args) {
    SpringApplication.run(KafkaApplication.class, args);
    System.out.println("Project start!");
  }
}
