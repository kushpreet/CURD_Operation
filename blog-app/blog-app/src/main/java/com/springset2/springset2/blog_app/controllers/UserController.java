package com.springset2.springset2.blog_app.controllers;

import com.springset2.springset2.blog_app.exceptions.BadRequestException;
import com.springset2.springset2.blog_app.exceptions.MissingAttributeException;
import com.springset2.springset2.blog_app.request.UserRequest;
import com.springset2.springset2.blog_app.response.UserResponse;
import com.springset2.springset2.blog_app.services.userService;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Pattern;

@Data
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private userService userService;

    @PostMapping("/")
    public UserResponse createUser(@Valid @RequestBody UserRequest userRequest) {
        if (userRequest.getEmail() == null || !userRequest.getEmail().contains("@")) {
            throw new BadRequestException("invalid email");
        }
        if (userRequest.getName() == null) {
            throw new MissingAttributeException("name");
        }
        if (!isPasswordValid(userRequest.getPassword())) {
            throw new MissingAttributeException("Password must contain at least one special symbol, one capital letter, and be at least 8 characters long, Special symbol at not beginning or end");
        }
        if (userRequest.getAbout() == null) {
            throw new MissingAttributeException("About");
        }
        return userService.createUser(userRequest);
    }


    @GetMapping("/{userId}")
    public UserResponse getUserById(@PathVariable String userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/")
    public List<UserResponse> getAllUsers(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return userService.getAllUsers(page, size);
    }
    @PutMapping("/{userId}")
    public UserResponse updateUser(@RequestBody UserRequest userRequest, @PathVariable Integer userId) {
        if (userRequest.getEmail() == null || !userRequest.getEmail().contains("@")) {
            throw new BadRequestException("invalid email");
        }
        if (userRequest.getName() == null) {
            throw new MissingAttributeException("name");
        }
        if (!isPasswordValid(userRequest.getPassword())) {
            throw new MissingAttributeException("Password must contain at least one special symbol, one capital letter, and be at least 8 characters long, Special symbol at not beginning or end");
        }
        if (userRequest.getAbout() == null) {
            throw new MissingAttributeException("About");
        }

        return userService.updateuser(userRequest, userId);
    }
    private boolean isPasswordValid(String password) {
        String passwordPattern = "^(?=.*[A-Z])(?=.*[!@#$%^&*()_+=-])(?!^[!@#$%^&*()_+=-])(?!.*[!@#$%^&*()_+=-]$).{8,}$";
        return password.matches(passwordPattern);    }


    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
    }
}
