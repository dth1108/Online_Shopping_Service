package com.example.quizpractice.service.impl;

import com.example.quizpractice.common.service.BusinessError;
import com.example.quizpractice.common.service.BusinessErrorException;
import com.example.quizpractice.domain.User;
import com.example.quizpractice.domain.UserRole;
import com.example.quizpractice.service.PermissionService;
import com.example.quizpractice.service.RolePermissionService;
import com.example.quizpractice.service.UserRolePermissionService;
import com.example.quizpractice.service.UserRoleService;
import com.example.quizpractice.service.UserService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.RequestScope;

@Service
@Transactional
@RequestScope
public class UserRolePermissionImpl implements UserRolePermissionService {

    private final UserService userService;
    private final UserRoleService userRoleService;
    private final RolePermissionService rolePermissionService;

    private final PermissionService permissionService;

    public UserRolePermissionImpl(UserService userService, UserRoleService userRoleService,
            RolePermissionService rolePermissionService, PermissionService permissionService) {
        this.userService = userService;
        this.userRoleService = userRoleService;
        this.rolePermissionService = rolePermissionService;
        this.permissionService = permissionService;
    }

    @Override
    public Collection<? extends GrantedAuthority> populateAuthorities(String username) {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        User user = userService.findByUsername(username).orElseThrow(
                () -> new BusinessErrorException(
                        BusinessError.builder().errorCode("error.user.notFoundWithUsername")
                                .params(Collections.singletonList(username)).build()));
        List<String> permissionsCode = getAllPermissionsByUsername(username);
        for (String permission : permissionsCode) {
            authorityList.add(new SimpleGrantedAuthority(permission));
        }
        return authorityList;
    }

    @Override
    public List<String> getAllPermissionsByUsername(String username) {
        User user = userService.findByUsername(username).orElseThrow(
                () -> new BusinessErrorException(
                        BusinessError.builder().errorCode("error.user.notFoundWithUsername")
                                .params(Collections.singletonList(username)).build()));

        List<UserRole> listRoles = userRoleService.getAllUserRolesByUserId(user.getId());
        List<String> permissionsCode = new ArrayList<>();
        if (listRoles != null && listRoles.size() > 0) {
            listRoles.forEach((role) -> {
                rolePermissionService.getRolePermissionsByRoleId(role.getRoleId()).forEach(
                        (RolePermission) -> permissionsCode.add(
                                permissionService.findOne(RolePermission.getPermissionId()).get()
                                        .getCode()));
            });
        } else {
            throw new BusinessErrorException(
                    BusinessError.builder().errorCode("error.user.notFoundRoleOfAccount")
                            .params(Collections.singletonList(username)).build());
        }

        return permissionsCode;
    }
}
