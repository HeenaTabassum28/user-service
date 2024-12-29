package com.example.userservice.controller;

import com.example.userservice.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable String id) {
        userService.getUserById(id);
        return "Hello World";
    }

    @PostMapping
    public String addUser() {
        return "Post User";
    }

    @PutMapping
    public String updateUser() {
        return "Update User";
    }

    @DeleteMapping
    public String deleteUser() {
        return "Delete User";
    }

}
