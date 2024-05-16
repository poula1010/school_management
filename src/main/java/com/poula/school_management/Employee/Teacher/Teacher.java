package com.poula.school_management.Employee.Teacher;

import com.poula.school_management.Employee.Employee;
import com.poula.school_management.Shared.MonetaryAmount.MonetaryAmount;
import com.poula.school_management.Shared.PersonalDetails;
import jakarta.persistence.Entity;

@Entity
public class Teacher extends Employee {
    public Teacher(PersonalDetails personalDetails, MonetaryAmount salary){
        super(personalDetails,salary);
    }
    public Teacher(){}
}
