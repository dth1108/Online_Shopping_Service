package com.example.quizpractice.service.criteria;

import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.StringFilter;
import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;


@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ImageCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private StringFilter id;

    private StringFilter contentBase64;

    private Boolean distinct;

    public ImageCriteria() {
    }

    public ImageCriteria(ImageCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.contentBase64 = other.contentBase64 == null ? null : other.contentBase64.copy();
        this.distinct = other.distinct;
    }

    @Override
    public ImageCriteria copy() {
        return new ImageCriteria(this);
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

    public StringFilter getContentBase64() {
        return contentBase64;
    }

    public StringFilter contentBase64() {
        if (contentBase64 == null) {
            contentBase64 = new StringFilter();
        }
        return contentBase64;
    }

    public void setContentBase64(StringFilter contentBase64) {
        this.contentBase64 = contentBase64;
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
        final ImageCriteria that = (ImageCriteria) o;
        return Objects.equals(id, that.id) && Objects.equals(contentBase64, that.contentBase64)
                && Objects.equals(distinct, that.distinct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, contentBase64, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ImageCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (contentBase64 != null ? "contentBase64=" + contentBase64 + ", " : "") +
                (distinct != null ? "distinct=" + distinct + ", " : "") +
                "}";
    }
}
