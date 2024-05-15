package com.poula.school_management.Shared;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

@Embeddable
public class PersonalDetails {

    @NotNull
    @Column(nullable = false)
    protected String firstname;

    @NotNull
    @Column(nullable = false)
    protected String lastname;

    @Column(name="SSN",nullable = false,length = 64)
    protected String ssn;
    public PersonalDetails() {
    }

    public PersonalDetails(String firstname, String lastname,String ssn) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.ssn= ssn;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonalDetails that = (PersonalDetails) o;

        if (!getFirstname().equals(that.getFirstname())) return false;
        if (!getLastname().equals(that.getLastname())) return false;
        return getSsn().equals(that.getSsn());
    }

    @Override
    public int hashCode() {
        return getSsn().hashCode();
    }
}
