package com.myob.exercise.exceptions;

public class MissingParameterException extends PaySlipException {
    public MissingParameterException(String message) {
        super(message);
    }
}
