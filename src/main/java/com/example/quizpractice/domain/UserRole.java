package com.example.quizpractice.domain;

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

/**
 * A UserRole.
 */
@Entity
@Table(name = "user_role")
@SuppressWarnings("common-java:DuplicatedBlocks")
@Where(clause = "is_deleted = 0")
@EntityListeners(AuditListener.class)
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "role_id")
    private String roleId;

    @Column(name = "is_deleted")
    private Long isDeleted;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public String getId() {
        return this.id;
    }

    public UserRole id(String id) {
        this.setId(id);
        return this;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return this.userId;
    }

    public UserRole userId(String userId) {
        this.setUserId(userId);
        return this;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return this.roleId;
    }

    public UserRole roleId(String roleId) {
        this.setRoleId(roleId);
        return this;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public Long getIsDeleted() {
        return this.isDeleted;
    }

    public UserRole isDeleted(Long isDeleted) {
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
        if (!(o instanceof UserRole)) {
            return false;
        }
        return id != null && id.equals(((UserRole) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + getId() +
                ", userId='" + getUserId() + "'" +
                ", roleId='" + getRoleId() + "'" +
                ", isDeleted=" + getIsDeleted() +
                "}";
    }
}
