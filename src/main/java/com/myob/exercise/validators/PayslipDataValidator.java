package com.myob.exercise.validators;

import com.myob.exercise.exceptions.InvalidDataException;
import com.myob.exercise.exceptions.MissingParameterException;
import com.myob.exercise.exceptions.PaySlipException;
import com.myob.exercise.model.PayslipInputData;

import java.util.List;

public class PayslipDataValidator {

    public static PayslipInputData validate(List<String> employeeData, String date) throws PaySlipException {

        if (employeeData == null || !employeeData.stream().allMatch(PayslipDataValidator::validateEmptyStringOrNull))
            throw new InvalidDataException("Value could not be empty.");

        if (employeeData.size() != 4)
            throw new MissingParameterException("Missing parameter in CSV File. Should be name;surname;salary;super");

        return new PayslipInputData(EmployeeValidator.validate(employeeData.get(0), employeeData.get(1), employeeData.get(2), employeeData.get(3)), validateDate(date));

    }

    public static String validateDate(String startDate) {

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

    static boolean validateEmptyStringOrNull(String litteral) {
        return litteral != null && !litteral.trim().equals("");
    }
}
