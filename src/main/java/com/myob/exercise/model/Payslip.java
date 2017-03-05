package com.myob.exercise.model;

import java.math.BigDecimal;

/**
 * Created by HP on 2017-03-05.
 */
public class Payslip {

    private String name;
    private String payPeriod;
    private BigDecimal grossIncome;
    private BigDecimal incomeTax;
    private BigDecimal netIncome;
    private BigDecimal superRate;

    public Payslip(String name, BigDecimal grossIncome, BigDecimal incomeTax, BigDecimal netIncome, BigDecimal superRate) {
        this.name = name;
        this.grossIncome = grossIncome;
        this.incomeTax = incomeTax;
        this.netIncome = netIncome;
        this.superRate = superRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPayPeriod() {
        return payPeriod;
    }

    public void setPayPeriod(String payPeriod) {
        this.payPeriod = payPeriod;
    }

    public BigDecimal getGrossIncome() {
        return grossIncome;
    }

    public void setGrossIncome(BigDecimal grossIncome) {
        this.grossIncome = grossIncome;
    }

    public BigDecimal getIncomeTax() {
        return incomeTax;
    }

    public void setIncomeTax(BigDecimal incomeTax) {
        this.incomeTax = incomeTax;
    }

    public BigDecimal getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(BigDecimal netIncome) {
        this.netIncome = netIncome;
    }

    public BigDecimal getSuperRate() {
        return superRate;
    }

    public void setSuperRate(BigDecimal superRate) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payslip payslip = (Payslip) o;

        if (!name.equals(payslip.name)) return false;
        if (!grossIncome.equals(payslip.grossIncome)) return false;
        if (!incomeTax.equals(payslip.incomeTax)) return false;
        if (!netIncome.equals(payslip.netIncome)) return false;
        return superRate.equals(payslip.superRate);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + grossIncome.hashCode();
        result = 31 * result + incomeTax.hashCode();
        result = 31 * result + netIncome.hashCode();
        result = 31 * result + superRate.hashCode();
        return result;
    }
}
