package com.kafka.rest.mappers;

import com.kafka.rest.UserUpdateRequestDto;
import com.kafka.domain.User;
import org.mapstruct.*;

@Mapper(
        config = GlobalMappingConfig.class,
        uses = TextQualifiers.class
)
public interface UserToUserUpdateRequestDtoMapper {

  @Mappings({
          @Mapping(target = "email", expression = "java( dto.name().concat(\"@rambler.com\") )")
  })
  User toUserRequest(UserUpdateRequestDto dto);

  @AfterMapping
  default void trimName(@MappingTarget User entity) {
    entity.setName(entity.getName().trim());
    System.out.println("After mapping method");
  }
}
