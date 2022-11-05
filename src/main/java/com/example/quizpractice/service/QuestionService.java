package com.example.quizpractice.service;

import com.example.quizpractice.domain.Question;

import java.util.ArrayList;
import java.util.List;

public interface QuestionService {
    public ArrayList<Question> getListQuestion(String quizId) ;
     public List<Question> getAllQuestion();
    public void addQuestion(Question question);
    public void deleteQuestion(String qid);
    public void editQuestion( Question question);
    public Question getQuestion(String qid);
}
