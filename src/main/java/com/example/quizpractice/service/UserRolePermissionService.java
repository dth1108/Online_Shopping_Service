package com.example.quizpractice.service;

import com.example.quizpractice.domain.Permission;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;

public interface UserRolePermissionService {
    Collection<? extends GrantedAuthority> populateAuthorities(String username);


    List<String> getAllPermissionsByUsername(String username);
}
