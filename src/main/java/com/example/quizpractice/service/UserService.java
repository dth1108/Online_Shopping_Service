package com.example.quizpractice.service;

import com.example.quizpractice.domain.User;
import com.example.quizpractice.dto.UserDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link User}.
 */
public interface UserService {


    /**
     * Save a User.
     *
     * @param User the entity to save.
     * @return the persisted entity.
     */
    User save(User User);

    /**
     * Updates a User.
     *
     * @param User the entity to update.
     * @return the persisted entity.
     */
    User update(User User);

    /**
     * Partially updates a User.
     *
     * @param User the entity to update partially.
     * @return the persisted entity.
     */
    Optional<User> partialUpdate(User User);

    /**
     * Get all the Users.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<User> findAll(Pageable pageable);

    /**
     * Get the "id" User.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<User> findOne(String id);

    /**
     * Delete the "id" User.
     *
     * @param id the id of the entity.
     */
    void delete(String id);

    void deActive(String id);

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);


}
