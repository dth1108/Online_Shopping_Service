package com.example.quizpractice.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class UserRegisterDTO implements IUserRegisterDTO {

    private String id;

    @NonNull
    private String username;
    @NonNull

    private String password;
    @NonNull

    private String email;
    @NonNull

    private String firstName;
    @NonNull

    private String lastName;

}
