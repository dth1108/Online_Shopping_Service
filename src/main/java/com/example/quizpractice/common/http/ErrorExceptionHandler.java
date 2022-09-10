package com.example.quizpractice.common.http;


import com.example.quizpractice.common.service.BusinessErrorException;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class ErrorExceptionHandler extends ResponseEntityExceptionHandler {

    public ErrorExceptionHandler() {
    }

    @ExceptionHandler(value = {BusinessErrorException.class})
    public ResponseEntity<Object> handleBusinessErrorException(BusinessErrorException ex,
            WebRequest webRequest) {
        return handleCommonException(ex, webRequest, "businessError");
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status,
            WebRequest webRequest) {
        return handleCommonException(new MethodArgumentNotValidError().exception(ex), webRequest,
                "formInvalid");
    }



    private ResponseEntity<Object> handleCommonException(
            ICommonException ex, WebRequest webRequest, String message) {
        String path = ((ServletWebRequest) webRequest).getRequest().getRequestURI();
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(new Date())
                .httpStatus(HttpStatus.BAD_REQUEST.value())
                .errors(ex.toErrors())
                .message(message)
                .path(path)
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
