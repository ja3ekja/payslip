package com.myob.exercise.validators;

import com.myob.exercise.exceptions.InvalidDateException;
import com.myob.exercise.exceptions.InvalidNameException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InputDataValidator {

    private static final String REGEX = "^[ a-zA-Z'-]*";
    private static final LocalDate START_DATE = LocalDate.of(2012, 6, 1);
    private static final LocalDate END_DATE = LocalDate.of(2013, 5, 31);

    public static void validateName(String name) throws InvalidNameException {
        if (!name.matches(REGEX))
            throw new InvalidNameException("Name should contain only letters.");
    }

    public static LocalDate[] validateDate(String date) throws InvalidDateException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");
        String[] dates = date.split(" - ");
        LocalDate[] payslipDates = {LocalDate.parse(dates[0], formatter), LocalDate.parse(dates[1], formatter)};
        if (payslipDates[0].isBefore(START_DATE) || payslipDates[1].isAfter(END_DATE) || payslipDates[0].isAfter(payslipDates[1])) {
            throw new InvalidDateException("Wrong Dates. Calculator work only for 2012/2013 tax year (1 Jul 2012 - 31 May 2013).");
        }
        return payslipDates;
    }
}
