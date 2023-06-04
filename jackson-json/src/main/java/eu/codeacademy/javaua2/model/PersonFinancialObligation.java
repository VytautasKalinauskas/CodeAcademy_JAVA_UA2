package eu.codeacademy.javaua2.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.StringJoiner;

public class PersonFinancialObligation {
    private Person person;

    @JsonProperty("finOblg")
    private List<FinancialObligation> financialObligations;

    public PersonFinancialObligation() {
    }

    public Person getPerson() {
        return person;
    }

    public List<FinancialObligation> getFinancialObligations() {
        return financialObligations;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PersonFinancialObligation.class.getSimpleName() + "[", "]")
                .add("person=" + person)
                .add("financialObligations=" + financialObligations)
                .toString();
    }
}
