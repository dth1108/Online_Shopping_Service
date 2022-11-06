package com.example.quizpractice.service;

import com.example.quizpractice.domain.Blog;
import com.example.quizpractice.dto.BlogDTO;
import com.example.quizpractice.dto.IBlogDTO;
import java.sql.SQLException;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link Blog}.
 */
public interface BlogService {
    /**
     * Save a blog.
     *
     * @param blog the entity to save.
     * @return the persisted entity.
     */
    Blog save(BlogDTO blogDTO) throws SQLException;

    /**
     * Updates a blog.
     *
     * @param blog the entity to update.
     * @return the persisted entity.
     */
    Blog update(String id,Blog blog);

    /**
     * Partially updates a blog.
     *
     * @param blog the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Blog> partialUpdate(Blog blog);

    /**
     * Get all the blogs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Blog> findAll(Pageable pageable);

    /**
     * Get the "id" blog.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Blog> findOne(String id);

    /**
     * Delete the "id" blog.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
