package eu.codeacademy.javaua2.innerclass;

import lombok.Value;

@Value
public class CPU {

    double price;

    public String printInfo() {
        return new Info().get();
    }

    @Value
    public class Processor {

        double cores;
        String manufacturerName;
    }

    @Value
    public static class RAM {

        double memory;
        String manufacturerName;
    }

    private class Info {
        String get() {
            return "Some Info about our price " + price;
        }
    }
}
