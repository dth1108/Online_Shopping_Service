package com.example.quizpractice.service.criteria;

import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;


@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class BlogCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private StringFilter id;

    private StringFilter title;

    private StringFilter authorID;

    private StringFilter contentText;

    private StringFilter imageID;

    private Boolean distinct;

    public BlogCriteria() {}

    public BlogCriteria(BlogCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.title = other.title == null ? null : other.title.copy();
        this.authorID = other.authorID == null ? null : other.authorID.copy();
        this.contentText = other.contentText == null ? null : other.contentText.copy();
        this.imageID = other.imageID == null ? null : other.imageID.copy();
        this.distinct = other.distinct;
    }

    @Override
    public BlogCriteria copy() {
        return new BlogCriteria(this);
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

    public StringFilter getTitle() {
        return title;
    }

    public StringFilter title() {
        if (title == null) {
            title = new StringFilter();
        }
        return title;
    }

    public void setTitle(StringFilter title) {
        this.title = title;
    }

    public StringFilter getAuthorID() {
        return authorID;
    }

    public StringFilter authorID() {
        if (authorID == null) {
            authorID = new StringFilter();
        }
        return authorID;
    }

    public void setAuthorID(StringFilter authorID) {
        this.authorID = authorID;
    }

    public StringFilter getContentText() {
        return contentText;
    }

    public StringFilter contentText() {
        if (contentText == null) {
            contentText = new StringFilter();
        }
        return contentText;
    }

    public void setContentText(StringFilter contentText) {
        this.contentText = contentText;
    }

    public StringFilter getImageID() {
        return imageID;
    }

    public StringFilter imageID() {
        if (imageID == null) {
            imageID = new StringFilter();
        }
        return imageID;
    }

    public void setImageID(StringFilter imageID) {
        this.imageID = imageID;
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
        final BlogCriteria that = (BlogCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(title, that.title) &&
            Objects.equals(authorID, that.authorID) &&
            Objects.equals(contentText, that.contentText) &&
            Objects.equals(imageID, that.imageID) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, authorID, contentText, imageID, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "BlogCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (title != null ? "title=" + title + ", " : "") +
            (authorID != null ? "authorID=" + authorID + ", " : "") +
            (contentText != null ? "contentText=" + contentText + ", " : "") +
            (imageID != null ? "imageID=" + imageID + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
