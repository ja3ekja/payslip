package com.myob.exercise.validators;

import com.myob.exercise.exceptions.InvalidDateException;
import com.myob.exercise.exceptions.InvalidNameException;
import com.myob.exercise.exceptions.WrongDateFormatException;
import org.junit.Before;
import org.junit.Test;

import java.util.Locale;

public class InputDataValidatorTest {

    private String correctDate;
    private String wrongDate;
    private String moreThanOneMonthDate;
    private String brokenString;
    private String dateBeforeCalculatorPeriod;
    private String name;
    private String wrongName;

    @Before
    public void generate() {
        Locale.setDefault(Locale.UK);
        correctDate = "01-Feb-2013 - 31-Feb-2013";
        brokenString = "test";
        wrongDate = "15-mar-2013 - 14-JUL-2013";
        moreThanOneMonthDate = "15-mar-2013 - 14-Apr-2013";
        dateBeforeCalculatorPeriod = "15-apr-2011 - 31-apr-2011";
        name = "Jacek - O'Neil";
        wrongName = "Jacek @ Neil";
    }

    @Test
    public void validateDateTest() throws InvalidDateException, WrongDateFormatException {
        EmployeeValidator.validateDate(correctDate);
    }

    @Test(expected = WrongDateFormatException.class)
    public void validateWrongStringTest() throws InvalidDateException, WrongDateFormatException {
        EmployeeValidator.validateDate(brokenString);
    }

    @Test(expected = InvalidDateException.class)
    public void validateWrongDataTest() throws InvalidDateException, WrongDateFormatException {
        EmployeeValidator.validateDate(wrongDate);
    }

    @Test(expected = InvalidDateException.class)
    public void validateMoreThanOneMonthDataTest() throws InvalidDateException, WrongDateFormatException {
        EmployeeValidator.validateDate(moreThanOneMonthDate);
    }

    @Test(expected = InvalidDateException.class)
    public void validateDataBeforeRangeTest() throws InvalidDateException, WrongDateFormatException {
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
