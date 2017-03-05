package com.myob.exercise.validators;

import com.myob.exercise.exceptions.NameException;
import com.myob.exercise.exceptions.SalaryException;
import com.myob.exercise.exceptions.SuperRateException;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by HP on 2017-03-05.
 */
public class EmployeeValidatorTest {

    private EmployeeValidator employeeValidator;

    @Before
    public void setEmployeeValidator() {
        employeeValidator = new EmployeeValidator();
    }

    @Test
    public void validateTest() throws SalaryException, SuperRateException, NameException {
        employeeValidator.validate("Jacek - Junior", "O'Neil", "70000", "10");
    }

    @Test(expected = NameException.class)
    public void validateIncorrectNameTest() throws SalaryException, SuperRateException, NameException {
        employeeValidator.validate("Jacek@", "Feliksiak", "70000", "10");
    }

    @Test(expected = SalaryException.class)
    public void validateIncorectSalaryTest() throws SalaryException, SuperRateException, NameException {
        employeeValidator.validate("Jacek", "Feliksiak", "-10000", "10");
    }

    @Test(expected = NumberFormatException.class)
    public void validateWrongValueSuperTest() throws SalaryException, SuperRateException, NameException {
        employeeValidator.validate("Jacek", "Feliksiak", "70000", "ten");
    }

    @Test(expected = SuperRateException.class)
    public void validateIncorrectValueSuperTest() throws SalaryException, SuperRateException, NameException {
        employeeValidator.validate("Jacek", "Feliksiak", "70000", "51");
    }
}
