package manage;

public class JasonException extends Exception {
    private String msg;

    JasonException(String msg) {
        this.msg = msg;

    }

    public String Jsret() {
        return msg;
    }
}
