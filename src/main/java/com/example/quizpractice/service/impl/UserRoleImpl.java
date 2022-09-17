package com.example.quizpractice.service.impl;

import com.example.quizpractice.common.repository.RoleConstant;
import com.example.quizpractice.domain.UserRole;
import com.example.quizpractice.repository.UserRoleRepository;
import com.example.quizpractice.service.RoleService;
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
    private final RoleService roleService;

    public UserRoleImpl(UserRoleRepository userRoleRepository, RoleService roleService) {
        this.userRoleRepository = userRoleRepository;
        this.roleService = roleService;
    }

    @Override
    public List<UserRole> getAllUserRolesByUserId(String userId) {
        List<UserRole> userRole = userRoleRepository.findAllByUserId(userId);
        return userRole;
    }

    @Override
    public Optional<UserRole> getFirstUserRolesByUserId(String userId) {
        return userRoleRepository.findFirstByUserId(userId);
    }

    @Override
    public void setRoleDefaultByUserId(String userId) {
        UserRole userRole = new UserRole();
        userRole.isDeleted(0L).roleId(RoleConstant.USER).setUserId(userId);
        userRoleRepository.save(userRole);
    }
}
