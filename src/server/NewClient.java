package server;

import manage.Commands;
import manage.FormatEx;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Iterator;
import java.util.List;

class NewClient implements Runnable {
    private PansCollection pl;
    private static Socket s;
    private int num;
    private String name;
    private List<NewClient> Clients;

    public String getName() {
        return name;
    }

    NewClient(int num, PansCollection pl, Socket s, List<NewClient> Clients) {
        this.pl = pl;
        this.s = s;
        this.num = num;
        this.Clients = Clients;
    }

    public synchronized void run() {
        try {
            //System.out.println("**Connection accepted");
            // из сокета клиента берём поток входящих данных
            InputStream is = s.getInputStream();
            // и оттуда же - поток данных от сервера к клиенту
            OutputStream os = s.getOutputStream();
            // буффер данных в 64 килобайта
            byte buf[];
            buf = new byte[1024 * 1024];
            is.read(buf);
            name = new String(buf, "UTF-8");
            name = name.trim();
            if (name.equals("noName")) name = String.valueOf(num);
            System.out.println("**Client " + name + " is connected");
            while (true) {
                buf = new byte[64 * 1024];
                // читаем 64кб от клиента, результат - кол-во реально принятых данных
                is.read(buf);
                // создаём строку, содержащую полученную от клиента информацию

                String inStr = new String(buf, "UTF-8");
                String command;
                String perem = "";
                String perem2 = "";
                inStr = inStr.trim().toLowerCase();
                inStr = inStr.replaceAll("[\\s]{2,}", " ");
                if ((inStr.indexOf('{') != -1) && (inStr.lastIndexOf('}') != -1) && inStr.indexOf('{') != 0) {
                    command = inStr.substring(0, inStr.indexOf('{'));
                    perem = inStr.substring(inStr.indexOf('{') + 1, inStr.lastIndexOf('}'));
                } else if (inStr.contains(" ")) {
                    String[] com = inStr.split(" ");
                    if (com[1].equals("")) {
                        os.write("**ERROR command's format.".getBytes());
                        continue;
                    }
                    command = com[0];
                    perem = com[1];
                    if (com.length > 2) {
                        for (int i = 2; i < com.length; i++) {
                            perem2 = perem2 + com[i] + " ";
                        }
                    }
                    perem2 = perem2.trim();
                } else
                    switch (inStr) {
                        case "get":
                        case "remove":
                            os.write("ERROR command's format.".getBytes());
                            continue;
                        default:
                            command = inStr;
                    }
                try {
                    System.out.println("**" + command.trim());
                    switch (command.trim()) {
                        case "closeClient":
                            Commands.write(pl.Mo);
                            Iterator<NewClient> iter = Clients.iterator();
                            while (iter.hasNext()) {
                                NewClient cl = iter.next();
                                if (cl.name.equals(name)) {
                                    iter.remove();
                                    System.out.println("Client " + name + " is disconnected");
                                }
                            }
                            break;
                        case "get_all":
                            os.write(Commands.get_all(pl.Mo, perem).getBytes());
                            break;
                        case "get":
                            os.write(Commands.get(pl.Mo, perem).getBytes());
                            break;
                        case "remove":
                            os.write(Commands.remove(pl.Mo, perem).getBytes());
                            break;
                        case "count":
                            os.write(Commands.count(pl.Mo, perem).getBytes());
                            break;
                        case "clear":
                            os.write(Commands.clear(pl.Mo).getBytes());
                            break;
                        case "remove_all":
                            os.write(Commands.removeAll(pl.Mo, "{" + perem + "}").getBytes());
                            break;
                        case "add":
                            if (!Commands.add(pl.Mo, "{" + perem + "}").equals("null")) {
                                os.write(Commands.add(pl.Mo, perem).getBytes());
                            } else continue;
                            break;
                        case "add_if_min":
                            if (!Commands.add_if_min(pl.Mo, "{" + perem + "}").equals("null")) {
                                os.write(Commands.add_if_min(pl.Mo, "{" + perem + "}").getBytes());
                            } else continue;
                            break;
                        case "help":
                            os.write(Commands.help().getBytes());
                            break;
                        case "save":
                            Commands.write(pl.Mo);
                            break;
                        case "insert":
                            Commands.insert(pl.Mo, perem, perem2);
                            break;
                        default:
                            os.write("**Unknown command".getBytes());
                    }
                    if (command.equals("closeClient")) break;
                } catch (SocketException e) {
                    //DO NOTHING
                } catch (ArrayIndexOutOfBoundsException e) {
                    os.write("No such element(ArrayIndexOutOfBoundsException)".getBytes());
                } catch (FormatEx e) {
                    os.write("smth wrong with comand format".getBytes());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            System.out.println("init error: " + e);
        } // вывод исключений
    }
}
