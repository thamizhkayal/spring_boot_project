package com.hd.app.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hd.app.model.User;
import com.hd.app.service.UserService;

@RestController("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUser());
    }

    @PostMapping("user")
    public ResponseEntity<User> addUser(@RequestBody User user) {

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("user").build().toUri();
        User userData = userService.addUser(user);

        return ResponseEntity.created(location).body(userData);
    }

}
