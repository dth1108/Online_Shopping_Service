package com.example.quizpractice.service;

import com.example.quizpractice.domain.RolePermission;
import java.util.Collection;
import java.util.List;

public interface RolePermissionService {
    List<RolePermission> getRolePermissionsByRoleId(String roleId);

}
