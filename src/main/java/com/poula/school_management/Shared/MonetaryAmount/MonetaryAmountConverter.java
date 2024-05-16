package com.poula.school_management.Shared.MonetaryAmount;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.math.BigDecimal;

@Converter(autoApply = true)
public class MonetaryAmountConverter implements AttributeConverter<MonetaryAmount, BigDecimal> {

    @Override
    public BigDecimal convertToDatabaseColumn(MonetaryAmount monetaryAmount) {
        return monetaryAmount.asBigDecimal();
    }

    @Override
    public MonetaryAmount convertToEntityAttribute(BigDecimal bigDecimal) {
        return new MonetaryAmount(bigDecimal);
    }
}
