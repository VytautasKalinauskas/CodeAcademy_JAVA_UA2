package eu.codeacademy.javaua2.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.StringJoiner;

public class PersonChildrenMap {

    private Person person;

    @JsonProperty("children")
    private Map<String, String> childrenMap;

    public PersonChildrenMap() {
    }

    public Person getPerson() {
        return person;
    }

    public Map<String, String> getChildrenMap() {
        return childrenMap;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PersonChildrenMap.class.getSimpleName() + "[", "]")
                .add("person=" + person)
                .add("childrenMap=" + childrenMap)
                .toString();
    }
}
