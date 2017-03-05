package com.myob.exercise.utils;

import com.myob.exercise.exceptions.NameException;
import com.myob.exercise.exceptions.SalaryException;
import com.myob.exercise.exceptions.SuperRateException;
import com.myob.exercise.model.EmployeesPayslip;
import com.myob.exercise.validators.EmployeePayslipValidator;

/**
 * Created by HP on 2017-03-04.
 */
public class EmployeesPayslipTransform {

    public EmployeesPayslip transform(String inputData)  {

        return new EmployeePayslipValidator().validate(inputData);
    }
}
