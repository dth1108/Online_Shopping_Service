package com.example.quizpractice.common.service;

import com.example.quizpractice.common.http.ICommonException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lombok.Getter;

public class BusinessErrorException extends RuntimeException implements ICommonException {

    @Getter
    private List<BusinessError> errors;

    public BusinessErrorException() {
    }

    public BusinessErrorException(List<BusinessError> errors) {
        this.errors = errors;
    }

    public BusinessErrorException(BusinessError error) {
        this.errors = Collections.singletonList(error);
    }

    @Override
    public List<BusinessError> toErrors() {
        return errors;
    }

    public BusinessErrorException errors(BusinessError ...errors) {
        this.errors = Arrays.asList(errors);
        return this;
    }
}
