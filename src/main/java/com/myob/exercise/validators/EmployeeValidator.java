package com.myob.exercise.validators;

import com.myob.exercise.exceptions.NameException;
import com.myob.exercise.exceptions.SalaryException;
import com.myob.exercise.exceptions.SuperRateException;
import com.myob.exercise.model.Employee;

import java.math.BigDecimal;

/**
 * Created by HP on 2017-03-04.
 */
public class EmployeeValidator {

    private final String REGEX = "^[ a-zA-Z'-]*";

    public Employee validate(String firstName, String lastName, String annualSalary, String superRate) throws NameException, SalaryException, SuperRateException {

        return new Employee(validateName(firstName), validateName(lastName), validateSalary(annualSalary), validateSuperRate(superRate));
    }

    private String validateName(String literal) throws NameException {

        if (!literal.matches(REGEX))
            throw new NameException("Name should contain only letters.");
        return literal;
    }

    private BigDecimal validateSalary(String salary) throws SalaryException {

        BigDecimal annualSalary = new BigDecimal(salary);
        if (annualSalary.compareTo(new BigDecimal(0)) <= 0)
            throw new SalaryException("Salary should be bigger than 0.");
        return annualSalary;
    }

    private float validateSuperRate(String superRate) throws SuperRateException {
        float rate = Float.valueOf(superRate);
        if (rate < 0 || rate > 50)
            throw new SuperRateException("Super Rate should be in range from 0% to 50 %.");
        return rate;
    }
}
