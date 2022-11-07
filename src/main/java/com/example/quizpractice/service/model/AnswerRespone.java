package com.example.quizpractice.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnswerRespone {
    String questid;
    String yourAnswer;
    String correctAnswer;
    boolean isCorrect;


}
