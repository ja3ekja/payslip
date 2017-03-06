package com.myob.exercise.exceptions;

/**
 * Created by HP on 2017-03-06.
 */
public class WrongDateFormatException extends PaySlipException {
    public WrongDateFormatException(String message) {
        super(message);
    }
}
