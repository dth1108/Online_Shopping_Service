package com.example.quizpractice.repository;

import com.example.quizpractice.domain.RolePermission;
import com.example.quizpractice.domain.User;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RolePermissionRepository extends JpaRepository<RolePermission, String>,
        JpaSpecificationExecutor<RolePermission> {

    List<RolePermission> findByRoleId(String roleId);
}
