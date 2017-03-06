package com.myob.exercise.fileoperation;

import com.myob.exercise.Main;
import com.myob.exercise.exceptions.PersonNotFoundException;
import com.myob.exercise.exceptions.WrongPathException;
import com.myob.exercise.model.Payslip;

import java.io.*;
import java.nio.file.Paths;
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

    public static void writeCSVFile(Payslip slip, String ownerFilePath) throws IOException {
        try (PrintWriter writer = new PrintWriter(resolveOutputFile(ownerFilePath))) {
            writer.println(Payslip.toCSVHeader());
            writer.println(slip.toString());
        }
    }

    public static void writeCSVFile(Payslip slip) throws IOException {
        writeCSVFile(slip, Main.resolvePath());
    }

    public static String resolveOutputFile(String file) {
        return Paths.get(new File(file).getParent()).resolve("Employee.csv").toString();
    }
}
