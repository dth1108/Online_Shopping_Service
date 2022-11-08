package com.example.quizpractice.domain;

import com.example.quizpractice.common.repository.AuditableEntity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;
import org.springframework.boot.actuate.audit.listener.AuditListener;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * A Subject.
 */
@Entity
@Table(name = "subject")
@Where(clause = "is_deleted = 0")
@EntityListeners(AuditListener.class)


@SuppressWarnings("common-java:DuplicatedBlocks")
public class Subject
        extends AuditableEntity
        implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "is_deleted")
    private Long isDeleted;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public String getId() {
        return this.id;
    }

    public Subject id(String id) {
        this.setId(id);
        return this;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return this.userId;
    }

    public Subject userId(String userId) {
        this.setUserId(userId);
        return this;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCode() {
        return this.code;
    }

    public Subject code(String code) {
        this.setCode(code);
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public Subject name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public Subject description(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getIsDeleted() {
        return this.isDeleted;
    }

    public Subject isDeleted(Long isDeleted) {
        this.setIsDeleted(isDeleted);
        return this;
    }

    public void setIsDeleted(Long isDeleted) {
        this.isDeleted = isDeleted;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Subject)) {
            return false;
        }
        return id != null && id.equals(((Subject) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Subject{" +
            "id=" + getId() +
            ", userId='" + getUserId() + "'" +
            ", code='" + getCode() + "'" +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", isDeleted=" + getIsDeleted() +
            "}";
    }
}
