package manage;

import model.Pancakes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.TreeSet;

public class Commands {
    public static String get_all(Hashtable<Integer, Pancakes> P1, String data) {
        String output = "";
        if (data.equals("")) {
            for (Integer p1 : new TreeSet<>(P1.keySet())) {
                output = output + Parse.serialize(P1.get(p1));
            }
            output = output + "\nTotal:" + P1.size() + ".";
        } else {
            output = "**ERROR command's format.";
        }
        return output;
    }

    public static String get(Hashtable<Integer, Pancakes> Pl, String data) throws FormatEx {
        if (Commands.checkString(data)) {
            if (Integer.valueOf(data) > Pl.size()) {
                throw new FormatEx();
            } else
                return Parse.serialize(Pl.get(Integer.valueOf(data) - 1));
        } else
            throw new FormatEx();
    }

    public static String remove(Hashtable<Integer, Pancakes> Pl, String data) {
        try {
            Integer key = Integer.valueOf(data);
            Pl.remove(key);
            return "Object number " + key + " is deleted";
        } catch (Exception e) {
            return "The key must be integer number";
        }
    }

    public static String count(Hashtable<Integer, Pancakes> Pl, String data) {
        boolean f = true;
        if (data.equals(null) || data.equals("")) {
            f = false;
        }
        if (f) {
            return ("**ERROR command's format.");
        } else
            return ("The number of objects in collection = " + Pl.size());
    }

