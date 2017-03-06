package com.myob.exercise;

import com.myob.exercise.exceptions.PaySlipException;
import com.myob.exercise.fileoperation.CsvOperations;
import com.myob.exercise.model.Employee;
import com.myob.exercise.model.Payslip;
import com.myob.exercise.model.PayslipInputData;
import com.myob.exercise.services.PayslipService;
import com.myob.exercise.validators.EmployeeValidator;
import com.myob.exercise.validators.InputDataValidator;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

public class Main {

    private static Payslip payslip = null;
    private static final String fixedFilePath = "..\\..\\Employees.csv";

    public static void main(String[] args) throws IOException {
        if (args.length == 4) {
            generatePayslip(args[0], args[1], args[2], args[3]);
            CsvOperations.writeCSVFile(payslip, args[3]);
        } else if (args.length == 3) {
            generatePayslip(args[0], args[1], args[2], resolvePath());
            CsvOperations.writeCSVFile(payslip);
        } else {
            payslip = null;
            System.out.println("Invalid argument number (Should be 3 or 4: name, surname, dates, filePath [Optional]).");
        }
        System.out.print(payslip == null ? "" : payslip);
    }

    private static void generatePayslip(String firstName, String lastName, String date, String filePath) {
        try {
            InputDataValidator.validateName(firstName);
            InputDataValidator.validateName(lastName);
            LocalDate[] dates = InputDataValidator.validateDate(date);
            List<String> empData = CsvOperations.getEmployeeDataFromCSVFile(firstName, lastName, filePath);
            BigDecimal salary = EmployeeValidator.validateSalary(empData.get(2));
            float rate = EmployeeValidator.validateSuperRate(empData.get(3));
            Employee emp = new Employee(firstName, lastName, salary, rate);
            payslip = PayslipService.calculate(new PayslipInputData(emp, dates[0], dates[1]));
        } catch (PaySlipException | IOException e) {
            e.printStackTrace();
        }
    }

    public static String resolvePath() {
        return Paths.get("").toAbsolutePath().resolve(fixedFilePath).normalize().toString();
    }
}