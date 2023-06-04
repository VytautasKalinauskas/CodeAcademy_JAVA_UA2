package eu.codeacademy.javaua2.model;

import java.math.BigDecimal;
import java.util.StringJoiner;

public class FinancialObligation {
    private String name;
    private BigDecimal amount = BigDecimal.ZERO;

    public FinancialObligation() {
    }

    public String getName() {
        return name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", FinancialObligation.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("amount=" + amount)
                .toString();
    }
}
