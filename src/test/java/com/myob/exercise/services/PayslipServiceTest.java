package com.myob.exercise.services;

import com.myob.exercise.model.Employee;
import com.myob.exercise.model.EmployeesPayslip;
import com.myob.exercise.model.Payslip;
import com.myob.exercise.model.TaxComponents;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by HP on 2017-03-05.
 */
public class PayslipServiceTest {

    private PayslipService payslipService;
    private EmployeesPayslip employeesPayslip;
    private Employee employee;
    private Payslip payslip;

    @Before
    public void generateEmployeesPayslip() {
        employee = new Employee("Jacek", "Feliksiak", new BigDecimal(85000), new Float(10));
        employeesPayslip = new EmployeesPayslip(employee, "1 SEPTEMBER");
        payslipService = new PayslipService();
        payslip = new Payslip("Jacek Feliksiak", new BigDecimal(7083), new BigDecimal(1616), new BigDecimal(5467), new BigDecimal(708));
        payslip.setPayPeriod("01 March - 31 March");
    }

    @Test
    public void calculateTest() {
        payslipService.calculate(employeesPayslip);
    }

    @Test
    public void calculateForSpecificLimitTest() {
        employeesPayslip.setDates("01 March - 31 March");
        assertEquals((Object) payslipService.calculate(employeesPayslip), (Object) payslip);
    }

    @Test
    public void calculateForDifferentOutputDataTest() {
        payslip.setName("David Rudd");
        assertNotEquals((Object) payslipService.calculate(employeesPayslip), (Object) payslip);
        payslip.setName("Jacek Feliksiak");
    }

    @Test
    public void calculateForDifferentInputDataTest() {
        employeesPayslip.getEmployee().setSuperRate(new Float(5));
        assertNotEquals((Object) payslipService.calculate(employeesPayslip), (Object) payslip);
        employeesPayslip.getEmployee().setSuperRate(new Float(10));
    }

    @Test
    public void getTaxConstantsTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = payslipService.getClass().getDeclaredMethod("getTaxConstants", BigDecimal.class);
        method.setAccessible(true); //Because of private modifier
        TaxComponents taxComponents = (TaxComponents) method.invoke(payslipService, new BigDecimal(85000));
        assertTrue(taxComponents.getFixTaxAmount().equals(new BigDecimal(17547)));
    }


}
