package com.example.quizpractice.service.impl;

import com.example.quizpractice.domain.User;
import com.example.quizpractice.repository.UserRepository;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.RequestScope;

@Service
public class UserServiceAuth implements UserDetailsService {


    private final UserRepository userRepository;

    private final UserRolePermissionImpl userRolePermissionImpl;

    public UserServiceAuth(UserRepository userRepository,
            UserRolePermissionImpl userRolePermissionImpl) {
        this.userRepository = userRepository;
        this.userRolePermissionImpl = userRolePermissionImpl;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("NotFoundUserWithUsername"));
        Collection<? extends GrantedAuthority> authorities = userRolePermissionImpl.populateAuthorities(
                username);
        System.out.println("authorities"+ authorities);
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), authorities);
    }
}
