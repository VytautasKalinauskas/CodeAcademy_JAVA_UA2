package eu.codeacademy.javaua2.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.StringJoiner;

public class PersonObligationMap {

    private Person person;

    @JsonProperty("obligations")
    private Map<String, FinancialObligation> obligationMap;

    public PersonObligationMap() {
    }

    public Person getPerson() {
        return person;
    }

    public Map<String, FinancialObligation> getObligationMap() {
        return obligationMap;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PersonObligationMap.class.getSimpleName() + "[", "]")
                .add("person=" + person)
                .add("obligationMap=" + obligationMap)
                .toString();
    }
}
