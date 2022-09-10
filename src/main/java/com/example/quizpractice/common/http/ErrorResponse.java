package com.example.quizpractice.common.http;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class ErrorResponse {

    private Date timestamp;
    private Integer httpStatus;
    private Object errors;
    private String message;
    private String path;
}
