package com.example.quizpractice.dto;

import java.util.Date;
import lombok.Data;

@Data
public class UserDTO implements IUserDTO {

    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private Long gender;
    private String address;
    private Long active;
    private String roles;
}
