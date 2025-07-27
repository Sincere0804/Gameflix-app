package com.example.gameflix.controller;

import com.example.gameflix.model.User;
import com.example.gameflix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody User user) {
        String message = userService.registerUser(user);
        Map<String, String> response = new HashMap<>();
        response.put("message", message);
        return response;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User user) {
        String message = userService.loginUser(user);
        Map<String, String> response = new HashMap<>();
        response.put("message", message);
        return response;
    }
}
