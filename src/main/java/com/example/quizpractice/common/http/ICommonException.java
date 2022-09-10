package com.example.quizpractice.common.http;

import com.example.quizpractice.common.service.BusinessError;
import java.util.List;

public interface ICommonException {

    List<BusinessError> toErrors();
}
