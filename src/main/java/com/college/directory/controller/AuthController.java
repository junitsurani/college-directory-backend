package com.college.directory.controller;

import com.college.directory.dto.LoginRequest;
import com.college.directory.dto.LoginResponse;
import com.college.directory.model.User;
import com.college.directory.security.JwtTokenUtil;
import com.college.directory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        Optional<User> userOptional = userService.findByUsername(request.getUsername());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                String token = jwtTokenUtil.generateToken(user.getUsername());
                return new LoginResponse(token);
            }
        }
        throw new RuntimeException("Invalid username or password");
    }
}
