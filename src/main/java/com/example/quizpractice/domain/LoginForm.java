package com.example.quizpractice.domain;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginForm {

    @NotBlank
    private String username;
    @NotBlank
    private String password;
}