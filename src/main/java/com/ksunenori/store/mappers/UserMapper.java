package com.ksunenori.store.mappers;

import com.ksunenori.store.dtos.RegisterUserRequest;
import com.ksunenori.store.dtos.UpdateUserRequest;
import com.ksunenori.store.dtos.UserDto;
import com.ksunenori.store.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(RegisterUserRequest request);
    void update(UpdateUserRequest request, @MappingTarget User user);
}
