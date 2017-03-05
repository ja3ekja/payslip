package com.myob.exercise.model;

import java.math.BigDecimal;

public class Payslip {

    private String name;
    private String payPeriod;
    private BigDecimal grossIncome;
    private BigDecimal incomeTax;
    private BigDecimal netIncome;
    private BigDecimal superRate;

    public Payslip(String name, String payPeriod, BigDecimal grossIncome, BigDecimal incomeTax, BigDecimal netIncome, BigDecimal superRate) {
        this.name = name;
        this.payPeriod = payPeriod;
        this.grossIncome = grossIncome;
        this.incomeTax = incomeTax;
        this.netIncome = netIncome;
        this.superRate = superRate;
    }

    @Override
    public String toString() {
        return "Payslip{" +
                "name='" + name + '\'' +
                ", payPeriod='" + payPeriod + '\'' +
                ", grossIncome=" + grossIncome +
                ", incomeTax=" + incomeTax +
                ", netIncome=" + netIncome +
                ", superRate=" + superRate +
                '}';
    }

    public String toCSV() {
        return name + ";" + payPeriod + ";" + grossIncome + ";" + incomeTax + ";" + netIncome + ";" + superRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payslip payslip = (Payslip) o;

        if (!name.equals(payslip.name)) return false;
        if (!payPeriod.equals(payslip.payPeriod)) return false;
        if (!grossIncome.equals(payslip.grossIncome)) return false;
        if (!incomeTax.equals(payslip.incomeTax)) return false;
        if (!netIncome.equals(payslip.netIncome)) return false;
        return superRate.equals(payslip.superRate);

    }
}
