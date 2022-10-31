package com.example.quizpractice.service.impl;

import com.example.quizpractice.domain.Question;
import com.example.quizpractice.repository.QuestionRepository;
import com.example.quizpractice.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.RequestScope;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class QuestionImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Override
    public ArrayList<Question> getListQuestion(String quizId, int index, int pageSize) {
        ArrayList<Question> questions = questionRepository.getListQuestions(quizId,index,pageSize);
        return null;
    }

    @Override
    public List<Question> getAllQuestion() {

        return questionRepository.findAll();
    }

    @Override
    public void addQuestion(Question question) {
        questionRepository.save(question);
    }

    @Override
    public void deleteQuestion(String qid) {
    questionRepository.deleteById(qid);
    }

    @Override
    public void editQuestion(Question question) {
        questionRepository.save(question);
    }


    @Override
    public Question getQuestion(String qid) {
        return questionRepository.getOne(qid);
    }
}
