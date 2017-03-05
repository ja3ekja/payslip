package com.myob.exercise.model;

import java.math.BigDecimal;

/**
 * Created by HP on 2017-03-04.
 */
public class EmployeesPayslip {

    private Employee employee;
    private String dates;

    public EmployeesPayslip(Employee employee, String dates) {
        this.employee = employee;
        this.dates = dates;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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

    @Override
    public String toString() {
        return "EmployeesPayslip{" +
                "employee=" + employee +
                ", dates='" + dates + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeesPayslip that = (EmployeesPayslip) o;

        return employee.equals(that.employee);

    }

    @Override
    public int hashCode() {
        return employee.hashCode();
    }
}
