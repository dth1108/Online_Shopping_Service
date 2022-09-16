package com.example.quizpractice.service;

import com.example.quizpractice.domain.Permission;
import java.util.Optional;

public interface PermissionService {

    Optional<Permission> findOne(String id);

}
