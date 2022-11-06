package com.example.quizpractice.repository;

import com.example.quizpractice.domain.Quizt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface QuiztRepository extends JpaRepository<Quizt, String> {

    @Query(value = "SELECT *  FROM  quizt where  subjectID =  :subid  order by  ID  limit :index, :pageSize  ", nativeQuery = true)
    ArrayList<Quizt> getListQuizts(@Param("subid") String id, @Param("index") int index, @Param("pageSize") Integer pageSize);
}