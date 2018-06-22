package model;

public enum PansNames {
    PAN("pancakes", 1),
    CHOC("chocolate pancakes", 2),
    VANILLA("pancakes with vanilla", 3),
    BANANA("pancakes with banana", 4);

    int panNum;
    private final String descr;

    PansNames(String s, int e) {
        descr = s;
        panNum = e;
    }

    @Override
    public String toString() {
        return descr;
    }

}