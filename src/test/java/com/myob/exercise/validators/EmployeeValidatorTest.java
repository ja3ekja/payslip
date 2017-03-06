package com.myob.exercise.validators;

import com.myob.exercise.exceptions.SalaryException;
import com.myob.exercise.exceptions.SuperRateException;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class EmployeeValidatorTest {

    private BigDecimal salary;
    private float superRate;

    @Before
    public void generate() {
        salary = new BigDecimal(55000);
        superRate = 9.5f;
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
    public void validateSuperRateTest() throws SuperRateException {
        assertTrue(EmployeeValidator.validateSuperRate("9.5") == superRate);
    }

    @Test
    public void validateSuperRateNotEqualsTest() throws SuperRateException {
        assertNotEquals(EmployeeValidator.validateSuperRate("30"), superRate);
    }

    @Test(expected = SuperRateException.class)
    public void validateSuperRateWrongSuperTest() throws SuperRateException {
        EmployeeValidator.validateSuperRate("80");
    }
}