package eu.codeacademy.javaua2.model;

import java.util.StringJoiner;

public class Adresss {

    private CountryType country;
    private String city;

    public Adresss() {
    }

    public CountryType getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Adresss.class.getSimpleName() + "[", "]")
                .add("country='" + country + "'")
                .add("city='" + city + "'")
                .toString();
    }
}
