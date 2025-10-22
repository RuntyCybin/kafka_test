package com.kafka.rest.mappers;

import org.mapstruct.Named;

public class TextQualifiers {
  @Named("lowercase")
  public String lowerCase(String str) {
    return str != null ? str.toLowerCase() : null;
  }
}
