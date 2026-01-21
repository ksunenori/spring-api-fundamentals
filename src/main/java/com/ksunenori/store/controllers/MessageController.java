package com.ksunenori.store.controllers;

import com.ksunenori.store.entities.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @RequestMapping("/hello")
    public String sayHello() {
        return "Hello World";
    }

    @RequestMapping("/hello2")
    public Message sayHello2() {
        return new Message("Hello World");
    }
}
