package com.example.quizpractice.common.service;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class BusinessError {

    private String errorCode;
    private Object params;

    public BusinessError() {
    }

    public BusinessError(String errorCode, Object params) {
        this.errorCode = errorCode;
        this.params = params;
    }

    public BusinessError(String errorCode) {
        this.errorCode = errorCode;
    }

    public BusinessError errorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public BusinessError params(Object params) {
        this.params = params;
        return this;
    }

    public BusinessError params_(Object... params) {
        this.params = params;
        return this;
    }
}
