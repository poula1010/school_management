package com.poula.school_management.Employee;

import com.poula.school_management.Shared.Address;
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
    protected Address address;
    @Embedded
    protected MonetaryAmount salary;
    public Employee(){}
    public Employee(PersonalDetails personalDetails,Address address, MonetaryAmount salary) {
        this.personalDetails = personalDetails;
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
