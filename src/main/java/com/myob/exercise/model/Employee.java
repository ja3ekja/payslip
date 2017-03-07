package com.myob.exercise.model;

import java.math.BigDecimal;

public class Employee extends Person {
    private BigDecimal annualSalary;
    private float superannuation;

    public Employee(String firstName, String lastName, BigDecimal annualSalary, float superannuation) {
        super(firstName, lastName);
        this.annualSalary = annualSalary;
        this.superannuation = superannuation;
    }

    public BigDecimal getAnnualSalary() {
        return annualSalary;
    }

    public float getSuperannuation() {
        return superannuation;
    }

    public void setSuperannuation(float superannuation) {
        this.superannuation = superannuation;
    }
}
