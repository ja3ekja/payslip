package com.myob.exercise.services;

import com.myob.exercise.exceptions.PaySlipException;
import com.myob.exercise.fileoperation.CsvOperations;
import com.myob.exercise.model.Payslip;
import com.myob.exercise.model.PayslipInputData;
import com.myob.exercise.model.TaxComponents;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.myob.exercise.constants.TaxConstants.*;

public class PayslipService {

    public static Payslip calculate(PayslipInputData slip) {
        String name = new StringBuilder(slip.getEmployee().getFirstName()).append(";").append(slip.getEmployee().getLastName()).toString();
        BigDecimal salary = slip.getEmployee().getAnnualSalary();
        BigDecimal empSuper = new BigDecimal(slip.getEmployee().getSuperRate());
        TaxComponents taxComponents = getTaxConstants(salary);
        BigDecimal monthlyGrossIncome = salary.divide(MONTHS, 0, RoundingMode.HALF_UP);
        BigDecimal taxIncome = salary.subtract(taxComponents.getLowerLimit()).multiply(taxComponents.getTaxMultiplier()).add(taxComponents.getFixTaxAmount()).divide(MONTHS, 0, RoundingMode.HALF_UP);
        BigDecimal netIncome = monthlyGrossIncome.subtract(taxIncome);
        BigDecimal valueSuperRate = monthlyGrossIncome.multiply(empSuper).divide(ONE_HUNDRED, 0, RoundingMode.HALF_UP);
        Payslip paySlip = new Payslip(name, slip.getStartDate(), slip.getEndDate(), monthlyGrossIncome, taxIncome, netIncome, valueSuperRate);
        return paySlip;
    }

    private static TaxComponents getTaxConstants(BigDecimal limit) {
        return getTaxConstantsList().stream().filter(tax -> tax.getLimit().compareTo(limit) >= 0).findFirst().orElseGet(TaxComponents::new);
    }

}
