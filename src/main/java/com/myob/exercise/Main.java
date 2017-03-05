package com.myob.exercise;

import com.myob.exercise.csv.CsvOperations;
import com.myob.exercise.exceptions.PaySlipException;
import com.myob.exercise.model.Employee;
import com.myob.exercise.model.Payslip;
import com.myob.exercise.model.PayslipInputData;
import com.myob.exercise.services.PayslipService;
import com.myob.exercise.validators.EmployeeValidator;
import com.myob.exercise.validators.PayslipDataValidator;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    private static Payslip payslip = null;

    public static void main(String[] args) {
        if (args.length == 4) {
            generatePayslip(args[0], args[1], args[2], args[3]);
        } else if (args.length == 3) {
            generatePayslip(args[0], args[1], args[2], resolvePath());
        } else {
            payslip = null;
            System.out.println("Invalid argument number (Should be 2 or 3: name, surname, filePath [Optional]).");
        }
        System.out.print(payslip == null ? "" : payslip);
    }

    private static void generatePayslip(String firstName, String lastName, String date, String filePath) {
        try {
            EmployeeValidator.validateName(firstName, lastName);
            PayslipDataValidator.validateDate(date);
            List<String> empData = CsvOperations.getEmployeeDataFromCSVFile(firstName, lastName, filePath);
            Employee emp = EmployeeValidator.validate(empData.get(0), empData.get(1), empData.get(2), empData.get(3));
            payslip = PayslipService.calculate(new PayslipInputData(emp, date));
        } catch (PaySlipException | IOException e) {
            e.printStackTrace();
        }
    }

    public static String resolvePath() {
        return Paths.get("").toAbsolutePath().resolve("..\\..\\Employees.csv").normalize().toString();
    }
}