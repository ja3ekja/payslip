package com.myob.exercise.exceptions;

public class PersonNotFoundException extends PaySlipException {
    public PersonNotFoundException(String message) {
        super(message);
    }
}

