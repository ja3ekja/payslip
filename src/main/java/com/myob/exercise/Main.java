package com.myob.exercise;

import com.myob.exercise.model.EmployeesPayslip;
import com.myob.exercise.services.PayslipService;
import com.myob.exercise.utils.EmployeesPayslipTransform;

/**
 * Jacek Feliksiak
 */

public class Main {

    public static void main(String[] args) {
        String data = "David;Rudd;85000;10;01 March - 31 March";
        EmployeesPayslip employeesPayslip = new EmployeesPayslipTransform().transform(data);
        if (!(employeesPayslip == null))
            System.out.println(new PayslipService().calculate(employeesPayslip));
    }
}