package com.example.userservice.controller ;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    @GetMapping
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
