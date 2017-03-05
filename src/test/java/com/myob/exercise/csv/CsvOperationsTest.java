package com.myob.exercise.csv;

import com.myob.exercise.exceptions.PersonNotFoundException;
import com.myob.exercise.exceptions.WrongPathException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CsvOperationsTest {

    private String path;
    private List<String> employeeDataList;
    private String fakePath;

    @Before
    public void listGenerate() {
        path = Paths.get("").toAbsolutePath().resolve("..\\..\\Employee.csv").normalize().toString();
        fakePath = "C:\\Users\\Employee.csv";
        employeeDataList = Arrays.asList("Jane", "Patrick", "94727", "12");
    }

    @Test
    public void getEmployeeDataFromCSVFileTest() throws PersonNotFoundException, IOException, WrongPathException {
        assertEquals(CsvOperations.getEmployeeDataFromCSVFile("Jane", "Patrick", path), employeeDataList);
    }

    @Test
    public void getEmployeeDataFromCSVFileWrongListTest() throws PersonNotFoundException, IOException, WrongPathException {
        employeeDataList.set(1, "Feliksiak");
        assertNotEquals(CsvOperations.getEmployeeDataFromCSVFile("Jane", "Patrick", path), employeeDataList);
        employeeDataList.set(1, "Patrick");
    }

    @Test(expected = PersonNotFoundException.class)
    public void getEmployeeDataFromCSVFileWrongDataTest() throws PersonNotFoundException, IOException, WrongPathException {
        CsvOperations.getEmployeeDataFromCSVFile("Jacek", "Feliksiak1", path);
    }

    @Test(expected = WrongPathException.class)
    public void getEmployeeDataFromCSVFileWrongPathTest() throws PersonNotFoundException, IOException, WrongPathException {
        CsvOperations.getEmployeeDataFromCSVFile("Jacek", "Feliksiak", fakePath);
    }
}