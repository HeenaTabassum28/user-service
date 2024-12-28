package com.example.userservice.controller ;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @GetMapping("/api/user")
    public String getUser() {
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
