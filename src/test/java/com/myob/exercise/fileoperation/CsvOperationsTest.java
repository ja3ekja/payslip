package com.myob.exercise.fileoperation;

import com.myob.exercise.exceptions.PaySlipException;
import com.myob.exercise.exceptions.PersonNotFoundException;
import com.myob.exercise.exceptions.WrongPathException;
import com.myob.exercise.model.Payslip;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CsvOperationsTest {

    private Payslip payslip;
    private String fakePath;
    private String csvFilePath;
    private List<String> resultData;

    @Before
    public void listGenerate() {
        resultData = Arrays.asList("Ali", "Patrick", "78764", "44");
        BigDecimal bigDecimal = new BigDecimal(10);
        payslip = new Payslip("Jac;Fel", LocalDate.now(), LocalDate.now(), bigDecimal, bigDecimal, bigDecimal, bigDecimal);
        fakePath = Paths.get("").toAbsolutePath().resolve("src\\test\\Employees.csv").toString();
        csvFilePath = Paths.get("").toAbsolutePath().resolve("src\\test\\resources\\Employees.csv").toString();
    }

    @Test()
    public void writeCSVFileFileWrongPathTest() throws IOException {
        CsvOperations.writeCSVFile(payslip, csvFilePath);
    }

    @Test
    public void getEmployeeDataFromCSVFileTest() throws IOException, PaySlipException {
        assertEquals(CsvOperations.getEmployeeDataFromCSVFile("Ali", "Patrick", csvFilePath), resultData);
    }

    @Test(expected = PersonNotFoundException.class)
    public void getEmployeeDataFromCSVFileNotFoundPersonTest() throws PaySlipException, IOException {
        CsvOperations.getEmployeeDataFromCSVFile("Jacek", "Feliksiak", csvFilePath);
    }

    @Test(expected = WrongPathException.class)
    public void getEmployeeDataFromCSVFileWrongPathTest() throws PaySlipException, IOException {
        CsvOperations.getEmployeeDataFromCSVFile("Jacek", "Feliksiak", fakePath);
    }
}