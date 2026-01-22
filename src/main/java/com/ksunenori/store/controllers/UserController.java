package com.ksunenori.store.controllers;

import com.ksunenori.store.dtos.UserDto;
import com.ksunenori.store.entities.User;
import com.ksunenori.store.mappers.UserMapper;
import com.ksunenori.store.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Getter

@RequestMapping("/users")
@RestController
public class UserController {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @GetMapping()
    public Iterable<UserDto> getUsers(
            @RequestParam(required = false, defaultValue = "", name = "sort") String sort) {
        if (!Set.of("name", "email").contains(sort)) {
            sort = "name";
        }
        return userRepository.findAll(Sort.by(sort))
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable long id) {
        var user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(userMapper.toDto(user));
    }
}