package com.example.quizpractice.service;

import com.example.quizpractice.domain.Quizt;

import java.util.ArrayList;
import java.util.List;

public interface QuiztService {
    public ArrayList<Quizt> getQuiztsBySubjectid(String subid, int index, int pagesize);
    public List<Quizt> getAllQuizts();
    public void deleteQuizts(String qid);
    public void addQuizt(Quizt request);
    public void editQuizt(Quizt request);
    public Quizt getQuizt(String id);
}
