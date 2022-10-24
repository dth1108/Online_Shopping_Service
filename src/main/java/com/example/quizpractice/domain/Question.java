package com.example.quizpractice.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "question", schema = "quizpractice", catalog = "")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Question {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID")
    private String id;
    @Basic
    @Column(name = "quiztID")
    private String quiztId;
    @Basic
    @Column(name = "questionText")
    private String questionText;
    @Basic
    @Column(name = "totalAnswer")
    private String totalAnswer;
    @Basic
    @Column(name = "isDeleted")
    private Boolean isDeleted;
    @Basic
    @Column(name = "QuiztsubjectID")
    private Integer quiztsubjectId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuiztId() {
        return quiztId;
    }

    public void setQuiztId(String quiztId) {
        this.quiztId = quiztId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getTotalAnswer() {
        return totalAnswer;
    }

    public void setTotalAnswer(String totalAnswer) {
        this.totalAnswer = totalAnswer;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Integer getQuiztsubjectId() {
        return quiztsubjectId;
    }

    public void setQuiztsubjectId(Integer quiztsubjectId) {
        this.quiztsubjectId = quiztsubjectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question that = (Question) o;
        return Objects.equals(id, that.id) && Objects.equals(quiztId, that.quiztId) && Objects.equals(questionText, that.questionText) && Objects.equals(totalAnswer, that.totalAnswer) && Objects.equals(isDeleted, that.isDeleted) && Objects.equals(quiztsubjectId, that.quiztsubjectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quiztId, questionText, totalAnswer, isDeleted, quiztsubjectId);
    }
}
