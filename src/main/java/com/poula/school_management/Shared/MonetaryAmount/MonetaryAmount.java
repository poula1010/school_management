package com.poula.school_management.Shared.MonetaryAmount;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Embeddable
public class MonetaryAmount implements Serializable {
    private static final long serialVersionUID = -3734467432803577280L;

    private BigDecimal value;

    @JsonCreator
    public MonetaryAmount(BigDecimal value) {
        initValue(value);
    }
    private MonetaryAmount() {
    }
    public MonetaryAmount(double value){initValue(BigDecimal.valueOf(value));}

    private void initValue(BigDecimal value){this.value = value.setScale(2, RoundingMode.HALF_EVEN);}

    public static MonetaryAmount valueOf(String string) {
        if (string == null || string.isEmpty()) {
            throw new IllegalArgumentException("The monetary amount value is required");
        }
        if (string.startsWith("$")) {
            int index = string.indexOf('$');
            string = string.substring(index + 1);
        }
        BigDecimal value = new BigDecimal(string);
        return new MonetaryAmount(value);
    }
    public static MonetaryAmount zero() {
        return new MonetaryAmount(0);
    }

    /**
     * Add to this monetary amount, returning the sum as a new monetary amount.
     * @param amount the amount to add
     * @return the sum
     */
    public MonetaryAmount add(MonetaryAmount amount) {
        return new MonetaryAmount(value.add(amount.value));
    }

    /**
     * Subtract from this monetary amount, returning the difference as a new monetary amount.
     * @param amount the amount to subtract
     * @return the difference
     */
    public MonetaryAmount subtract(MonetaryAmount amount) {
        return new MonetaryAmount(value.subtract(amount.value));
    }

    /**
     * Multiply this monetary amount, returning the product as a new monetary amount.
     * @param amount the amount to multiply
     * @return the product
     */
    public MonetaryAmount multiplyBy(BigDecimal amount) {
        return new MonetaryAmount(value.multiply(amount));
    }

    public BigDecimal divide(MonetaryAmount amount) {
        return value.divide(amount.value);
    }

    /**
     * Divide this monetary amount, returning the quotient as a new monetary amount.
     * @param amount the amount to divide by
     * @return the quotient
     */
    public MonetaryAmount divideBy(BigDecimal amount) {
        return new MonetaryAmount(value.divide(amount));
    }


    @JsonValue
    public BigDecimal asBigDecimal() {
        return value;
    }

    public boolean equals(Object o) {
        if (!(o instanceof MonetaryAmount)) {
            return false;
        }
        return value.equals(((MonetaryAmount) o).value);
    }
    public boolean greaterThan(MonetaryAmount amount) {
        return value.compareTo(amount.value) > 0;
    }

    /**
     * Get this amount as a double. Useful for when a double type is needed by an external API or system.
     * @return this amount as a double
     */
    public double asDouble() {
        return value.doubleValue();
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
    @Override
    public String toString() {
        return "$" + value.toString();
    }
}
