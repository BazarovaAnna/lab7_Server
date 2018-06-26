package model;

import server.SampleServer;
import server.Windows1251Control;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Size {

    BIG("BIG", 3),
    MEDIUM("MEDIUM", 2),
    SMALL("SMALL", 1);

    public int sizeNum;
    private final String descr;


    Size(String s, int e) {
        ResourceBundle rb = ResourceBundle.getBundle("locale.Resources", SampleServer.locale, new Windows1251Control());
        descr = rb.getString(s);
        sizeNum = e;
    }

    @Override
    public String toString() {
        return descr;
    }
}
