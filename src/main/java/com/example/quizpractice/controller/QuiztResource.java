package com.example.quizpractice.controller;

import com.example.quizpractice.domain.Quizt;
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
public class QuiztResource {
    private final Logger log = LoggerFactory.getLogger(ImageResource.class);

    private final QuiztService quiztService;
    @GetMapping("/getlistquizts")
    public ResponseEntity<?> getListQuizts(@RequestParam("subid") String subid,@RequestParam("index") int index ,@RequestParam("pageSize") int pageSize){
        try {
            System.out.println(subid);
            ArrayList<Quizt> quizts = quiztService.getQuiztsBySubjectid(subid,index,pageSize);
            return  ResponseEntity.ok().body(quizts);
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @DeleteMapping("/deletequizt/{qid}")
    public ResponseEntity<?> deleteQuizts( @PathVariable("qid") String qid){
        try {
            quiztService.deleteQuizts(qid);
            return  ResponseEntity.ok().build();
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/getquizt/{qid}")
    public ResponseEntity<?> getQuizt(@PathVariable("qid") String qid){
        try {
            Quizt q = quiztService.getQuizt(qid);
            System.out.println(q.getCode());
            return  ResponseEntity.ok().body(q);
        }catch (Exception e){
            System.out.println(e);
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PostMapping("/addquizt")
    public ResponseEntity<?> addQuizt(@RequestBody Quizt request){
        try {
           quiztService.addQuizt(request);
            System.out.println(request.toString());
            return  ResponseEntity.ok().build();
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PostMapping("/editquizt")
    public ResponseEntity<?> editQuizt(@RequestBody Quizt request){
        try {
            quiztService.editQuizt(request);
            System.out.println(request.toString());

            return  ResponseEntity.ok().build();
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
