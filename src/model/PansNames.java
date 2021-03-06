package model;

import server.SampleServer;
import server.Windows1251Control;

import java.util.Locale;
import java.util.ResourceBundle;

public enum PansNames {
    PAN("USUAL", 1),
    CHOC("CHOCOLATE", 2),
    VANILLA("VANILLA", 3),
    BANANA("BANANA", 4);

    int panNum;
    private final String descr;

    PansNames(String s, int e) {
        ResourceBundle rb = ResourceBundle.getBundle("locale.Resources", SampleServer.locale, new Windows1251Control());
        descr = rb.getString(s);
        panNum = e;
    }

    @Override
    public String toString() {
        return descr;
    }

}