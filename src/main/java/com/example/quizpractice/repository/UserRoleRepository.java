package com.example.quizpractice.repository;

import com.example.quizpractice.domain.User;
import com.example.quizpractice.domain.UserRole;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the User entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, String>,
        JpaSpecificationExecutor<UserRole> {

    Optional<UserRole> findByUserId(String id);

    List<UserRole> findAllByUserId(String id);


}
