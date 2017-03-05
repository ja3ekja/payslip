package com.myob.exercise.validators;

import com.myob.exercise.exceptions.InvalidNameException;
import com.myob.exercise.exceptions.SalaryException;
import com.myob.exercise.exceptions.SuperRateException;
import com.myob.exercise.model.Employee;

import java.math.BigDecimal;

public class EmployeeValidator {

    private static final String REGEX = "^[ a-zA-Z'-]*";

    public static Employee validate(String firstName, String lastName, String annualSalary, String superRate) throws SalaryException, SuperRateException {
        return new Employee(firstName, lastName, validateSalary(annualSalary), validateSuperRate(superRate));
    }

    public static void validateName(String name, String surname) throws InvalidNameException {
        if (!name.matches(REGEX) || !surname.matches(REGEX))
            throw new InvalidNameException("Name should contain only letters.");
    }

    public static BigDecimal validateSalary(String salary) throws SalaryException {
        BigDecimal annualSalary = new BigDecimal(salary);
        if (annualSalary.compareTo(new BigDecimal(0)) <= 0)
            throw new SalaryException("Salary should be bigger than 0.");
        return annualSalary;
    }

    public static float validateSuperRate(String superRate) throws SuperRateException {
        float rate = Float.valueOf(superRate);
        if (rate < 0 || rate > 50)
            throw new SuperRateException("Super Rate should be in range from 0% to 50 %.");
        return rate;
    }
}
