package model;

public enum Size {
    BIG("huge", 3),
    MEDIUM("medium", 2),
    SMALL("small", 1);

    public int sizeNum;
    private final String descr;

    Size(String s, int e) {
        descr = s;
        sizeNum = e;
    }

    @Override
    public String toString() {
        return descr;
    }
}
