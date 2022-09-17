package com.example.quizpractice.service.impl;

import com.example.quizpractice.domain.Role;
import com.example.quizpractice.repository.RoleRepository;
import com.example.quizpractice.service.RoleService;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.RequestScope;

@Service
@Transactional
@RequestScope
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<Role> getRoleByCode(String code) {
        return roleRepository.findByCode(code);
    }
}
