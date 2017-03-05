package com.myob.exercise.services;

import com.myob.exercise.model.Employee;
import com.myob.exercise.model.Payslip;
import com.myob.exercise.model.PayslipInputData;
import com.myob.exercise.model.TaxComponents;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PayslipServiceTest {

    private PayslipInputData payslipInputData;
    private Payslip payslip;

    @Before
    public void generateEmployeesPayslip() {
        Employee employee = new Employee("Jacek", "Feliksiak", new BigDecimal(85000), 10f);
        payslipInputData = new PayslipInputData(employee, "01 March - 31 March");
        payslip = new Payslip("Jacek Feliksiak", "01 March - 31 March", new BigDecimal(7083), new BigDecimal(1616), new BigDecimal(5467), new BigDecimal(708));
    }

    @Test
    public void calculateTest() {
        assertNotNull(PayslipService.calculate(payslipInputData));
    }

    @Test
    public void calculateForSpecificLimitTest() {
        payslipInputData.setDates("01 March - 31 March");
        assertEquals(PayslipService.calculate(payslipInputData), payslip);
    }


    @Test
    public void calculateForDifferentInputDataTest() {
        payslipInputData.getEmployee().setSuperRate(5f);
        assertNotEquals(PayslipService.calculate(payslipInputData), payslip);
        payslipInputData.getEmployee().setSuperRate(10f);
    }

    @Test
    public void getTaxConstantsTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = PayslipService.class.getDeclaredMethod("getTaxConstants", BigDecimal.class);
        method.setAccessible(true); //Because of private modifier
        TaxComponents taxComponents = (TaxComponents) method.invoke(PayslipService.class, new BigDecimal(85000));
        assertTrue(taxComponents.getFixTaxAmount().equals(new BigDecimal(17547)));
    }
}
