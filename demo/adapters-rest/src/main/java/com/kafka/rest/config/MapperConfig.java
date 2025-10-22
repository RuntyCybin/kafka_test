package com.kafka.rest.config;

import com.kafka.rest.mappers.TextQualifiers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

  @Bean
  public TextQualifiers textQualifiers() {
    return new TextQualifiers();
  }
}
