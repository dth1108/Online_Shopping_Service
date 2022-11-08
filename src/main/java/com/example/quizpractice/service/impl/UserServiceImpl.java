package com.example.quizpractice.service.impl;

import com.example.quizpractice.common.service.BusinessError;
import com.example.quizpractice.common.service.BusinessErrorException;
import com.example.quizpractice.domain.User;
import com.example.quizpractice.repository.UserRepository;
import com.example.quizpractice.service.UserService;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.RequestScope;

/**
 * Service Implementation for managing {@link User}.
 */
@Service
@Transactional
@RequestScope
public class UserServiceImpl implements UserService {

    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final com.example.quizpractice.repository.UserRepository UserRepository;

    private final UserRolePermissionImpl userRolePermissionImpl;

    public UserServiceImpl(UserRepository UserRepository,
            UserRolePermissionImpl userRolePermissionImpl) {
        this.UserRepository = UserRepository;
        this.userRolePermissionImpl = userRolePermissionImpl;
    }

    @Override
    public User save(User User) {
        log.debug("Request to save User : {}", User);
        return UserRepository.save(User);
    }

    @Override
    public User update(User User) {
        log.debug("Request to update User : {}", User);
        return UserRepository.save(User);
    }

    @Override
    public Optional<User> partialUpdate(User User) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<User> findAll(Pageable pageable) {
        log.debug("Request to get all Users");
        return UserRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findOne(String id) {
        log.debug("Request to get User : {}", id);
        return UserRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        log.debug("Request to delete User : {}", id);
        UserRepository.deleteById(id);
    }

    @Override
    public void deActivate(String id) {
        log.debug("Request to delete User : {}", id);
        User user = UserRepository.findById(id).orElseThrow(() -> new BusinessErrorException(
                BusinessError.builder().errorCode("error.user.notFoundWithId")
                        .params(Collections.singletonList(id))
                        .build()));
        if (user.getActive() == 1L) {
            user.setActive(0L);
        } else {
            user.setActive(1L);
        }
        UserRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return UserRepository.findByUsername(username);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return UserRepository.findByUsername(email);
    }

    @Override
    public void editProfile(User request) {
        UserRepository.save(request);
    }


}
