package com.example.quizpractice.service.impl;


import com.example.quizpractice.common.service.BusinessError;
import com.example.quizpractice.common.service.BusinessErrorException;
import com.example.quizpractice.domain.User;
import com.example.quizpractice.dto.UserRegisterDTO;
import com.example.quizpractice.service.UserRegisterService;
import com.example.quizpractice.service.UserRoleService;
import com.example.quizpractice.service.UserService;
import java.util.Collections;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.RequestScope;

@Service
@Transactional
@RequestScope
public class UserRegisterImpl implements UserRegisterService {

    private final UserService userService;

    private final UserRoleService userRoleService;

    public UserRegisterImpl(UserService userService, UserRoleService userRoleService) {
        this.userService = userService;
        this.userRoleService = userRoleService;
    }


    @Override
    public UserRegisterDTO save(UserRegisterDTO userRegisterDTO) {
        validationCommon(userRegisterDTO);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User user = new User();
        user.username(userRegisterDTO.getUsername())
                .password(passwordEncoder.encode(userRegisterDTO.getPassword()))
                .email(userRegisterDTO.getEmail())
                .firstName(userRegisterDTO.getFirstName())
                .lastName(userRegisterDTO.getLastName())
                .active(1L)
        ;

        userService.save(user);
        userRegisterDTO.setPassword("*******");

        userRegisterDTO.setId(
                userService.findByUsername(userRegisterDTO.getUsername()).get().getId());

        userRoleService.setRoleDefaultByUserId(userRegisterDTO.getId());

        return userRegisterDTO;
    }


    @Override
    public void validationCommon(UserRegisterDTO userRegisterDTO) {
        if (userService.findByUsername(userRegisterDTO.getUsername()).isPresent()) {
            throw new BusinessErrorException(
                    BusinessError.builder().errorCode("error.user.usernameAlreadyExisted")
                            .params(Collections.singletonList(userRegisterDTO.getUsername()))
                            .build());
        }
        if (userService.findByEmail(userRegisterDTO.getEmail()).isPresent()) {
            throw new BusinessErrorException(
                    BusinessError.builder().errorCode("error.user.emailAlreadyExisted")
                            .params(Collections.singletonList(userRegisterDTO.getEmail()))
                            .build());
        }

    }
}

