package com.myob.exercise.validators;

import com.myob.exercise.exceptions.InvalidDateException;
import com.myob.exercise.exceptions.InvalidNameException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

public class InputDataValidator {

    private static final String REGEX = "^[ a-zA-Z'-]*";
    private static final LocalDate START_DATE = LocalDate.of(2012, 6, 1);
    private static final LocalDate END_DATE = LocalDate.of(2013, 5, 31);

    public static void validateName(String name) throws InvalidNameException {
        if (!name.matches(REGEX))
            throw new InvalidNameException("Name should contain only letters.");
    }

    public static LocalDate[] validateDate(String date) throws InvalidDateException {
        Locale.setDefault(Locale.UK);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH);
        DateTimeFormatter formatter = new DateTimeFormatterBuilder().parseCaseInsensitive()
                .appendPattern("dd-MMM-yyyy")
                .toFormatter();
        String[] dates = date.split(" - ");
        LocalDate[] payslipDates = {LocalDate.parse(dates[0], formatter), LocalDate.parse(dates[1], formatter)};
        if (payslipDates[0].isBefore(START_DATE) || payslipDates[1].isAfter(END_DATE))
            throw new InvalidDateException("Wrong Dates. Calculator work only for 2012/2013 tax year (1 Jul 2012 - 31 May 2013).");
        if (payslipDates[0].isAfter(payslipDates[1]))
            throw new InvalidDateException("First Date should be befor second.");

        return payslipDates;
    }
}
