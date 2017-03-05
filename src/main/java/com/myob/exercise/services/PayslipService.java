package com.myob.exercise.services;

import com.myob.exercise.model.EmployeesPayslip;
import com.myob.exercise.model.Payslip;
import com.myob.exercise.model.TaxComponents;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.myob.exercise.constants.TaxConstants.*;

/**
 * Created by HP on 2017-03-04.
 */
public class PayslipService {

    Payslip payslip;

    public Payslip calculate(EmployeesPayslip emp) {
        String name = new StringBuilder(emp.getEmployee().getFirstName()).append(" ").append(emp.getEmployee().getLastName()).toString();
        BigDecimal salary = emp.getAnnualSalary();
        BigDecimal empSuper = new BigDecimal(emp.getEmployee().getSuperRate());
        TaxComponents taxComponents = getTaxConstants(salary);
        BigDecimal grossIncome = salary.divide(MONTHS, 0, RoundingMode.HALF_UP);
        BigDecimal taxIncome = salary.subtract(taxComponents.getLowerLimit()).multiply(taxComponents.getTaxMultiplier()).add(taxComponents.getFixTaxAmount()).divide(MONTHS, 0, RoundingMode.HALF_UP);
        BigDecimal netIncome = grossIncome.subtract(taxIncome);
        BigDecimal valueSuperRate = grossIncome.multiply(empSuper).divide(ONE_HUNDRED, 0, RoundingMode.HALF_UP);

        //System.out.println(grossIncome + " " + taxIncome + " " + netIncome + " " + superRate);

        payslip = new Payslip(name, grossIncome, taxIncome, netIncome, valueSuperRate);
        payslip.setPayPeriod(emp.getDates());

        return payslip;
    }

    private TaxComponents getTaxConstants(BigDecimal limit) {
        return getTaxConstantsList().stream().filter(tax -> tax.getLimit().compareTo(limit) >= 0).findFirst().get();
    }

}
