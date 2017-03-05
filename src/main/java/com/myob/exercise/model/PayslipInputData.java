package com.myob.exercise.model;

import java.math.BigDecimal;

public class PayslipInputData {

    private Employee employee;
    private String dates;

    public PayslipInputData(Employee employee, String dates) {
        this.employee = employee;
        this.dates = dates;
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public BigDecimal getAnnualSalary() {
        return employee.getAnnualSalary();
    }

}
