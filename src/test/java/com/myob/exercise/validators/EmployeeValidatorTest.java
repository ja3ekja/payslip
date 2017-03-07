package com.myob.exercise.validators;

import com.myob.exercise.exceptions.SalaryException;
import com.myob.exercise.exceptions.SuperannuationException;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class EmployeeValidatorTest {

    private BigDecimal salary;
    private float superannuation;

    @Before
    public void generate() {
        salary = new BigDecimal(55000);
        superannuation = 9.5f;
    }

    @Test
    public void validateSalaryTest() throws SalaryException {
        assertEquals(EmployeeValidator.validateSalary("55000"), salary);
    }

    @Test
    public void validateSalaryNotEqualsTest() throws SalaryException {
        assertNotEquals(EmployeeValidator.validateSalary("60000"), salary);
    }

    @Test(expected = SalaryException.class)
    public void validateSalaryWrongTest() throws SalaryException {
        EmployeeValidator.validateSalary("-20000");
    }

    @Test
    public void validateSuperannuationTest() throws SuperannuationException {
        assertTrue(EmployeeValidator.validateSuperannuation("9.5") == superannuation);
    }

    @Test
    public void validateSuperanuationNotEqualsTest() throws SuperannuationException {
        assertNotEquals(EmployeeValidator.validateSuperannuation("30"), superannuation);
    }

    @Test(expected = SuperannuationException.class)
    public void validateSuperannuationWrongSuperTest() throws SuperannuationException {
        EmployeeValidator.validateSuperannuation("80");
    }
}