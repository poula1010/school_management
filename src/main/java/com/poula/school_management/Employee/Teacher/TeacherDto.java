package com.poula.school_management.Employee.Teacher;

import com.poula.school_management.Shared.Address;
import com.poula.school_management.Shared.PersonalDetails;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public class TeacherDto {

    protected Long id;
    @NotNull
    protected Address address;

    @NotNull
    protected PersonalDetails personalDetails;

    @NotNull
    @PositiveOrZero
    protected BigDecimal salary;

    public TeacherDto() {
    }

    public TeacherDto(Long id, Address address, PersonalDetails personalDetails, BigDecimal salary) {
        this.id = id;
        this.address = address;
        this.personalDetails = personalDetails;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public PersonalDetails getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(PersonalDetails personalDetails) {
        this.personalDetails = personalDetails;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeacherDto that = (TeacherDto) o;

        return getPersonalDetails().equals(that.getPersonalDetails());
    }

    @Override
    public int hashCode() {
        return getPersonalDetails().hashCode();
    }
}
