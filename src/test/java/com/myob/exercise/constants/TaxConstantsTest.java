package com.myob.exercise.constants;

import com.myob.exercise.model.Employee;
import com.myob.exercise.model.TaxComponents;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static javafx.scene.input.KeyCode.T;
import static org.junit.Assert.*;

/**
 * Created by HP on 2017-03-05.
 */
public class TaxConstantsTest {

    private List<TaxComponents> taxList ;

    @Before
    public void getTaxConstantsList(){
        taxList = TaxConstants.getTaxConstantsList();
    }

    @Test
    public void taxConstantsListTest() {
        assertNotNull(taxList);
    }

    @Test
    public void taxConstantsListCheckSizeTest() {
        assertTrue(taxList.size()==5);
    }

    @Test
    public void taxConstantsListCheckContentTest() {
        assertTrue(taxList.get(2).getTaxMultiplier().equals( new BigDecimal(0.325)));
    }
}
