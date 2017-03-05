package com.myob.exercise.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * Created by HP on 2017-03-04.
 */
public class CsvOperations {

    private final String SEPARATOR = ";";

    public String getEmployeeDataFromCSVFile(String csvFile, String name, String surname) {

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            List<String> rows = reader.lines().map(line -> Arrays.asList(line.split(SEPARATOR))).filter(emp -> emp.get(1).equals(surname) && emp.get(0).equals(name)).findFirst().get();
            return rows.stream().collect(Collectors.joining(";"));
        } catch (IOException | NoSuchElementException e) {
            e.printStackTrace();
        }

        return "";
    }
}
