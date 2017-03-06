package com.myob.exercise.model;

import java.math.BigDecimal;

public class Employee extends Person {
    private BigDecimal annualSalary;
    private float superRate;

    public Employee(String firstName, String lastName, BigDecimal annualSalary, float superRate) {
        super(firstName, lastName);
        this.annualSalary = annualSalary;
        this.superRate = superRate;
    }

    public BigDecimal getAnnualSalary() {
        return annualSalary;
    }

    public float getSuperRate() {
        return superRate;
    }

    public void setSuperRate(float superRate) {
        this.superRate = superRate;
    }
}
