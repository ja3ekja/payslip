package com.myob.exercise;

import com.myob.exercise.csv.CsvOperations;
import com.myob.exercise.model.EmployeesPayslip;
import com.myob.exercise.services.PayslipService;
import com.myob.exercise.utils.EmployeesPayslipTransform;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Jacek Feliksiak
 */

public class Main {


    public static void main(String[] args) {

        //String data = "Jordan;Brady;85000;10;01 March - 31 March";//

       // Path currentPath = Paths.get("").toAbsolutePath().resolve("..\\..").normalize();
        Path currentPath = Paths.get("").toAbsolutePath();
        Path filePath = currentPath.resolve("Employee.csv");
        System.out.println(filePath);
        if (Files.exists(filePath)) {
            String data = new CsvOperations().getEmployeeDataFromCSVFile(filePath.toString(), "Maggy", "Walton");
            if (data != null && !data.isEmpty()) {
                EmployeesPayslip employeesPayslip = new EmployeesPayslipTransform().transform(data);
                if (!(employeesPayslip == null))
                    System.out.println(new PayslipService().calculate(employeesPayslip));
            }
        }
    }
}