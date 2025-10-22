package com.kafka.rest.mappers;

import com.kafka.rest.UserUpdateResponseDto;
import com.kafka.domain.User;
import org.mapstruct.*;

@Mapper(
        config = GlobalMappingConfig.class,
        uses = TextQualifiers.class
)
public interface UserToUserUpdateResponseDtoMapper {

  @Mapping(target = "name", expression = "java( entity.getName() + \"prueba\" )")
  @Mapping(source = "email", target = "email")
  UserUpdateResponseDto toUserResponseDto(User entity);
}
