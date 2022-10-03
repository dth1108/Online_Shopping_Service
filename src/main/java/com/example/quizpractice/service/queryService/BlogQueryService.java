package com.example.quizpractice.service.queryService;

import com.example.quizpractice.domain.Blog;
import com.example.quizpractice.domain.Blog_;
import com.example.quizpractice.repository.BlogRepository;
import com.example.quizpractice.service.criteria.BlogCriteria;
import io.github.jhipster.service.QueryService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
public class BlogQueryService extends QueryService<Blog> {

    private final Logger log = LoggerFactory.getLogger(BlogQueryService.class);

    private final BlogRepository blogRepository;

    public BlogQueryService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    /**
     * Return a {@link List} of {@link Blog} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<Blog> findByCriteria(BlogCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Blog> specification = createSpecification(criteria);
        return blogRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link Blog} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<Blog> findByCriteria(BlogCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Blog> specification = createSpecification(criteria);
        return blogRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(BlogCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Blog> specification = createSpecification(criteria);
        return blogRepository.count(specification);
    }

    /**
     * Function to convert {@link BlogCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Blog> createSpecification(BlogCriteria criteria) {
        Specification<Blog> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null

            if (criteria.getId() != null) {
                specification = specification.and(buildStringSpecification(criteria.getId(), Blog_.id));
            }
            if (criteria.getTitle() != null) {
                specification = specification.and(buildStringSpecification(criteria.getTitle(), Blog_.title));
            }
            if (criteria.getAuthorID() != null) {
                specification = specification.and(buildStringSpecification(criteria.getAuthorID(), Blog_.authorID));
            }
            if (criteria.getContentText() != null) {
                specification = specification.and(buildStringSpecification(criteria.getContentText(), Blog_.contentText));
            }
            if (criteria.getImageID() != null) {
                specification = specification.and(buildStringSpecification(criteria.getImageID(), Blog_.imageID));
            }
        }
        return specification;
    }
}
