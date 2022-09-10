package com.example.quizpractice.dto;

import java.util.Date;

public interface IUserDTO {

    String getId();

    String getEmail();

    String getFirstName();

    String getLastName();

    Date getBirthDate();

    Long getGender();

    String getAddress();

    Long getActive();

}
