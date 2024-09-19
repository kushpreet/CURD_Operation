package com.springset2.springset2.blog_app.mapper;

import com.springset2.springset2.blog_app.entities.User;
import com.springset2.springset2.blog_app.request.UserRequest;
import com.springset2.springset2.blog_app.response.UserResponse;

public class UserMapper {

    public static User mapUserRequestToUser(UserRequest userRequest) {
        User user = new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setAbout(userRequest.getAbout());
        return user;
    }

    public static UserResponse mapUserToUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setName(user.getName());
        userResponse.setEmail(user.getEmail());
        userResponse.setPassword(user.getPassword());
        userResponse.setAbout(user.getAbout());
        return userResponse;
    }
}
