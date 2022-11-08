package com.example.quizpractice.service.impl;

import com.example.quizpractice.common.service.BusinessError;
import com.example.quizpractice.common.service.BusinessErrorException;
import com.example.quizpractice.common.sso.payload.LoginRequest;
import com.example.quizpractice.domain.User;
import com.example.quizpractice.dto.UserDTO;
import com.example.quizpractice.service.UserService;
import com.example.quizpractice.service.UserUpdateService;
import java.util.Collections;
import java.util.Optional;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.RequestScope;

@Service
@Transactional
@RequestScope
public class UserUpdateServiceImpl implements UserUpdateService {

    private final UserService userService;

    public UserUpdateServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDTO save(String id, UserDTO userDTO) {
        validationCommon(id, userDTO);
        User user = userService.findOne(id).get();
        user
                .email(userDTO.getEmail())
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .birthDate(userDTO.getBirthDate())
                .gender(userDTO.getGender())
                .address(userDTO.getAddress());
        userService.update(user);
        userDTO.setId(id);
        return userDTO;
    }

    @Override
    public User myProfile(String username) {
        Optional<User> user = userService.findByUsername(username);
        return user.get();
    }

    @Override
    public void changePassword(String username, String oldPassword, String newPassword) {
        Optional<User> user = userService.findByUsername(username);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (passwordEncoder.matches(oldPassword, user.get().getPassword())) {
            user.get().setPassword(passwordEncoder.encode(newPassword));
            userService.save(user.get());
        } else {
            throw new BusinessErrorException(
                    BusinessError.builder().errorCode("error.user.passwordIsNotCorrect")
                            .params(Collections.singletonList(""))
                            .build());
        }
    }

    @Override
    public void verify(LoginRequest loginRequest) {
        Optional<User> user = userService.findByUsername(loginRequest.getUsername());
        if (user.get().getActive() == 0L) {
            throw new BusinessErrorException(
                    BusinessError.builder().errorCode("error.user.hasBeenBanned")
                            .params(Collections.singletonList(loginRequest.getUsername()))
                            .build());
        }
    }

    @Override
    public void validationCommon(String id, UserDTO UserDTO) {
        if (userService.findByEmail(UserDTO.getEmail()).isPresent()) {
            throw new BusinessErrorException(
                    BusinessError.builder().errorCode("error.user.emailAlreadyExisted")
                            .params(Collections.singletonList(UserDTO.getEmail()))
                            .build());
        }
        if (UserDTO.getGender() != 0 && UserDTO.getGender() != 1) {
            throw new BusinessErrorException(
                    BusinessError.builder().errorCode("error.user.incorrectGender")
                            .params(Collections.singletonList(UserDTO.getGender()))
                            .build());
        }
        userService.findOne(id).orElseThrow(() -> new BusinessErrorException(
                BusinessError.builder().errorCode("error.user.notFoundWithId")
                        .params(Collections.singletonList(id))
                        .build()));
    }
}
