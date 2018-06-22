package server;

import manage.Commands;

public class TimeSave implements Runnable {
    private PansCollection pl;

    TimeSave(PansCollection pl) {
        this.pl = pl;
    }

    @Override

    public synchronized void run() {
        while (true) {
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                //DO NOTHING
            }
            Commands.write(pl.Mo);
        }
    }
}