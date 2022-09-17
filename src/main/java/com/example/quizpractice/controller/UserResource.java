package com.example.quizpractice.controller;


import com.example.quizpractice.common.service.BusinessError;
import com.example.quizpractice.common.service.BusinessErrorException;
import com.example.quizpractice.common.sso.jwt.JwtTokenProvider;
import com.example.quizpractice.common.sso.payload.LoginRequest;
import com.example.quizpractice.common.sso.payload.LoginResponse;
import com.example.quizpractice.domain.User;
import com.example.quizpractice.dto.UserDTO;
import com.example.quizpractice.dto.UserRegisterDTO;
import com.example.quizpractice.service.LoginService;
import com.example.quizpractice.service.UserRegisterService;
import com.example.quizpractice.service.UserUpdateService;
import com.example.quizpractice.service.criteria.UserCriteria;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api")
public class UserResource {

    private final Logger log = LoggerFactory.getLogger(UserResource.class);

    private static final String ENTITY_NAME = "User";

    @Value("${quizPractice.clientApp.name}")
    private String applicationName;

    private final com.example.quizpractice.service.UserService UserService;

    private final UserRegisterService userRegisterService;

    private final UserUpdateService userUpdateService;

    private final com.example.quizpractice.service.UserService userService;
    ;
    private final com.example.quizpractice.repository.UserRepository UserRepository;

    private final org.springframework.security.authentication.AuthenticationManager authenticationManager;

    private final com.example.quizpractice.service.queryService.UserQueryService UserQueryService;

    private final JwtTokenProvider jwtTokenProvider;
    private final LoginService loginService;

    public UserResource(com.example.quizpractice.service.UserService userService,
            UserRegisterService userRegisterService, UserUpdateService userUpdateService,
            com.example.quizpractice.service.UserService userService1,
            com.example.quizpractice.repository.UserRepository userRepository,
            AuthenticationManager authenticationManager,
            com.example.quizpractice.service.queryService.UserQueryService userQueryService,
            JwtTokenProvider jwtTokenProvider, LoginService loginService) {
        UserService = userService;
        this.userRegisterService = userRegisterService;
        this.userUpdateService = userUpdateService;
        this.userService = userService1;
        UserRepository = userRepository;
        this.authenticationManager = authenticationManager;
        UserQueryService = userQueryService;
        this.jwtTokenProvider = jwtTokenProvider;
        this.loginService = loginService;
    }


    @GetMapping("/user")
//    @CrossOrigin(origins = "*")
    public ResponseEntity<List<UserDTO>> getAllUsers(UserCriteria criteria,
            @org.springdoc.api.annotations.ParameterObject Pageable pageable) {
        log.debug("REST request to get Users by criteria: {}", criteria);
        Page<UserDTO> page = UserQueryService.findByCriteriaUserDTO(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(
                ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }


    @PostMapping("/user/register")
//    @CrossOrigin(origins = "*")
    public ResponseEntity<UserRegisterDTO> createUser(
            @Valid @RequestBody UserRegisterDTO UserRegisterDTO) throws URISyntaxException {

        UserRegisterDTO result = userRegisterService.save(UserRegisterDTO);

        return ResponseEntity.created(new URI("/api/user/register" + "unknow")).headers(
                        HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, "unknow"))
                .body(result);
    }

    @PutMapping("/user/{id}")
//    @CrossOrigin(origins = "*")
    public ResponseEntity<UserDTO> updateUser(
            @PathVariable(value = "id", required = false) final String id,
            @RequestBody UserDTO UserDTO) throws URISyntaxException {

        UserDTO result = userUpdateService.save(id, UserDTO);
        return ResponseEntity.ok().headers(
                HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME,
                        UserDTO.getId().toString())).body(result);
    }

    @GetMapping("/user/{id}")
//    @CrossOrigin(origins = "*")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        log.debug("REST request to get User1 : {}", id);
        Optional<User> user = userService.findOne(id).map((x) -> (x.password("******")));
        return ResponseUtil.wrapOrNotFound(user);
    }

    @DeleteMapping("/user/{id}")
//    @CrossOrigin(origins = "*")
    public ResponseEntity<Void> deActiveUser(@PathVariable String id) {
        log.debug("REST request to delete User1 : {}", id);
        userService.deActivate(id);
        return ResponseEntity.noContent().headers(
                HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME,
                        id.toString())).build();
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticateUser(
            @Valid @RequestBody LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtTokenProvider.generateToken(authentication);
            return ResponseEntity.ok(
                    new LoginResponse(jwt, loginService.getRole(loginRequest.getUsername())));
        } catch (AuthenticationException e) {
            log.error("loi"+e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }


}
