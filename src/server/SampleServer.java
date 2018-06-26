package server;

import manage.Commands;
import orm.DatabaseProtocol;
import orm.ManagerORM;
import orm.PansDataBase;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class SampleServer //extends Thread
{
    static private Socket s;
    static private int num = 0;
    private static List<NewClient> Clients = new ArrayList();
    private static Map<Thread, StackTraceElement[]> threads = Thread.getAllStackTraces();
    public static PansCollection pl;
    public static Locale locale=Locale.getDefault();
    public static ServerGUI sgui;

    public static void main(String args[]) {
        DatabaseProtocol.getData();

        ManagerORM<PansDataBase> managerORM = new ManagerORM<>(PansDataBase.class, DatabaseProtocol.url, DatabaseProtocol.login, DatabaseProtocol.password);
        managerORM.create();
        managerORM.insert(new PansDataBase(1, new PansDataBase(2, null)));
        //создание коллекции и заполнение
        Locale.setDefault(locale);
        pl = new PansCollection();
        Commands.read(pl.Mo);
        sgui = new ServerGUI();
        sgui.start();
        try {   //инициализация сокета
            ServerSocket server = new ServerSocket(8891, 0,
                    InetAddress.getByName("localhost"));

            System.out.println("**Server is started");
            //поток обработки команд сервера
            new Thread(new ServerCommands(pl, Clients, threads)).start();
            new Thread(new TimeSave(pl)).start();

            while (true) {

                // ждём нового подключения, после чего запускаем обработку клиента
                // в новый вычислительный поток
                new SampleServer(num, pl, server.accept());
                num++;

            }
        } catch (Exception e) {
            e.printStackTrace();
        } // вывод исключений

    }

    private SampleServer(int num, PansCollection pl, Socket s) {

        this.num = num;
        this.s = s;

        // и запускаем новый вычислительный поток (см. ф-ю run())

        NewClient nk = new NewClient(num, pl, s, Clients);
        Clients.add(nk);
        Thread NK = new Thread(nk);
        NK.start();
        new Thread(nk).start();

    }


}
