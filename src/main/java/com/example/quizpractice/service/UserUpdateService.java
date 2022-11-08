package com.example.quizpractice.service;

import com.example.quizpractice.common.sso.payload.LoginRequest;
import com.example.quizpractice.domain.User;
import com.example.quizpractice.dto.UserDTO;

public interface UserUpdateService {

    UserDTO save(String id, UserDTO UserDTO);

    User myProfile(String username);

    void changePassword(String username, String oldPassword, String newPassword);

    void verify(LoginRequest loginRequest);

    void validationCommon(String id, UserDTO UserDTO);
}
