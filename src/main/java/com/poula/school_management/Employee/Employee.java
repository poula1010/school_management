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
}
