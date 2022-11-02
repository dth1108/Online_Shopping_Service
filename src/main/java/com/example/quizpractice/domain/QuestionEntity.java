package com.example.quizpractice.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "question", schema = "quizpractice", catalog = "")
public class QuestionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private String id;
    @Basic
    @Column(name = "quiztID")
    private String quiztId;
    @Basic
    @Column(name = "QuiztsubjectID")
    private Integer quiztsubjectId;
    @Basic
    @Column(name = "is_deleted")
    private Boolean isDeleted;
    @Basic
    @Column(name = "question_text")
    private String questionText;
    @Basic
    @Column(name = "total_answer")
    private String totalAnswer;
    @Basic
    @Column(name = "answer1")
    private String answer1;
    @Basic
    @Column(name = "answer2")
    private String answer2;
    @Basic
    @Column(name = "answer3")
    private String answer3;
    @Basic
    @Column(name = "right_answer")
    private Integer rightAnswer;

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

    public Integer getQuiztsubjectId() {
        return quiztsubjectId;
    }

    public void setQuiztsubjectId(Integer quiztsubjectId) {
        this.quiztsubjectId = quiztsubjectId;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
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

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public Integer getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(Integer rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionEntity that = (QuestionEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(quiztId, that.quiztId) && Objects.equals(quiztsubjectId, that.quiztsubjectId) && Objects.equals(isDeleted, that.isDeleted) && Objects.equals(questionText, that.questionText) && Objects.equals(totalAnswer, that.totalAnswer) && Objects.equals(answer1, that.answer1) && Objects.equals(answer2, that.answer2) && Objects.equals(answer3, that.answer3) && Objects.equals(rightAnswer, that.rightAnswer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quiztId, quiztsubjectId, isDeleted, questionText, totalAnswer, answer1, answer2, answer3, rightAnswer);
    }
}
