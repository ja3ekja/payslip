package com.myob.exercise.validators;

import com.myob.exercise.exceptions.InvalidDateException;
import com.myob.exercise.exceptions.InvalidNameException;
import org.junit.Before;
import org.junit.Test;

import java.time.format.DateTimeParseException;
import java.util.Locale;

public class InputDataValidatorTest {

    private String correctDate;
    private String wrongDate;
    private String brokenString;
    private String dateBeforeCalculatorPeriod;
    private String name;
    private String wrongName;

    @Before
    public void generate() {
        Locale.setDefault(Locale.UK);
        correctDate = "01-Feb-2013 - 31-feb-2013";
        brokenString = "test";
        wrongDate = "15-mar-2013 - 14-JUL-2013";
        dateBeforeCalculatorPeriod = "15-apr-2011 - 31-apr-2011";
        name = "Jacek - O'Neil";
        wrongName = "Jacek @ Neil";
    }

    @Test
    public void validateDateTest() throws InvalidDateException {
        EmployeeValidator.validateDate(correctDate);
    }

    @Test(expected = DateTimeParseException.class)
    public void validateWrongStringTest() throws InvalidDateException {
        EmployeeValidator.validateDate(brokenString);
    }

    @Test(expected = InvalidDateException.class)
    public void validateWrongDataTest() throws InvalidDateException {
        EmployeeValidator.validateDate(wrongDate);
    }

    @Test(expected = InvalidDateException.class)
    public void validateDataBeforeRangeTest() throws InvalidDateException {
        EmployeeValidator.validateDate(dateBeforeCalculatorPeriod);
    }

    @Test()
    public void validateNameTest() throws InvalidNameException {
        EmployeeValidator.validateName(name);
    }

    @Test(expected = InvalidNameException.class)
    public void validateWrongNameTest() throws InvalidNameException {
        EmployeeValidator.validateName(wrongName);
    }
}
