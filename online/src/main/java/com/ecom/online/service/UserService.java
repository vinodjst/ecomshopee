package com.ecom.online.service;

import com.ecom.online.entity.UserEntity;
import com.ecom.online.model.UserRequest;
import com.ecom.online.model.UserResponse;

public interface UserService {

    String registerUser(UserRequest userRequest);

    String loginUser(String userName, String password);

    UserResponse getProfile(Long id);
}
