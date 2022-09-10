package com.example.quizpractice.service.criteria;

import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;



@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class UserCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private StringFilter id;

    private StringFilter username;

    private StringFilter password;

    private StringFilter email;

    private StringFilter firstName;

    private StringFilter lastName;

    private StringFilter birthDate;

    private LongFilter gender;

    private StringFilter address;

    private LongFilter active;

    private Boolean distinct;

    public UserCriteria() {}

    public UserCriteria(UserCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.username = other.username == null ? null : other.username.copy();
        this.password = other.password == null ? null : other.password.copy();
        this.email = other.email == null ? null : other.email.copy();
        this.firstName = other.firstName == null ? null : other.firstName.copy();
        this.lastName = other.lastName == null ? null : other.lastName.copy();
        this.birthDate = other.birthDate == null ? null : other.birthDate.copy();
        this.gender = other.gender == null ? null : other.gender.copy();
        this.address = other.address == null ? null : other.address.copy();
        this.active = other.active == null ? null : other.active.copy();
        this.distinct = other.distinct;
    }

    @Override
    public UserCriteria copy() {
        return new UserCriteria(this);
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

    public StringFilter getUsername() {
        return username;
    }

    public StringFilter username() {
        if (username == null) {
            username = new StringFilter();
        }
        return username;
    }

    public void setUsername(StringFilter username) {
        this.username = username;
    }

    public StringFilter getPassword() {
        return password;
    }

    public StringFilter password() {
        if (password == null) {
            password = new StringFilter();
        }
        return password;
    }

    public void setPassword(StringFilter password) {
        this.password = password;
    }

    public StringFilter getEmail() {
        return email;
    }

    public StringFilter email() {
        if (email == null) {
            email = new StringFilter();
        }
        return email;
    }

    public void setEmail(StringFilter email) {
        this.email = email;
    }

    public StringFilter getFirstName() {
        return firstName;
    }

    public StringFilter firstName() {
        if (firstName == null) {
            firstName = new StringFilter();
        }
        return firstName;
    }

    public void setFirstName(StringFilter firstName) {
        this.firstName = firstName;
    }

    public StringFilter getLastName() {
        return lastName;
    }

    public StringFilter lastName() {
        if (lastName == null) {
            lastName = new StringFilter();
        }
        return lastName;
    }

    public void setLastName(StringFilter lastName) {
        this.lastName = lastName;
    }

    public StringFilter getBirthDate() {
        return birthDate;
    }

    public StringFilter birthDate() {
        if (birthDate == null) {
            birthDate = new StringFilter();
        }
        return birthDate;
    }

    public void setBirthDate(StringFilter birthDate) {
        this.birthDate = birthDate;
    }

    public LongFilter getGender() {
        return gender;
    }

    public LongFilter gender() {
        if (gender == null) {
            gender = new LongFilter();
        }
        return gender;
    }

    public void setGender(LongFilter gender) {
        this.gender = gender;
    }

    public StringFilter getAddress() {
        return address;
    }

    public StringFilter address() {
        if (address == null) {
            address = new StringFilter();
        }
        return address;
    }

    public void setAddress(StringFilter address) {
        this.address = address;
    }

    public LongFilter getActive() {
        return active;
    }

    public LongFilter active() {
        if (active == null) {
            active = new LongFilter();
        }
        return active;
    }

    public void setActive(LongFilter active) {
        this.active = active;
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
        final UserCriteria that = (UserCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(username, that.username) &&
            Objects.equals(password, that.password) &&
            Objects.equals(email, that.email) &&
            Objects.equals(firstName, that.firstName) &&
            Objects.equals(lastName, that.lastName) &&
            Objects.equals(birthDate, that.birthDate) &&
            Objects.equals(gender, that.gender) &&
            Objects.equals(address, that.address) &&
            Objects.equals(active, that.active) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, email, firstName, lastName, birthDate, gender, address, active, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UserCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (username != null ? "username=" + username + ", " : "") +
            (password != null ? "password=" + password + ", " : "") +
            (email != null ? "email=" + email + ", " : "") +
            (firstName != null ? "firstName=" + firstName + ", " : "") +
            (lastName != null ? "lastName=" + lastName + ", " : "") +
            (birthDate != null ? "birthDate=" + birthDate + ", " : "") +
            (gender != null ? "gender=" + gender + ", " : "") +
            (address != null ? "address=" + address + ", " : "") +
            (active != null ? "active=" + active + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
