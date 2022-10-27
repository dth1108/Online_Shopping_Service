package com.example.quizpractice.service.impl;

import com.example.quizpractice.domain.Question;
import com.example.quizpractice.service.QuestionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.RequestScope;

import java.util.ArrayList;
@Service
@Transactional
public class QuestionImpl implements QuestionService {


    @Override
    public ArrayList<Question> getListQuestion(String quizId, int index, int pageSize) {

        return null;
    }

    @Override
    public void addQuestion(Question question) {

    }

    @Override
    public void deleteQuestion(String qid) {

    }

    @Override
    public void editQuestion(Question question) {

    }


    @Override
    public Question getQuestion(String qid) {
        return null;
    }
}
