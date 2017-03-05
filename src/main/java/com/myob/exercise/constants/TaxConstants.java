package com.myob.exercise.constants;

import com.myob.exercise.model.TaxComponents;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * Created by HP on 2017-03-05.
 */
public class TaxConstants {

    public final static BigDecimal MONTHS = new BigDecimal(12);
    public final static BigDecimal ONE_HUNDRED = new BigDecimal(100);
    private final static BigDecimal ZERO = BigDecimal.ZERO;
    private final static BigDecimal RELATIVE_MAX = BigDecimal.valueOf(Integer.MAX_VALUE);

    private final static BigDecimal FIRST_LIMIT = new BigDecimal(18200);
    private final static BigDecimal SECOND_LIMIT = new BigDecimal(37000);
    private final static BigDecimal THIRD_LIMIT = new BigDecimal(80000);
    private final static BigDecimal FOURTH_LIMIT = new BigDecimal(180000);

    private final static BigDecimal FIRST_TAX_MULTIPLIER = new BigDecimal(0.19);
    private final static BigDecimal SECOND_TAX_MULTIPLIER = new BigDecimal(0.325);
    private final static BigDecimal THIRD_TAX_MULTIPLIER = new BigDecimal(0.37);
    private final static BigDecimal FOURTH_TAX_MULTIPLIER = new BigDecimal(0.45);

    private final static BigDecimal FIRST_TAX_FEE = new BigDecimal(3572);
    private final static BigDecimal SECOND_TAX_FEE = new BigDecimal(17547);
    private final static BigDecimal THIRD_TAX_FEE = new BigDecimal(54547);

    public static List<TaxComponents> getTaxConstantsList() {
        return Arrays.asList(
                new TaxComponents(FIRST_LIMIT,  ZERO,                  ZERO,           ZERO),
                new TaxComponents(SECOND_LIMIT, FIRST_TAX_MULTIPLIER,  ZERO,           FIRST_LIMIT),
                new TaxComponents(THIRD_LIMIT,  SECOND_TAX_MULTIPLIER, FIRST_TAX_FEE,  SECOND_LIMIT),
                new TaxComponents(FOURTH_LIMIT, THIRD_TAX_MULTIPLIER,  SECOND_TAX_FEE, THIRD_LIMIT),
                new TaxComponents(RELATIVE_MAX, FOURTH_TAX_MULTIPLIER, THIRD_TAX_FEE,  FOURTH_LIMIT)
        );
    }
}
