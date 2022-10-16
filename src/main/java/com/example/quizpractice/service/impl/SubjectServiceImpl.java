package com.example.quizpractice.service.impl;


import com.example.quizpractice.common.service.BusinessError;
import com.example.quizpractice.common.service.BusinessErrorException;
import com.example.quizpractice.domain.User;
import com.example.quizpractice.repository.SubjectRepository;
import com.example.quizpractice.repository.UserRepository;
import com.example.quizpractice.service.SubjectService;
import java.util.Collections;
import java.util.Optional;

import com.example.quizpractice.domain.Subject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Subject}.
 */
@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {

    private final Logger log = LoggerFactory.getLogger(SubjectServiceImpl.class);

    private final SubjectRepository subjectRepository;
    private final UserRepository userRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository, UserRepository userRepository) {
        this.subjectRepository = subjectRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Subject save(Subject subject, String userName) {
        validationCommon(subject);
        User user = userRepository.findByUsername(userName).get();
        subject.userId(user.getId());
        subject.isDeleted(0L);
        return subjectRepository.save(subject);
    }

    @Override
    public Subject update(String id, Subject subject, String username) {
        Subject subjectRoot = subjectRepository.findById(id)
                .orElseThrow(() -> new BusinessErrorException(
                        BusinessError.builder().errorCode("error.subject.notFoundWithId")
                                .params(Collections.singletonList(id))
                                .build()));
        validationCommon(subject);
        User user = userRepository.findByUsername(username).get();
        subjectRoot.userId(user.getId()).code(subject.getCode()).name(subject.getName())
                .description(subject.getDescription()).isDeleted(0L);
        return subjectRepository.save(subjectRoot);
    }

    @Override
    public Optional<Subject> partialUpdate(Subject subject) {
        log.debug("Request to partially update Subject : {}", subject);

        return subjectRepository
                .findById(subject.getId())
                .map(existingSubject -> {
                    if (subject.getUserId() != null) {
                        existingSubject.setUserId(subject.getUserId());
                    }
                    if (subject.getCode() != null) {
                        existingSubject.setCode(subject.getCode());
                    }
                    if (subject.getName() != null) {
                        existingSubject.setName(subject.getName());
                    }
                    if (subject.getDescription() != null) {
                        existingSubject.setDescription(subject.getDescription());
                    }
                    if (subject.getIsDeleted() != null) {
                        existingSubject.setIsDeleted(subject.getIsDeleted());
                    }

                    return existingSubject;
                })
                .map(subjectRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Subject> findAll(Pageable pageable) {
        log.debug("Request to get all Subjects");
        return subjectRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Subject> findOne(String id) {
        log.debug("Request to get Subject : {}", id);
        return subjectRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new BusinessErrorException(
                        BusinessError.builder().errorCode("error.subject.notFoundWithId")
                                .params(Collections.singletonList(id))
                                .build()));
        subject.isDeleted(1L);
        subjectRepository.save(subject);
    }

    @Override
    public void validationCommon(Subject subject) {
        if (subjectRepository.findByCode(subject.getCode()).isPresent()) {
            throw new BusinessErrorException(
                    BusinessError.builder().errorCode("error.user.codeAlreadyExisted")
                            .params(Collections.singletonList(subject.getCode()))
                            .build());
        }

    }
}