    /**
     * Заполняет коллекцию объектами типа Pancakes
     *
     * @param Pl - заполняемая коллекция
     * @throws XmlException -исключечение, вызываемое при неверном формате входного файла (формат файла XML)
     */
    public static void read(Hashtable<Integer, Pancakes> Pl) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("blins.xml"));
            String s1;
            while ((s1 = br.readLine()) != null) {
                Parse.deserializeXML(s1);
                Pancakes pp = new Pancakes(Parse.Size, Parse.Name, Parse.Id, Parse.Location);
                Pl.put(pp.id, pp);
            }
        } catch (XmlException e) {
            System.err.println(e);
        } catch (Exception ex) {
            System.out.println("Smth wrong with XML format\n" +
                    "PlS, delete \"carriage return\" at the end and at the begining of the file!!!");
        }
    }

    /**
     * Удалаяет из коллекции все объекты пaраметры которых соответствуют заданным
     *
     * @param Pl   - коллекция, из которой происходит удаление
     * @param data - параметры удаляемых объектов
     * @throws JasonException - исключение, вызываемое при неправильном формате параметров (Формат параметров Json)
     */
    public static String removeAll(Hashtable<Integer, Pancakes> Pl, String data) {
        boolean f = false;
        try {
            Parse.deserialaize(data);
        } catch (JasonException e) {
            System.out.println(e);
        }
        for (Integer i : new TreeSet<>(Pl.keySet())) {
            Pancakes pan = Pl.get(i);
            if (pan.name.equals(Parse.Name) && pan.id.equals(Parse.Id) && pan.size.equals(Parse.Size) && pan.location.equals(Parse.Location)) {
                Pl.remove(i);
                f = true;
            }
        }
        if (f) return ("Elements are removed");
        else
            return ("No such elements");
    }

    /**
     * Добавляет в коллекцию объект с заданными параметрами
     *
     * @param Pl   - коллекция, в которую добавляется объект
     * @param data - параметры объекта
     */
    public static String add(Hashtable<Integer, Pancakes> Pl, String data) {
        String output = "null";
        //System.out.println(data);
        try {
            Parse.deserialaize(data);
            Pancakes pan = new Pancakes(Parse.Size, Parse.Name, Parse.Id, Parse.Location);
            Pl.put(pan.id, pan);
            output = "Object is added";
        } catch (Exception e) {
            System.out.println(e);
        }
        return output;
    }

    /**
     * Добавляет объект в коллекцию при условии, если его размер наименьший
     *
     * @param Pl   - коллекция, в которую добавляется объект
     * @param data - параметры объекта
     */
    public static String add_if_min(Hashtable<Integer, Pancakes> Pl, String data) {
        String output = "null";
        try {
            Parse.deserialaize(data);
            int min = 2147483647;
            for (Integer i : new TreeSet<>(Pl.keySet())) {
                if (Pl.get(i).size.sizeNum < min) {
                    min = Pl.get(i).size.sizeNum;
                }
            }
            if (Parse.Size.sizeNum < min) {
                Pl.put(Parse.Id, new Pancakes(Parse.Size, Parse.Name, Parse.Id, Parse.Location));
                output = "Object is added";
            } else {
                output = "Object is not min";
            }
        } catch (JasonException e) {
            System.out.println(e);
        }
        return output;
    }

    /**
     * Сохраняет коллекцию в файл
     *
     * @param Pl -сохраняемая коллекция
     */
    public static void write(Hashtable<Integer, Pancakes> Pl) {
        try (PrintWriter pw = new PrintWriter("blins.xml")) {
            int i = 0;
            for (Integer key : new TreeSet<>(Pl.keySet())) {
                Pancakes o = Pl.get(key);
                pw.print(Parse.serialize(o));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Очищает коллекцию
     *
     * @param Pl -очищаемая коллекция
     */
    public static String clear(Hashtable<Integer, Pancakes> Pl) {
        Pl.clear();
        return "The collection is empty";
    }

    /**
     * insert {Integer key} {element}: добавить новый элемент с заданным ключом
     *
     * @param Pl    - коллекция над которой будет выполнено действие
     * @param data  - ключ
     * @param data1 - элемент
     */
    public static String insert(Hashtable<Integer, Pancakes> Pl, String data, String data1) {
        String output = "null";
        try {
            Integer key;
            try {
                key = Integer.valueOf(data);
            } catch (Exception e) {
                return "The key must be integer number";
            }
            Parse.deserialaize(data1);
            Pancakes pp = new Pancakes(Parse.Size, Parse.Name, Parse.Id, Parse.Location);
            Pl.put(key, pp);
            return "Object number " + key + " is inserted: " + pp;
        } catch (JasonException e) {
            System.out.println(e);
        }
        return output;
    }

    /**
     * Вызов помощи
     */
    public static String help() {
        System.out.println("Press 'q' to save and exit\n");
        System.out.println("\"save\" to save current collection\n");
        System.out.println("\"clear\" to clean up current collection\n");
        System.out.println('"' + "add_if_min {element}" + '"' + " to add element if value of size is minimal\n");
        System.out.println('"' + "remove_all {element}" + '"' + " to delete all elements equal to given\n");
        System.out.println('"' + "start" + '"' + " to launch a story program\n");
        System.out.println("\"count\" to show a number of items in the collection\n");
        System.out.println("\"get #\" to show an element with introduced index\n");
        System.out.println("\"get_all\" to show all elements of collection\n");
        System.out.println("\"remove #\" to delete an element with introduced index\n");
        return ("Press 'q' to save and exit\n" +
                "\"save\" to save current collection\n" +
                "\"clear\" to clean up current collection\n" +
                '"' + "add_if_min {element}" + '"' + " to add element if value of size is minimal\n" +
                '"' + "remove_all {element}" + '"' + " to delete all elements equal to given\n" +
                '"' + "remove_last" + '"' + " to delete last element of collection\n" +
                '"' + "start" + '"' + " to launch a story program\n" +
                "\"count\" to show a number of items in the collection\n" +
                "\"get №\" to show an element with introduced index\n" +
                "\"get_all\" to show all elements of collection\n" +
                "\"remove №\" to delete an element with introduced index\n");
    }

    private static boolean checkString(String string) {
        if (string == null) return false;
        return string.matches("^-?\\d+$");
    }
}
