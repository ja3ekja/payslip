package com.myob.exercise.validators;

import com.myob.exercise.exceptions.InvalidNameException;
import com.myob.exercise.exceptions.SalaryException;
import com.myob.exercise.exceptions.SuperRateException;
import org.junit.Test;

public class EmployeeValidatorTest {

    @Test
    public void validateTest() throws SalaryException, SuperRateException, InvalidNameException {
        EmployeeValidator.validate("Jacek - Junior", "O'Neil", "70000", "10");
    }

    @Test(expected = SalaryException.class)
    public void validateIncorectSalaryTest() throws SalaryException, SuperRateException, InvalidNameException {
        EmployeeValidator.validate("Jacek", "Feliksiak", "-10000", "10");
    }

    @Test(expected = NumberFormatException.class)
    public void validateWrongValueSuperTest() throws SalaryException, SuperRateException, InvalidNameException {
        EmployeeValidator.validate("Jacek", "Feliksiak", "70000", "ten");
    }

    @Test(expected = SuperRateException.class)
    public void validateIncorrectValueSuperTest() throws SalaryException, SuperRateException, InvalidNameException {
        EmployeeValidator.validate("Jacek", "Feliksiak", "70000", "51");
    }

    @Test
    public void validateNameTest() throws InvalidNameException {
        EmployeeValidator.validateName("Jacek", "Feliksiak");
    }

    @Test(expected = InvalidNameException.class)
    public void validateInvalidNameInvalidTest() throws InvalidNameException {
        EmployeeValidator.validateName("Jace@k", "Feliksiak");
    }
}
