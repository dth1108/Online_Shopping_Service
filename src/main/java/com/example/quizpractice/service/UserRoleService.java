package com.example.quizpractice.service;

import com.example.quizpractice.domain.UserRole;
import java.util.List;
import java.util.Optional;

public interface UserRoleService {
    List<UserRole> getAllUserRolesByUserId(String userId);
}
