package com.myob.exercise.fileoperation;

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
        path = Paths.get("").toAbsolutePath().resolve("..\\..\\Employee.fileoperation").normalize().toString();
        fakePath = "C:\\Users\\Employee.fileoperation";
        employeeDataList = Arrays.asList("Jane", "Patrick", "94727", "12");
    }





}