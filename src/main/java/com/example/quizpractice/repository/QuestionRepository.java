package com.example.quizpractice.repository;

import com.example.quizpractice.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, String> {

}