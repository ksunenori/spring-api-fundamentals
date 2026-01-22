package com.ksunenori.store.controllers;

import com.ksunenori.store.dtos.UserDto;
import com.ksunenori.store.entities.User;
import com.ksunenori.store.mappers.UserMapper;
import com.ksunenori.store.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@Getter

@RequestMapping("/users")
@RestController
public class UserController {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @GetMapping()
    public Iterable<UserDto> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    //Manual Mapping
//        @GetMapping()
//    public Iterable<UserDto> getUsers() {
//        return userRepository.findAll()
//                .stream()
//                .map(user -> new UserDto(user.getId(), user.getName(), user.getEmail()))
//                .toList();
//    }
//
//
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable long id) {
        var user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(userMapper.toDto(user));
    }
    // Manual Mapping
//        @GetMapping("/{id}")
//    public ResponseEntity<UserDto> getUserById(@PathVariable long id) {
//        var user = userRepository.findById(id).orElse(null);
//
//        if (user == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        var userDto = new UserDto(user.getId(), user.getName(), user.getEmail());
//        return ResponseEntity.ok(userDto);
//    }
//
}