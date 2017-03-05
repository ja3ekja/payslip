package com.myob.exercise.validators;

import com.myob.exercise.exceptions.InvalidDataException;
import com.myob.exercise.exceptions.MissingParameterException;
import com.myob.exercise.exceptions.PaySlipException;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class PayslipInputDataValidatorTest {

    @Test
    public void validateTest() throws PaySlipException {
        assertNotNull(PayslipDataValidator.validate(Arrays.asList("Jacek - Junior", "O'Neil", "70000", "10"), "1 March"));
    }

    @Test(expected = MissingParameterException.class)
    public void validateWrongParametersNumberTest() throws PaySlipException {
        PayslipDataValidator.validate(Arrays.asList("Jacek - Junior", "O'Neil", "70000"), "1 March");
    }

    @Test(expected = InvalidDataException.class)
    public void validateWithNullParameterTest() throws PaySlipException {
        PayslipDataValidator.validate(Arrays.asList("Jacek - Junior", "O'Neil", "", "10"), "01 March");
    }

    @Test(expected = InvalidDataException.class)
    public void validateWithEmptyStringTest() throws PaySlipException {
        PayslipDataValidator.validate(Collections.singletonList(""), "1 March");
    }

    @Test(expected = InvalidDataException.class)
    public void validateWithNullTest() throws PaySlipException {
        PayslipDataValidator.validate(null, "1 March");
    }

    @Test
    public void validateEmptyStringTest() {
        assertTrue(PayslipDataValidator.validateEmptyStringOrNull("myob"));
    }

    @Test
    public void validateEmptyStringWithEmptyStringTest() {
        assertFalse(PayslipDataValidator.validateEmptyStringOrNull(""));
    }

    @Test
    public void validateEmptyStringWithNullTest() {
        assertFalse(PayslipDataValidator.validateEmptyStringOrNull(null));
    }
}
