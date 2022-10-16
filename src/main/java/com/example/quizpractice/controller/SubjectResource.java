package com.example.quizpractice.controller;


import com.example.quizpractice.domain.Subject;
import com.example.quizpractice.repository.SubjectRepository;
import com.example.quizpractice.service.SubjectService;
import com.example.quizpractice.service.criteria.SubjectCriteria;
import com.example.quizpractice.service.queryService.SubjectQueryService;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api")
public class SubjectResource {

    private final Logger log = LoggerFactory.getLogger(SubjectResource.class);

    private static final String ENTITY_NAME = "subject";

    @Value("${quizPractice.clientApp.name}")
    private String applicationName;

    private final SubjectService subjectService;

    private final SubjectRepository subjectRepository;

    private final SubjectQueryService subjectQueryService;

    public SubjectResource(SubjectService subjectService, SubjectRepository subjectRepository, SubjectQueryService subjectQueryService) {
        this.subjectService = subjectService;
        this.subjectRepository = subjectRepository;
        this.subjectQueryService = subjectQueryService;
    }

    /**
     * {@code POST  /subjects} : Create a new subject.
     *
     * @param subject the subject to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new subject, or with status {@code 400 (Bad Request)} if the subject has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/subjects")
    public ResponseEntity<Subject> createSubject(@RequestBody Subject subject) throws URISyntaxException {
        String username =SecurityContextHolder.getContext().getAuthentication().getName();
        Subject result = subjectService.save(subject,username);
        return ResponseEntity
            .created(new URI("/api/subjects/" + result.getId()))
            .headers(
                    HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /subjects/:id} : Updates an existing subject.
     *
     * @param id the id of the subject to save.
     * @param subject the subject to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated subject,
     * or with status {@code 400 (Bad Request)} if the subject is not valid,
     * or with status {@code 500 (Internal Server Error)} if the subject couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/subjects/{id}")
    public ResponseEntity<Subject> updateSubject(@PathVariable(value = "id", required = false) final String id, @RequestBody Subject subject)
        throws URISyntaxException {
        String username =SecurityContextHolder.getContext().getAuthentication().getName();
        Subject result = subjectService.update(id,subject,username);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, subject.getId().toString()))
            .body(result);
    }



    /**
     * {@code GET  /subjects} : get all the subjects.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of subjects in body.
     */
    @GetMapping("/subjects")
    public ResponseEntity<List<Subject>> getAllSubjects(
        SubjectCriteria criteria,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        Page<Subject> page = subjectQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }


    @GetMapping("/subjects/{id}")
    public ResponseEntity<Subject> getSubject(@PathVariable String id) {
        log.debug("REST request to get Subject : {}", id);
        Optional<Subject> subject = subjectService.findOne(id);
        return ResponseUtil.wrapOrNotFound(subject);
    }

    /**
     * {@code DELETE  /subjects/:id} : delete the "id" subject.
     *
     * @param id the id of the subject to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/subjects/{id}")
    public ResponseEntity<Void> deleteSubject(@PathVariable String id) {
        log.debug("REST request to delete Subject : {}", id);
        subjectService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString()))
            .build();
    }
}
