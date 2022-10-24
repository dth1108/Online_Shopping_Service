package com.example.quizpractice.service.impl;

import com.example.quizpractice.domain.Quizt;
import com.example.quizpractice.repository.QuiztRepository;
import com.example.quizpractice.service.QuiztService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.RequestScope;

import java.util.ArrayList;

@Service
@Transactional
@RequestScope
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class QuiztImpl  implements QuiztService {

    public final QuiztRepository quiztRepository;
    @Override
    public ArrayList<Quizt> getQuiztsBySubjectid(String subid, int index, int page) {
        ArrayList<Quizt> quizts  = quiztRepository.getListQuizts(subid,(index-1)*page,page);
        return quizts;
    }

    @Override
    public void deleteQuizts(String qid) {
       quiztRepository.deleteById(qid);
    }

    @Override
    public void addQuizt(Quizt request) {
        Quizt  q = new Quizt();
        q.setCode(request.getCode());
        q.setUserId(request.getUserId());
        q.setSubjectId(request.getSubjectId());
        q.setName(request.getName());
        q.setDescription(request.getDescription());
        q.setTotalQuestions(request.getTotalQuestions());
        q.setRating(request.getRating());
        q.setDeleted(request.getDeleted());
        quiztRepository.save(q);
    }

    @Override
    public void editQuizt(Quizt request) {
        quiztRepository.save(request);
    }

    @Override
    public Quizt getQuizt(String id) {
        return quiztRepository.getOne(id);
    }
}
