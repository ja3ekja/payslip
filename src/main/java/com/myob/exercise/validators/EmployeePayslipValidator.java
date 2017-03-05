package com.myob.exercise.validators;

import com.myob.exercise.exceptions.MissingParameterException;
import com.myob.exercise.exceptions.NameException;
import com.myob.exercise.exceptions.SalaryException;
import com.myob.exercise.exceptions.SuperRateException;
import com.myob.exercise.model.EmployeesPayslip;

import java.util.Arrays;

/**
 * Created by HP on 2017-03-04.
 */
public class EmployeePayslipValidator {

    private final String SEPARATOR = ";";
    private final String DATE_SEPARATOR = "-";

    public EmployeesPayslip validate(String data) {
        try {
            String[] empData = validateEmptyOrNullString(data).split(SEPARATOR);

            if (Arrays.asList(empData).stream().anyMatch(item -> item.equals("")))
                throw new NullPointerException("Each value should not be empty.");

            if (empData.length != 5)
                throw new MissingParameterException("Missing parameter. Should be name;surname;salary;super;date");
            EmployeesPayslip employeesPayslip = new EmployeesPayslip(new EmployeeValidator().validate(empData[0], empData[1], empData[2], empData[3]), validateDate(empData[4]));

            return employeesPayslip;
        } catch (NullPointerException | SalaryException | SuperRateException | NameException | MissingParameterException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String validateDate(String startDate) {

//        String[] date = startDate.split(DATE_SEPARATOR);
//        System.out.println(date[0].substring(0,2)+ " " + date[0].substring(3).trim());
//        StringBuilder sb = new StringBuilder().append().append(date[0].substring());
//                LocalDate.parse("2012, Month.MARCH");


//        LocalDate initial = LocalDate.of(2014, 2, 13);
//        LocalDate start = initial.withDayOfMonth(1);
//        LocalDate end = initial.withDayOfMonth(initial.lengthOfMonth());
//
//        Date date=new Date();
//        Calendar calendar = Calendar.getInstance();
//        date=calendar.getTime();
//        SimpleDateFormat s;
//        s=new SimpleDateFormat("MM/dd/yy");
//
//        System.out.println(s.format(date));
//
//        int days = 5;
//        for(int i=0;i<days;)
//        {
//            calendar.add(Calendar.DAY_OF_MONTH, 1);
//            //here even sat and sun are added
//            //but at the end it goes to the correct week day.
//            //because i is only increased if it is week day
//            if(calendar.get(Calendar.DAY_OF_WEEK)<=5)
//            {
//                i++;
//            }
//
//        }
//        date=calendar.getTime();
//        s=new SimpleDateFormat("MMM dd, yyyy");
//        System.out.println(s.format(date));
        return startDate;
    }

    public String validateEmptyOrNullString(String litteral) {
        if (litteral != null && !litteral.equals(""))
            return litteral;
        throw new NullPointerException("Value could not be empty.");
    }

}
