package com.example.quizpractice.domain;

import com.example.quizpractice.common.repository.AuditableEntity;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.GenericGenerator;

/**
 * A Blog.
 */
@Entity
@Table(name = "blog")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Blog
        extends AuditableEntity
        implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author_id")
    private String authorID;

    @Column(name = "content_text",columnDefinition="TEXT")
    private String contentText;

    @Column(name = "image_id")
    private String imageID;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public String getId() {
        return this.id;
    }

    public Blog id(String id) {
        this.setId(id);
        return this;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public Blog title(String title) {
        this.setTitle(title);
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorID() {
        return this.authorID;
    }

    public Blog authorID(String authorID) {
        this.setAuthorID(authorID);
        return this;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public String getContentText() {
        return this.contentText;
    }

    public Blog contentText(String contentText) {
        this.setContentText(contentText);
        return this;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }

    public String getImageID() {
        return this.imageID;
    }

    public Blog imageID(String imageID) {
        this.setImageID(imageID);
        return this;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Blog)) {
            return false;
        }
        return id != null && id.equals(((Blog) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Blog{" +
            "id=" + getId() +
            ", title='" + getTitle() + "'" +
            ", authorID='" + getAuthorID() + "'" +
            ", contentText='" + getContentText() + "'" +
            ", imageID='" + getImageID() + "'" +
            "}";
    }
}
