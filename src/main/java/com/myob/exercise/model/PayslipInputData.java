package com.myob.exercise.model;

import java.time.LocalDate;

public class PayslipInputData {

    private Employee employee;
    private LocalDate startDate;
    private LocalDate endDate;

    public PayslipInputData(Employee employee, LocalDate startDate, LocalDate endDate) {
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
