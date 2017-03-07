package com.myob.exercise.services;

import com.myob.exercise.model.Payslip;
import com.myob.exercise.model.PayslipInputData;
import com.myob.exercise.model.TaxComponents;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import static com.myob.exercise.constants.TaxConstants.*;

public class PayslipService {

    public static Payslip calculate(PayslipInputData slip) {
        BigDecimal partMonthMultiplier = getMonthMultiplier(slip.getStartDate(), slip.getEndDate());
        String name = new StringBuilder(slip.getEmployee().getFirstName()).append(";").append(slip.getEmployee().getLastName()).toString();
        BigDecimal salary = slip.getEmployee().getAnnualSalary().multiply(partMonthMultiplier);
        BigDecimal empSuper = new BigDecimal(slip.getEmployee().getSuperannuation());
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

    public static BigDecimal getMonthMultiplier(LocalDate firstDate, LocalDate secondDate) {
        return new BigDecimal(secondDate.compareTo(firstDate)).add(BigDecimal.ONE).divide(new BigDecimal(firstDate.lengthOfMonth()),11,RoundingMode.UP);
    }
}
