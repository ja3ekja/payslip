package com.myob.exercise.validators;

import com.myob.exercise.exceptions.InvalidDateException;
import com.myob.exercise.exceptions.InvalidNameException;
import com.myob.exercise.exceptions.WrongDateFormatException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class InputDataValidator {

    private static final String REGEX = "^[ a-zA-Z'-]*";
    private static final LocalDate RANGE_BEGIN = LocalDate.of(2012, 6, 1);
    private static final LocalDate RANGE_END = LocalDate.of(2013, 5, 31);

    public static void validateName(String name) throws InvalidNameException {
        if (!name.matches(REGEX))
            throw new InvalidNameException("Name should contain only letters.");
    }

    public static LocalDate[] validateDate(String date) throws InvalidDateException, WrongDateFormatException {
        LocalDate[] payslipDates;
        try {
            Locale.setDefault(Locale.UK);
            DateTimeFormatter formatter = new DateTimeFormatterBuilder().parseCaseInsensitive()
                    .appendPattern("dd-MMM-yyyy")
                    .toFormatter();
            String[] dates = date.split(" - ");
            payslipDates = new LocalDate[]{LocalDate.parse(dates[0], formatter), LocalDate.parse(dates[1], formatter)};
            if (payslipDates[0].isBefore(RANGE_BEGIN) || payslipDates[1].isAfter(RANGE_END))
                throw new InvalidDateException("Wrong Dates. Calculator work only for 2012/2013 tax year (1 Jul 2012 - 31 May 2013).");
            if (payslipDates[0].isAfter(payslipDates[1]))
                throw new InvalidDateException("First date should be before second.");
            if(payslipDates[0].getMonthValue()!=payslipDates[1].getMonthValue())
                throw new InvalidDateException("Payslip have to be from one month.");
        } catch (DateTimeParseException e) {
            throw new WrongDateFormatException("Problem with date parsing. Should be dd-MMM-yyy.");
        }
        return payslipDates;
    }
}
