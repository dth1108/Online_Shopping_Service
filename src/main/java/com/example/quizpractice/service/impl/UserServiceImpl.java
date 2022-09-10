package com.example.quizpractice.service.impl;

import com.example.quizpractice.common.service.BusinessError;
import com.example.quizpractice.common.service.BusinessErrorException;
import com.example.quizpractice.domain.User;
import com.example.quizpractice.dto.UserDTO;
import com.example.quizpractice.repository.UserRepository;
import com.example.quizpractice.service.UserService;

import java.util.Collections;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public UserServiceImpl(UserRepository UserRepository) {
        this.UserRepository = UserRepository;
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
        log.debug("Request to partially update User : {}", User);

        return UserRepository
                .findById(User.getId())
                .map(existingUser -> {
                    if (User.getUsername() != null) {
                        existingUser.setUsername(User.getUsername());
                    }
                    if (User.getPassword() != null) {
                        existingUser.setPassword(User.getPassword());
                    }
                    if (User.getEmail() != null) {
                        existingUser.setEmail(User.getEmail());
                    }
                    if (User.getFirstName() != null) {
                        existingUser.setFirstName(User.getFirstName());
                    }
                    if (User.getLastName() != null) {
                        existingUser.setLastName(User.getLastName());
                    }
                    if (User.getBirthDate() != null) {
                        existingUser.setBirthDate(User.getBirthDate());
                    }
                    if (User.getGender() != null) {
                        existingUser.setGender(User.getGender());
                    }
                    if (User.getAddress() != null) {
                        existingUser.setAddress(User.getAddress());
                    }
                    if (User.getActive() != null) {
                        existingUser.setActive(User.getActive());
                    }

                    return existingUser;
                })
                .map(UserRepository::save);
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
        UserRepository.save(user.active(0L));
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return UserRepository.findByUsername(username);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return UserRepository.findByUsername(email);
    }

}
