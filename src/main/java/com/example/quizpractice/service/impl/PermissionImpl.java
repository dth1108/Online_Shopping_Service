package com.example.quizpractice.service.impl;

import com.example.quizpractice.domain.Permission;
import com.example.quizpractice.repository.PermissionRepository;
import com.example.quizpractice.repository.UserRepository;
import com.example.quizpractice.service.PermissionService;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.RequestScope;

@Service
@Transactional
@RequestScope
public class PermissionImpl implements PermissionService {


    private final PermissionRepository permissionRepository;

    public PermissionImpl(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Permission> findOne(String id) {
        return permissionRepository.findById(id);
    }
}
