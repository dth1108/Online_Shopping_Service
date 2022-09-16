package com.example.quizpractice.repository;

import com.example.quizpractice.domain.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, String>,
        JpaSpecificationExecutor<Permission> {

}
