package com.runverve.runvervedemoproject.controller;

import com.runverve.runvervedemoproject.dto.LoginRequest;
import com.runverve.runvervedemoproject.service.UserService;
import com.runverve.runvervedemoproject.model.User;
import com.runverve.runvervedemoproject.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil; //  Inject JwtUtil here

    @GetMapping("/register")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        // Check if the email already exists
        if (userService.getUserByEmail(user.getUserMail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Collections.singletonMap("message", "Email already exists"));
        }

        // Always set role as USER
        user.setRole("USER");

        // Encrypt password
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));

        // Save user
        userService.saveUser(user);

        return ResponseEntity.ok(Collections.singletonMap("message", "User registered successfully"));
    }


    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest authRequest) {
        Optional<User> userOptional = userService.getUserByEmail(authRequest.getUserMail());

        if (userOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("message", "User not found"));
        }

        User userFromDb = userOptional.get();
        String userPassword = authRequest.getUserPassword();

        // Check if password is null
        if (userPassword == null || userPassword.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("message", "Password cannot be null or empty"));
        }

        boolean isPasswordMatch = passwordEncoder.matches(userPassword, userFromDb.getUserPassword());

        if (!isPasswordMatch) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Collections.singletonMap("message", "Invalid email or password"));
        }

        // ✅ Generate JWT token
        String token = jwtUtil.generateToken(userFromDb.getUserMail(), userFromDb.getRole());

        System.out.println("Raw password: " + userPassword);
        System.out.println("Hashed password from DB: " + userFromDb.getUserPassword());
        System.out.println("Password matches: " + passwordEncoder.matches(userPassword, userFromDb.getUserPassword()));
        System.out.println("Role: " + userFromDb.getRole());
        // ✅ Send token + user details
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Login successful");
        response.put("userID",userFromDb.getUserId());
        response.put("token", token);
        response.put("userName", userFromDb.getUserName());
        response.put("role", userFromDb.getRole());

        return ResponseEntity.ok(response);
    }
}
