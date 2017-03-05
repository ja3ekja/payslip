package com.myob.exercise.validators;

import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.Null;

import static org.junit.Assert.*;

/**
 * Created by HP on 2017-03-05.
 */
public class EmployeePayslipValidatorTest {

    private EmployeePayslipValidator employeePayslipValidator;

    @Before
    public void setEmployeePayslipValidator() {
        employeePayslipValidator = new EmployeePayslipValidator();
    }

    @Test
    public void validateTest() {
        assertNotNull(employeePayslipValidator.validate("Jacek - Junior;O'Neil;70000;10;01 March"));
    }

    @Test
    public void validateWrongParametersNumberTest() {
        assertNull(employeePayslipValidator.validate("Jacek - Junior;O'Neil;70000;10"));
    }

    @Test
    public void validateWithNullParameterTest() {
        assertNull(employeePayslipValidator.validate("Jacek - Junior;O'Neil;;10;01 March"));
    }

    @Test
    public void validateWithEmptyStringTest() {
        assertNull(employeePayslipValidator.validate(""));
    }

    @Test
    public void validateWithNullTest() {
        assertNull(employeePayslipValidator.validate(null));
    }

    @Test
    public void validateEmptyStringTest() {
        assertNotNull(employeePayslipValidator.validateEmptyOrNullString("myob"));
    }

    @Test(expected = NullPointerException.class)
    public void validateEmptyStringWithEmptyStringTest() {
        employeePayslipValidator.validateEmptyOrNullString("");
    }

    @Test(expected = NullPointerException.class)
    public void validateEmptyStringWithNullTest() {
        employeePayslipValidator.validateEmptyOrNullString(null);
    }
}
