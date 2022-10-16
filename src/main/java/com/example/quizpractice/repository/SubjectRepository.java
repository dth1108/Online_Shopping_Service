package com.example.quizpractice.repository;

import com.example.quizpractice.domain.Subject;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Subject entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SubjectRepository extends JpaRepository<Subject, String>,
        JpaSpecificationExecutor<Subject> {
    Optional<Subject> findByName(String name);
    Optional<Subject>findByCode(String code);
}
