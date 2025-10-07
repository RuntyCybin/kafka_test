package com.kafka.consumer;

import java.util.Map;
import com.kafka.domain.Message;
import com.kafka.domain.User;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

  @Bean
  public ConsumerFactory<String, Message> messageConsumerFactory() {
    JsonDeserializer<Message> jsonDeserializer = new JsonDeserializer<>(Message.class);
    jsonDeserializer.addTrustedPackages("*");

    return new DefaultKafkaConsumerFactory<>(
        Map.of(
            ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092",
            ConsumerConfig.GROUP_ID_CONFIG, "message_group",
            ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class,
            ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class,
            ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS, JsonDeserializer.class),
        new StringDeserializer(),
        jsonDeserializer);
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, Message> messageListenerFactory() {
    var factory = new ConcurrentKafkaListenerContainerFactory<String, Message>();
    factory.setConsumerFactory(messageConsumerFactory());
    factory.setAutoStartup(true);
    return factory;
  }

  // Additional consumer factories and listener factories can be defined here for
  // other message types
  // User consumer factory and listener factory
  @Bean
  public ConsumerFactory<String, User> userConsumerFactory() {
    JsonDeserializer<User> jsonDeserializer = new JsonDeserializer<>(User.class);
    jsonDeserializer.addTrustedPackages("*");

    return new DefaultKafkaConsumerFactory<>(
        Map.of(
            ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092",
            ConsumerConfig.GROUP_ID_CONFIG, "user_group",
            ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class,
            ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class,
            ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS, JsonDeserializer.class),
        new StringDeserializer(),
        jsonDeserializer);
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, User> userListenerFactory() {
    var factory = new ConcurrentKafkaListenerContainerFactory<String, User>();
    factory.setConsumerFactory(userConsumerFactory());
    factory.setAutoStartup(true);
    return factory;
  }

}
