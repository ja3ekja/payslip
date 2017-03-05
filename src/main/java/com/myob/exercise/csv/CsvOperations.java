package com.myob.exercise.csv;

import com.myob.exercise.exceptions.PersonNotFoundException;
import com.myob.exercise.exceptions.WrongPathException;
import com.myob.exercise.model.Payslip;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class CsvOperations {

    private static final String SEPARATOR = ";";

    public static List<String> getEmployeeDataFromCSVFile(String name, String surname, String csvFile) throws IOException, PersonNotFoundException, WrongPathException {
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            final Optional<List<String>> optional = reader.lines().map(CsvOperations::separateFields)
                    .filter(filterCorrectPersonPredicate(name, surname))
                    .findFirst();
            if (optional.isPresent()) {
                return optional.get();
            } else {
                throw new PersonNotFoundException("Person not found.");
            }
        } catch (FileNotFoundException e) {
            throw new WrongPathException("Invalid Path to CSV file.");
        }
    }

    private static Predicate<List<String>> filterCorrectPersonPredicate(String name, String surname) {
        return emp -> emp.get(1).equals(surname) && emp.get(0).equals(name);
    }

    private static List<String> separateFields(String line) {
        return Arrays.asList(line.split(SEPARATOR));
    }

    public static void writeCSVFile(Payslip payslip) throws IOException {
        try (FileWriter writer = new FileWriter("C:\\Users\\HP\\Desktop\\myob\\payslip\\Employee.csv")) {
            writer.write("name;payPeriod;grossIncome;incomeTax;netIncome;superRate");
            writer.write(payslip.toCSV());
        }
    }
}
