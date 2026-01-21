package com.ksunenori.store.controllers;

import com.ksunenori.store.entities.User;
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

    @GetMapping()
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id) {
        var user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return ResponseEntity.notFound().build();
            // option 2 new ResponseEntity(user, Http....
        }
        return ResponseEntity.ok(user);
    }
}