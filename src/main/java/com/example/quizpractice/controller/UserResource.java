package com.example.quizpractice.controller;


import com.example.quizpractice.domain.User;
import com.example.quizpractice.dto.UserDTO;
import com.example.quizpractice.dto.UserRegisterDTO;
import com.example.quizpractice.service.UserRegisterService;
import com.example.quizpractice.service.UserUpdateService;
import com.example.quizpractice.service.criteria.UserCriteria;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

    private final com.example.quizpractice.service.UserQueryService UserQueryService;

    public UserResource(com.example.quizpractice.service.UserService userService,
            UserRegisterService userRegisterService, UserUpdateService userUpdateService,
            com.example.quizpractice.service.UserService userService1,
            com.example.quizpractice.repository.UserRepository userRepository,
            com.example.quizpractice.service.UserQueryService userQueryService) {
        UserService = userService;
        this.userRegisterService = userRegisterService;
        this.userUpdateService = userUpdateService;
        this.userService = userService1;
        UserRepository = userRepository;
        UserQueryService = userQueryService;
    }


    @GetMapping("/user")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<User>> getAllUsers(
            UserCriteria criteria,
            @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get Users by criteria: {}", criteria);
        Page<User> page = UserQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(
                ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }


    @PostMapping("/user/register")
    @CrossOrigin(origins = "*")
    public ResponseEntity<UserRegisterDTO> createUser(
            @Valid @RequestBody UserRegisterDTO UserRegisterDTO)
            throws URISyntaxException {

        UserRegisterDTO result = userRegisterService.save(UserRegisterDTO);

        return ResponseEntity
                .created(new URI("/api/user/register" + "unknow"))
                .headers(
                        HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME,
                                "unknow"))
                .body(result);
    }

    @PutMapping("/user/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<UserDTO> updateUser(
            @PathVariable(value = "id", required = false) final String id,
            @RequestBody UserDTO UserDTO)
            throws URISyntaxException {

        UserDTO result = userUpdateService.save(id, UserDTO);
        return ResponseEntity
                .ok()
                .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME,
                        UserDTO.getId().toString()))
                .body(result);
    }

    @GetMapping("/user/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        log.debug("REST request to get User1 : {}", id);
        Optional<User> user = userService.findOne(id).map((x) -> (x.password("******")));
        return ResponseUtil.wrapOrNotFound(user);
    }

    @DeleteMapping("/user/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Void> deActiveUser(@PathVariable String id) {
        log.debug("REST request to delete User1 : {}", id);
        userService.deActivate(id);
        return ResponseEntity
                .noContent()
                .headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME,
                        id.toString()))
                .build();
    }

}
