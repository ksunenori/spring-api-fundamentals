package com.ksunenori.store.mappers;

import com.ksunenori.store.dtos.UserDto;
import com.ksunenori.store.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
}
