package com.example.quizpractice.controller;

import com.example.quizpractice.domain.Quizt;
import com.example.quizpractice.service.QuestionService;
import com.example.quizpractice.service.QuiztService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class QuestionResource {
    private final Logger log = LoggerFactory.getLogger(ImageResource.class);

    private final QuiztService quiztService;
    private final QuestionService questionService;


    @GetMapping("/getlistquestion")
    public ResponseEntity<?> getListQuestion(@RequestParam("quizId") String quizId, @RequestParam("index") int index , @RequestParam("pageSize") int pageSize){
        try {
            System.out.println(quizId);
            ArrayList<Quizt> quizts = quiztService.getQuiztsBySubjectid(quizId,index,pageSize);
            return  ResponseEntity.ok().body(quizts);
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @DeleteMapping("/deletequestion/{qid}")
    public ResponseEntity<?> deleteQuestion( @PathVariable("qid") String qid){
        try {
            quiztService.deleteQuizts(qid);
            return  ResponseEntity.ok().build();
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/getquestion/{qid}")
    public ResponseEntity<?> getQuestion(@PathVariable("qid") String qid){
        try {
            Quizt q = quiztService.getQuizt(qid);
            System.out.println(q.getCode());
            return  ResponseEntity.ok().body(q);
        }catch (Exception e){
            System.out.println(e);
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PostMapping("/addquestion")
    public ResponseEntity<?> addQuestion(@RequestBody Quizt request){
        try {
            quiztService.addQuizt(request);
            System.out.println(request.toString());
            return  ResponseEntity.ok().build();
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PostMapping("/editquestion")
    public ResponseEntity<?> editQuestion(@RequestBody Quizt request){
        try {
            quiztService.editQuizt(request);
            System.out.println(request.toString());

            return  ResponseEntity.ok().build();
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
