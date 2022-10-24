package com.example.quizpractice.service;

import com.example.quizpractice.domain.Quizt;

import java.util.ArrayList;

public interface QuiztService {
    public ArrayList<Quizt> getQuiztsBySubjectid(String subid, int index, int pagesize);
    public void deleteQuizts(String qid);
    public void addQuizt(Quizt request);
    public void editQuizt(Quizt request);
    public Quizt getQuizt(String id);
}
