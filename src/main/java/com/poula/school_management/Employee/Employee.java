package com.poula.school_management.Employee;

import com.poula.school_management.Shared.MonetaryAmount.MonetaryAmount;
import com.poula.school_management.Shared.PersonalDetails;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Employee {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    protected Long id;

    @Embedded
    protected PersonalDetails personalDetails;

    @Embedded
    protected MonetaryAmount salary;
    public Employee(){}
    public Employee(PersonalDetails personalDetails, MonetaryAmount salary) {
        this.personalDetails = personalDetails;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public PersonalDetails getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(PersonalDetails personalDetails) {
        this.personalDetails = personalDetails;
    }

    public MonetaryAmount getSalary() {
        return salary;
    }

    public void setSalary(MonetaryAmount salary) {
        this.salary = salary;
    }
}
