package com.example.quizpractice.service;

import com.example.quizpractice.domain.Question;

import java.util.ArrayList;

public interface QuestionService {
    public ArrayList<Question> getListQuestion(String quizId,int index, int pageSize) ;
    public void addQuestion();
    public void deleteQuestion();
    public void editQuestion();
    public Question getQuestion(String qid);
}
