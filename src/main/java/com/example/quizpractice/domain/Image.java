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
import org.springframework.boot.actuate.audit.listener.AuditListener;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * A Image.
 */
@Entity
@Table(name = "image")
@SuppressWarnings("common-java:DuplicatedBlocks")
@EntityListeners(AuditListener.class)


public class Image
        extends AuditableEntity
        implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
//    @GeneratedValue(generator = "UUID")
//    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    @Column(name = "content_base_64",columnDefinition="TEXT")
    private String contentBase64;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public String getId() {
        return this.id;
    }

    public Image id(String id) {
        this.setId(id);
        return this;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContentBase64() {
        return this.contentBase64;
    }

    public Image contentBase64(String contentBase64) {
        this.setContentBase64(contentBase64);
        return this;
    }

    public void setContentBase64(String contentBase64) {
        this.contentBase64 = contentBase64;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Image)) {
            return false;
        }
        return id != null && id.equals(((Image) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Image{" +
            "id=" + getId() +
            ", contentBase64='" + getContentBase64() + "'" +
            "}";
    }
}
