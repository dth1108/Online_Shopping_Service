package com.example.quizpractice.service;


import com.example.quizpractice.domain.JwtResponse;

public interface LoginService {

    public JwtResponse esponseLogin(String username, String password);

}
