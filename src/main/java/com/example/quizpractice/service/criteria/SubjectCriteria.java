package com.example.quizpractice.service.criteria;

import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;



@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class SubjectCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private StringFilter id;

    private StringFilter userId;

    private StringFilter code;

    private StringFilter name;

    private StringFilter description;

    private LongFilter isDeleted;

    private Boolean distinct;

    public SubjectCriteria() {}

    public SubjectCriteria(SubjectCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.userId = other.userId == null ? null : other.userId.copy();
        this.code = other.code == null ? null : other.code.copy();
        this.name = other.name == null ? null : other.name.copy();
        this.description = other.description == null ? null : other.description.copy();
        this.isDeleted = other.isDeleted == null ? null : other.isDeleted.copy();
        this.distinct = other.distinct;
    }

    @Override
    public SubjectCriteria copy() {
        return new SubjectCriteria(this);
    }

    public StringFilter getId() {
        return id;
    }

    public StringFilter id() {
        if (id == null) {
            id = new StringFilter();
        }
        return id;
    }

    public void setId(StringFilter id) {
        this.id = id;
    }

    public StringFilter getUserId() {
        return userId;
    }

    public StringFilter userId() {
        if (userId == null) {
            userId = new StringFilter();
        }
        return userId;
    }

    public void setUserId(StringFilter userId) {
        this.userId = userId;
    }

    public StringFilter getCode() {
        return code;
    }

    public StringFilter code() {
        if (code == null) {
            code = new StringFilter();
        }
        return code;
    }

    public void setCode(StringFilter code) {
        this.code = code;
    }

    public StringFilter getName() {
        return name;
    }

    public StringFilter name() {
        if (name == null) {
            name = new StringFilter();
        }
        return name;
    }

    public void setName(StringFilter name) {
        this.name = name;
    }

    public StringFilter getDescription() {
        return description;
    }

    public StringFilter description() {
        if (description == null) {
            description = new StringFilter();
        }
        return description;
    }

    public void setDescription(StringFilter description) {
        this.description = description;
    }

    public LongFilter getIsDeleted() {
        return isDeleted;
    }

    public LongFilter isDeleted() {
        if (isDeleted == null) {
            isDeleted = new LongFilter();
        }
        return isDeleted;
    }

    public void setIsDeleted(LongFilter isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Boolean getDistinct() {
        return distinct;
    }

    public void setDistinct(Boolean distinct) {
        this.distinct = distinct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final SubjectCriteria that = (SubjectCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(userId, that.userId) &&
            Objects.equals(code, that.code) &&
            Objects.equals(name, that.name) &&
            Objects.equals(description, that.description) &&
            Objects.equals(isDeleted, that.isDeleted) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, code, name, description, isDeleted, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SubjectCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (userId != null ? "userId=" + userId + ", " : "") +
            (code != null ? "code=" + code + ", " : "") +
            (name != null ? "name=" + name + ", " : "") +
            (description != null ? "description=" + description + ", " : "") +
            (isDeleted != null ? "isDeleted=" + isDeleted + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
