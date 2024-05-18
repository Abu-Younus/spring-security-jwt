package com.younus.springsecurityjwt.controller;

import com.younus.springsecurityjwt.domain.UserDto;
import com.younus.springsecurityjwt.service.JwtService;
import com.younus.springsecurityjwt.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;


    @GetMapping("/about")
    public String about() {
        return "Welcome to about";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Welcome to hello";
    }

    @PostMapping("/register")
    public UserDto register(@Valid @RequestBody UserDto userDto){
        return userService.saveUser(userDto);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserDto user) {

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
            );
            if (authentication.isAuthenticated()) {
                return jwtService.generateToken(user.getEmail());
            }
        } catch (Exception e) {
            return "Invalid email or password";
        }
        return "User not logged in";
    }
}
