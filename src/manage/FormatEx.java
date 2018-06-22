package manage;

public class FormatEx extends Exception {
    public void rem_ex() {
        System.out.println("No such element.");
    }

    public void form_ex() {
        System.out.println((char) 27 + "[31mERROR command's format. " + (char) 27 + "[0m");
    }
}
