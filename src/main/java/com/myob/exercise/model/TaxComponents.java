package com.myob.exercise.model;

import java.math.BigDecimal;

/**
 * Created by HP on 2017-03-05.
 */
public class TaxComponents {
    private BigDecimal limit;
    private BigDecimal taxMultiplier;
    private BigDecimal fixTaxAmount;
    private BigDecimal lowerLimit;

    public TaxComponents(BigDecimal limit, BigDecimal taxMultiplier, BigDecimal fixTaxAmount, BigDecimal lowerLimit) {
        this.limit = limit;
        this.taxMultiplier = taxMultiplier;
        this.fixTaxAmount = fixTaxAmount;
        this.lowerLimit = lowerLimit;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

    public BigDecimal getTaxMultiplier() {
        return taxMultiplier;
    }

    public void setTaxMultiplier(BigDecimal taxMultiplier) {
        this.taxMultiplier = taxMultiplier;
    }

    public BigDecimal getFixTaxAmount() {
        return fixTaxAmount;
    }

    public void setFixTaxAmount(BigDecimal fixTaxAmount) {
        this.fixTaxAmount = fixTaxAmount;
    }

    public BigDecimal getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(BigDecimal lowerLimit) {
        this.lowerLimit = lowerLimit;
    }
}
