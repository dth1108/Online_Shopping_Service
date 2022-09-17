package com.example.quizpractice.controller;

import com.example.quizpractice.service.UserRolePermissionService;
import com.example.quizpractice.service.UserRoleService;
import java.util.List;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    private final UserRoleService userRoleService;
    private final UserRolePermissionService userRolePermissionService;

    public TestController(UserRoleService userRoleService,
            UserRolePermissionService userRolePermissionService) {
        this.userRoleService = userRoleService;
        this.userRolePermissionService = userRolePermissionService;
    }

    @GetMapping("/test")
    public String getUser() {

        return "test";
    }

    @GetMapping("/test2")
    public String getUser2() {

        return "test2";
    }
}
