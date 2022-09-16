package com.example.quizpractice.service.impl;

import com.example.quizpractice.domain.UserRole;
import com.example.quizpractice.repository.UserRoleRepository;
import com.example.quizpractice.service.UserRoleService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.RequestScope;

@Service
@Transactional
@RequestScope
public class UserRoleImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRoleImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public List<UserRole> getAllUserRolesByUserId(String userId) {
        List<UserRole> userRole = userRoleRepository.findAllByUserId(userId);
        return userRole;
    }
}
