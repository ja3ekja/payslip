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
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

public class Main {

    private static Payslip payslip = null;

    public static void main(String[] args) throws IOException {
        if (args.length == 4) {
            generatePayslip(args[0], args[1], args[2], args[3]);
        } else if (args.length == 3) {
            generatePayslip(args[0], args[1], args[2], CsvOperations.getCurrentPath());
        } else {
            payslip = null;
            System.out.println("Invalid argument number (Should be 3 or 4 String: name, surname, dates, filePath [Optional]).");
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
            float rate = EmployeeValidator.validateSuperannuation(empData.get(3));
            Employee emp = new Employee(firstName, lastName, salary, rate);
            payslip = PayslipService.calculate(new PayslipInputData(emp, dates[0], dates[1]));
            CsvOperations.writeCSVFile(payslip, filePath);
        } catch (PaySlipException | IOException | DateTimeParseException e) {
            e.printStackTrace();
        }
    }
}