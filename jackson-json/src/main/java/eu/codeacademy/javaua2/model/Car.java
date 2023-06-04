package eu.codeacademy.javaua2.model;

import java.util.StringJoiner;

public class Car {
    public String name;
    public int year;
    public int wheelCount;
    public int doorCount;

    public Car() {
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getWheelCount() {
        return wheelCount;
    }

    public int getDoorCount() {
        return doorCount;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Car.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("year=" + year)
                .add("wheelCount=" + wheelCount)
                .add("doorCount=" + doorCount)
                .toString();
    }
}

