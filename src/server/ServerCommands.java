package server;

import manage.Commands;

import java.net.Socket;
import java.util.List;
import java.util.Map;

public class ServerCommands implements Runnable {
    private PansCollection pl;
    Socket s;
    private List<NewClient> Clients;
    //List<Thread> threads;
    private Map<Thread, StackTraceElement[]> threads;

    ServerCommands(PansCollection pl, List<NewClient> Clients, Map<Thread, StackTraceElement[]> threads) {
        this.pl = pl;
        //this.s=s;
        this.Clients = Clients;
        this.threads = threads;
    }

    @Override
    public synchronized void run() {
        String input;
        class ShutdownHook extends Thread {
            public void run() {
                Commands.write(pl.Mo);

            }
        }
        ShutdownHook shutdownHook = new ShutdownHook();
        Runtime.getRuntime().addShutdownHook(shutdownHook);
        //  ServerGui gui= new ServerGui(pl,Clients);
        //    gui.buildGui();


    }
}