package com.example.quizpractice.service;

import com.example.quizpractice.common.service.BusinessError;
import com.example.quizpractice.dto.UserRegisterDTO;

public interface UserRegisterService {

    UserRegisterDTO save(UserRegisterDTO userRegisterDTO);


    void validationCommon(UserRegisterDTO userRegisterDTO);

}
