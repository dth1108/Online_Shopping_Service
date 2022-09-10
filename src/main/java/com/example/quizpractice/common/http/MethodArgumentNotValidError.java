package com.example.quizpractice.common.http;

import com.example.quizpractice.common.service.BusinessError;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class MethodArgumentNotValidError implements ICommonException {

    private MethodArgumentNotValidException exception;

    public MethodArgumentNotValidException getException() {
        return exception;
    }

    public void setException(MethodArgumentNotValidException exception) {
        this.exception = exception;
    }

    public MethodArgumentNotValidError exception(MethodArgumentNotValidException exception) {
        this.exception = exception;
        return this;
    }

    @Override
    public List<BusinessError> toErrors() {
        return exception.getBindingResult().getAllErrors().stream()
                .map(objectError -> {
                    if (objectError instanceof FieldError) {
                        FieldError objectError_ = (FieldError) objectError;
                        return new BusinessError().errorCode("error.formInvalid.fieldError")
                                .params(Arrays.asList(objectError_.getField(),
                                        objectError_.getDefaultMessage(),
                                        objectError_.getRejectedValue()));
                    } else {
                        return new BusinessError().errorCode("error.formInvalid")
                                .params(Collections.singletonList(objectError.getDefaultMessage()));
                    }
                }).collect(Collectors.toList());
    }
}
