package com.example.quizpractice.service;

import com.example.quizpractice.domain.User;
import com.example.quizpractice.dto.UserDTO;

public interface UserUpdateService {
    UserDTO save(String id, UserDTO UserDTO);
    User myProfile(String username);


    void validationCommon(String id,UserDTO UserDTO);
}
