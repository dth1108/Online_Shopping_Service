package com.example.quizpractice.service.queryService;


import com.example.quizpractice.domain.User;
import com.example.quizpractice.domain.UserRole;
import com.example.quizpractice.domain.User_;
import com.example.quizpractice.dto.UserDTO;
import com.example.quizpractice.repository.RoleRepository;
import com.example.quizpractice.repository.UserRepository;
import com.example.quizpractice.service.LoginService;
import com.example.quizpractice.service.UserRoleService;
import com.example.quizpractice.service.criteria.UserCriteria;
import io.github.jhipster.service.QueryService;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service for executing complex queries for {@link User} entities in the database. The main input
 * is a {@link UserCriteria} which gets converted to {@link Specification}, in a way that all the
 * filters must apply. It returns a {@link List} of {@link User} or a {@link Page} of {@link User}
 * which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class UserQueryService extends QueryService<User> {

    private final Logger log = LoggerFactory.getLogger(UserQueryService.class);

    private final com.example.quizpractice.repository.UserRepository UserRepository;

    private final LoginService loginService;

    private final ModelMapper modelMap;

    private final UserRoleService userRoleService;

    private final RoleRepository roleRepository;

    public UserQueryService(UserRepository UserRepository, LoginService loginService,
            ModelMapper modelMap, UserRoleService userRoleService, RoleRepository roleRepository) {
        this.UserRepository = UserRepository;
        this.loginService = loginService;
        this.modelMap = modelMap;
        this.userRoleService = userRoleService;
        this.roleRepository = roleRepository;
    }

    /**
     * Return a {@link List} of {@link User} which matches the criteria from the database.
     *
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<User> findByCriteria(UserCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<User> specification = createSpecification(criteria);
        return UserRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link User} which matches the criteria from the database.
     *
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page     The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<User> findByCriteria(UserCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<User> specification = createSpecification(criteria);
        Page<User> result = UserRepository.findAll(specification, page).map((user) -> (
                user.password("********")
        ));
        return result;
    }

    @Transactional(readOnly = true)
    public Page<UserDTO> findByCriteriaUserDTO(UserCriteria criteria, Pageable page) {

        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<User> specification = createSpecification(criteria);
        Page<User> result = UserRepository.findAll(specification, page).map((user) -> (
                user.password("********")
        ));
        Page<UserDTO> resultDTO = result.map((user) -> (
                modelMap.map(user, UserDTO.class)
        ));
        resultDTO.forEach((user) -> {
            Optional<UserRole> userRole = userRoleService.getFirstUserRolesByUserId(user.getId());
            user.setRoles(loginService.getRole(
                    roleRepository.findById(userRole.get().getRoleId()).get().getRoleName()));
        });
        return resultDTO;
    }

    /**
     * Return the number of matching entities in the database.
     *
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(UserCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<User> specification = createSpecification(criteria);
        return UserRepository.count(specification);
    }

    /**
     * Function to convert {@link UserCriteria} to a {@link Specification}
     *
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<User> createSpecification(UserCriteria criteria) {
        Specification<User> specification = Specification.where(null);
        if (criteria != null) {

            if (criteria.getId() != null) {
                specification = specification.and(
                        buildStringSpecification(criteria.getId(), User_.id));
            }
            if (criteria.getUsername() != null) {
                specification = specification.and(
                        buildStringSpecification(criteria.getUsername(), User_.username));
            }
            if (criteria.getPassword() != null) {
                specification = specification.and(
                        buildStringSpecification(criteria.getPassword(), User_.password));
            }
            if (criteria.getEmail() != null) {
                specification = specification.and(
                        buildStringSpecification(criteria.getEmail(), User_.email));
            }
            if (criteria.getFirstName() != null) {
                specification = specification.and(
                        buildStringSpecification(criteria.getFirstName(), User_.firstName));
            }
            if (criteria.getLastName() != null) {
                specification = specification.and(
                        buildStringSpecification(criteria.getLastName(), User_.lastName));
            }
            if (criteria.getGender() != null) {
                specification = specification.and(
                        buildRangeSpecification(criteria.getGender(), User_.gender));
            }
            if (criteria.getAddress() != null) {
                specification = specification.and(
                        buildStringSpecification(criteria.getAddress(), User_.address));
            }
            if (criteria.getActive() != null) {
                specification = specification.and(
                        buildRangeSpecification(criteria.getActive(), User_.active));
            }
        }
        return specification;
    }
}
