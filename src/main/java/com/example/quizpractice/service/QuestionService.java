package com.example.quizpractice.service;

import com.example.quizpractice.domain.Question;

import java.util.ArrayList;

public interface QuestionService {
    public ArrayList<Question> getListQuestion(String quizId,int index, int pageSize) ;
    public void addQuestion(Question question);
    public void deleteQuestion(String qid);
    public void editQuestion( Question question);
    public Question getQuestion(String qid);
}
