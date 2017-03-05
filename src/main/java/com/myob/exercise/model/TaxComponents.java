package com.myob.exercise.model;

import java.math.BigDecimal;

public class TaxComponents {
    private BigDecimal limit;
    private BigDecimal taxMultiplier;
    private BigDecimal fixTaxAmount;
    private BigDecimal lowerLimit;

    public TaxComponents() {
    }

    public TaxComponents(BigDecimal limit, BigDecimal taxMultiplier, BigDecimal fixTaxAmount, BigDecimal lowerLimit) {
        this.limit = limit;
        this.taxMultiplier = taxMultiplier;
        this.fixTaxAmount = fixTaxAmount;
        this.lowerLimit = lowerLimit;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public BigDecimal getTaxMultiplier() {
        return taxMultiplier;
    }

    public BigDecimal getFixTaxAmount() {
        return fixTaxAmount;
    }

    public BigDecimal getLowerLimit() {
        return lowerLimit;
    }

}
