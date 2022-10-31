package com.example.quizpractice.repository;

import com.example.quizpractice.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface QuestionRepository extends JpaRepository<Question, String> {
    @Query(value = "SELECT *  FROM  question where  quiztID =  :quizid  order by  ID  limit :index, :pageSize ", nativeQuery = true)
    ArrayList<Question> getListQuestions(@Param("quizid") String id, @Param("index") int index, @Param("pageSize") Integer pageSize);
}