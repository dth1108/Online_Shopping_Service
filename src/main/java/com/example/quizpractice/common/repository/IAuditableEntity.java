package com.example.quizpractice.common.repository;

import java.util.Date;

public interface IAuditableEntity {

    Date getCreatedDate();

    void setCreatedDate(Date createdDate);

    void setCreatedBy(String createdUserId);

    String getCreatedBy();

    Date getUpdatedDate();

    void setUpdatedDate(Date updateDate);

    String getUpdatedBy();

    void setUpdatedBy(String updatedUserId);

    Long getVersion();

    void setVersion(Long version);
}
