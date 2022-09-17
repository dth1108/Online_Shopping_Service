package com.example.quizpractice.service;

import com.example.quizpractice.domain.Role;
import java.util.Optional;

public interface RoleService {

    Optional<Role> getRoleByCode(String code);
}
