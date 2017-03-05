package com.myob.exercise.model;

import java.math.BigDecimal;

public class Employee {
    private String firstName;
    private String lastName;
    private BigDecimal annualSalary;
    private float superRate;

    public Employee(String firstName, String lastName, BigDecimal annualSalary, float superRate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.annualSalary = annualSalary;
        this.superRate = superRate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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
