package com.example.quizpractice.dto;

import lombok.Data;

public interface IUserRegisterDTO {

    String getId();
    String getUsername();

    String getPassword();

    String getEmail();

    String getFirstName();

    String getLastName();

}
