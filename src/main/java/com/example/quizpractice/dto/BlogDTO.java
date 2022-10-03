package com.example.quizpractice.dto;

import java.util.Date;
import lombok.Data;

@Data
public class BlogDTO implements IBlogDTO{

    private String id;

    private String title;

    private String contentText;

    private String imageBase64;
}
