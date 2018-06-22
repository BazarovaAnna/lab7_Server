package manage;

import model.Pancakes;
import model.PansNames;
import model.Size;

public class Parse {
    public static PansNames Name;
    public static Integer Id;
    public static Size Size;
    public static String Location;

    static void deserializeXML(String inputStr) throws XmlException {
        inputStr = inputStr.trim().toUpperCase();
        inputStr = inputStr.replaceAll("[\\s]{2,}", " ");
        int lenght = inputStr.length();
        if (inputStr.charAt(0) == '<' && inputStr.charAt(lenght - 1) == '>') {
            inputStr = inputStr.substring(1, lenght - 2);
            String[] fields = inputStr.split(" ");
            for (int i = 0; i < 4; i++) {
                String[] parametrs = fields[i].split("=");
                parametrs[1] = parametrs[1].replaceAll(" ", "");
                parametrs[1] = parametrs[1].substring(1, parametrs[1].length() - 1);
                switch (parametrs[0]) {
                    case "NAME":
                        Name = PansNames.valueOf(parametrs[1]);
                        break;
                    case "ID":
                        Id = Integer.valueOf(parametrs[1]);
                        break;
                    case "SIZE":
                        Size = Size.valueOf(parametrs[1]);
                        break;
                    case "LOCATION":
                        Location = parametrs[1];
                        break;


                }

            }


        } else
            throw new XmlException("Problem with XML format.");


    }


    static String serialize(Pancakes e) {
        String str;
        Integer id = e.id;
        if (e.id % 1 == 0) {
            str = "<NAME=\"" + e.name.name() + "\" SIZE=\"" + e.size.name() + "\" ID=\"" + id + "\" LOCATION=\"" + e.location + "\"/>\n";
        } else {
            str = "<NAME=\"" + e.name.name() + "\" SIZE=\"" + e.size.name() + "\" ID=\"" + id + "\" LOCATION=\"" + e.location + "\"/>\n";
        }
        return str;
    }


    static public void deserialaize(String comma) throws JasonException {
        int length = comma.length();
        if (comma.charAt(0) == '{' && comma.charAt(length - 1) == '}') {
            comma = comma.substring(1, length - 1);
            String[] atrib = comma.split(",");

            if (atrib.length != 4)
                throw new JasonException("Smth wrong with Json command format");

            String tempToken;
            String tempValue;

            for (int j = 0; j < atrib.length; j++) {
                length = atrib[j].length();
                tempToken = "";
                tempValue = "";
                int count = 0;

                for (int i = 0; i < length; i++) {
                    if (atrib[j].charAt(i) != '"') {
                        if (atrib[j].charAt(i) != ':') {
                            if (count > 2)
                                tempValue += atrib[j].charAt(i);
                            else tempToken += atrib[j].charAt(i);
                        }
                    } else {
                        count++;
                        if (count == 4) {
                            switch (tempToken) {
                                case "NAME":
                                    Name = PansNames.valueOf(tempValue);
                                    break;
                                case "SIZE":
                                    Size = Size.valueOf(tempValue);
                                    break;
                                case "ID":
                                    Id = Integer.valueOf(tempValue);
                                    break;
                                case "LOCATION":
                                    Location = tempValue;
                                    break;
                                default:
                                    throw new JasonException("Smth wrong with Json comand format");
                            }
                        }
                    }
                }
            }

        } else throw new JasonException("Smth wrong with Json comand format");
    }

}