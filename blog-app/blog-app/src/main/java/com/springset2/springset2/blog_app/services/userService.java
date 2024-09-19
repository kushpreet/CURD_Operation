package com.springset2.springset2.blog_app.services;

import com.springset2.springset2.blog_app.request.UserRequest;
import com.springset2.springset2.blog_app.response.UserResponse;
import lombok.Data;

import java.util.List;

import java.util.List;

public interface userService {
    UserResponse createUser(UserRequest userRequest);
    UserResponse updateuser(UserRequest userRequest, Integer userId);
    UserResponse getUserById(String userId);
    List<UserResponse> getAllUsers(int page, int size);
    void deleteUser(Integer userId);
}