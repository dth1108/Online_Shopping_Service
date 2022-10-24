package com.example.quizpractice.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "quizt", schema = "quizpractice", catalog = "")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Quizt {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID")
    private String id;
    @Basic
    @Column(name = "userID")
    private String userId;
    @Basic
    @Column(name = "subjectID")
    private String subjectId;
    @Basic
    @Column(name = "code")
    private String code;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "total_questions")
    private Integer totalQuestions;
    @Basic
    @Column(name = "rating")
    private Double rating;
    @Basic
    @Column(name = "is_deleted")
    private Boolean isDeleted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(Integer totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quizt that = (Quizt) o;
        return Objects.equals(id, that.id) && Objects.equals(userId, that.userId) && Objects.equals(subjectId, that.subjectId) && Objects.equals(code, that.code) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(totalQuestions, that.totalQuestions) && Objects.equals(rating, that.rating) && Objects.equals(isDeleted, that.isDeleted);
    }

    @Override
    public String toString() {
        return "Quizt{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", subjectId='" + subjectId + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", totalQuestions=" + totalQuestions +
                ", rating=" + rating +
                ", isDeleted=" + isDeleted +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, subjectId, code, name, description, totalQuestions, rating, isDeleted);
    }
}
