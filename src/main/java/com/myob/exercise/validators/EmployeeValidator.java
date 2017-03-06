package com.myob.exercise.validators;

import com.myob.exercise.exceptions.SalaryException;
import com.myob.exercise.exceptions.SuperRateException;

import java.math.BigDecimal;

public class EmployeeValidator extends InputDataValidator {

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
