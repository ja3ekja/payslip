package com.myob.exercise.validators;

import com.myob.exercise.exceptions.InvalidDateException;
import com.myob.exercise.exceptions.InvalidNameException;
import org.junit.Before;
import org.junit.Test;

import java.time.format.DateTimeParseException;

public class InputDataValidatorTest {

    private String correctDate;
    private String wrongDate;
    private String brokenString;
    private String dateBeforeCalculatorPeriod;
    private String name;
    private String wrongName;

    @Before
    public void generate() {
        correctDate = "1-mar-2013 - 31-mar-2013";
        brokenString = "test";
        wrongDate = "15-mar-2013 - 14-mar-2013";
        dateBeforeCalculatorPeriod = "15-mar-2011 - 31-mar-2011";
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
