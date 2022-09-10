package com.example.quizpractice.common.repository;

import java.util.Date;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AuditableEntity implements IAuditableEntity {

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    protected Date createdDate;

    @CreatedBy
    protected String createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    protected Date updatedDate;

    @LastModifiedBy
    protected String updatedBy;

    protected Long isDeleted;

    protected Long version;

    @PrePersist
    public void prePersist() {
        this.version = 1L;
        this.isDeleted = 0L;
    }

//    @PreUpdate
//    public void preUpdate() {
//        this.version = H.nvl(this.getVersion(), 0L) + 1;
//    }

    @Override
    public Date getCreatedDate() {
        return createdDate;
    }

    @Override
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String getCreatedBy() {
        return createdBy;
    }

    @Override
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public Date getUpdatedDate() {
        return updatedDate;
    }

    @Override
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String getUpdatedBy() {
        return updatedBy;
    }

    @Override
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Long getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Long isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public Long getVersion() {
        return version;
    }

    @Override
    public void setVersion(Long version) {
        this.version = version;
    }


    public AuditableEntity createdDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public AuditableEntity createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public AuditableEntity updatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
        return this;
    }

    public AuditableEntity updatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public AuditableEntity isDeleted(Long isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    public AuditableEntity version(Long version) {
        this.version = version;
        return this;
    }
}
