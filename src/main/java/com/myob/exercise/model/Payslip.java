package com.myob.exercise.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Payslip {

    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal grossIncome;
    private BigDecimal incomeTax;
    private BigDecimal netIncome;
    private BigDecimal superRate;

    public Payslip(String name, LocalDate startDate, LocalDate endDate, BigDecimal grossIncome, BigDecimal incomeTax, BigDecimal netIncome, BigDecimal superRate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.grossIncome = grossIncome;
        this.incomeTax = incomeTax;
        this.netIncome = netIncome;
        this.superRate = superRate;
    }

    @Override
    public String toString() {
        return name + ";" + startDate + ";" + endDate + ";" + grossIncome + ";" + incomeTax + ";" + netIncome + ";" + superRate;
    }
    public static String toCSVHeader(){
        return "name;startDate;endDate;grossIncome;incomeTax;netIncome;superRate";
    }
}
