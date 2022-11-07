package com.example.quizpractice.service.impl;

import com.example.quizpractice.domain.Question;
import com.example.quizpractice.repository.QuestionRepository;
import com.example.quizpractice.service.QuestionService;
import com.example.quizpractice.service.model.AnswerRespone;
import com.example.quizpractice.service.model.GetAnswerRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class QuestionImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Override
    public ArrayList<Question> getListQuestion(String quizId) {
        ArrayList<Question> questions = questionRepository.getListQuestions(quizId);
        return questions;
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

    @Override
    public ArrayList<AnswerRespone> getAnswerRespone(String quizId, ArrayList<GetAnswerRequest> requests) {
        ArrayList<Question> questions = questionRepository.getListQuestions(quizId);
        ArrayList<AnswerRespone> respones = new ArrayList<>();
        for (int i = 0; i < questions.size(); i++) {

            AnswerRespone answerRespone = new AnswerRespone();
            answerRespone.setQuestid(questions.get(i).getId());
            answerRespone.setYourAnswer(requests.get(i).getAnswer());
            answerRespone.setCorrectAnswer(questions.get(i).getRightAnswer());
            if (requests.get(i).getAnswer().equals(questions.get(i).getRightAnswer())) {
                answerRespone.setCorrect(true);
            }else {
                answerRespone.setCorrect(false);
            }
            respones.add(answerRespone);
        }
        return respones;
    }


}
