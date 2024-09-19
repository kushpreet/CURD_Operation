package com.springset2.springset2.blog_app.services.services.impl;

import com.springset2.springset2.blog_app.entities.User;
import com.springset2.springset2.blog_app.exceptions.ResourceNotFoundException;
import com.springset2.springset2.blog_app.mapper.UserMapper;
import com.springset2.springset2.blog_app.request.UserRequest;
import com.springset2.springset2.blog_app.response.UserResponse;
import com.springset2.springset2.blog_app.services.userService;
import com.springset2.springset2.blog_app.repositories.userRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
public class userServiceimpl implements userService {

    @Autowired
    private userRepo userRepo;

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        User user = UserMapper.mapUserRequestToUser(userRequest);
        return UserMapper.mapUserToUserResponse(userRepo.save(user));
    }


    @Override
    public UserResponse updateuser(UserRequest userRequest, Integer userId) {
        User user =this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user","id","userId"));
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setAbout(userRequest.getAbout());

        User updatedUser = userRepo.save(user);
        return UserMapper.mapUserToUserResponse(updatedUser);
    }

    @Override
    public UserResponse getUserById(String userId) {
        User user =this.userRepo.findById(Integer.valueOf(userId)).orElseThrow(()-> new ResourceNotFoundException("user","id","userId"));
        return UserMapper.mapUserToUserResponse(user);
    }

    @Override
    public List<UserResponse> getAllUsers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<User> usersPage = userRepo.findAll(pageable);
        return usersPage.stream().map(UserMapper::mapUserToUserResponse).collect(Collectors.toList());
    }
    @Override
    public void deleteUser(Integer userId) {
        User user =this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user","id","userId"));
        this.userRepo.delete(user);
    }
}
