package com.example.quizpractice.service.impl;

import com.example.quizpractice.common.service.BusinessError;
import com.example.quizpractice.common.service.BusinessErrorException;
import com.example.quizpractice.domain.User;
import com.example.quizpractice.domain.UserRole;
import com.example.quizpractice.repository.RoleRepository;
import com.example.quizpractice.service.LoginService;
import com.example.quizpractice.service.UserRoleService;
import com.example.quizpractice.service.UserService;
import java.util.Collections;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.RequestScope;

@Service
@Transactional
@RequestScope
public class LoginImpl implements LoginService {

    private final UserService userService;
    private final UserRoleService userRoleService;

    private final RoleRepository roleRepository;

    public LoginImpl(UserService userService, UserRoleService userRoleService,
            RoleRepository roleRepository) {
        this.userService = userService;
        this.userRoleService = userRoleService;
        this.roleRepository = roleRepository;
    }

    @Override
    public String getRole(String username) {
        User user = userService.findByUsername(username)
                .orElseThrow(() -> new BusinessErrorException(
                        BusinessError.builder().errorCode("error.user.notFoundWithUsername")
                                .params(Collections.singletonList(username))
                                .build()));
        ;
        Optional<UserRole> userRole = userRoleService.getFirstUserRolesByUserId(user.getId());

        return roleRepository.findById(userRole.get().getRoleId()).get().getRoleName();
    }
}
