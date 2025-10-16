package com.example.microservice.mapper;

import com.example.microservice.dto.UserDto;
import com.example.microservice.entity.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    User toEntity(final UserDto userDto);

    UserDto toDto(final User user);

    List<UserDto> toListDto(final List<User> user);
}