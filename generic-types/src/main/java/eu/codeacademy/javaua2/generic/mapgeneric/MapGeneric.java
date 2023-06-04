package eu.codeacademy.javaua2.generic.mapgeneric;

public class MapGeneric<T, R> {

    public R get(R result) {
        return result;
    }

    public String getAsStringResult(R result) {
        return result + "(modified)";
    }

    public String getAsString(T type) {
        return type.toString();
    }

}
