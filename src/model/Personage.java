package model;

public abstract class Personage {
    private String name;
    private String type;
    private boolean isMale;


    Personage() {
        this.setName("NoName");
        this.setType("none");
        this.setIsMale(false);
    }

    Personage(String name, String type, boolean b) {
        this.setName(name);
        this.setType(type);
        this.setIsMale(b);
    }

    void setName(String name) {
        this.name = name;
    }

    private void setType(String type) {
        this.type = type;
    }

    private void setIsMale(boolean b) {
        this.isMale = b;
    }

    String getName() {
        return (this.name);
    }

    String getType() {
        return (this.type);
    }

    Boolean getIsMale() {
        return (this.isMale);
    }

    @Override
    public boolean equals(Object s) {
        if (s == null) {
            return false;
        }
        if (this == s) {
            return true;
        }
        if (!(getClass() == s.getClass())) {
            return false;
        } else {
            Personage tmp = (Personage) s;
            return (tmp.name.equals(name) && tmp.type.equals(type) && tmp.isMale == isMale);
        }
    }

    @Override
    public int hashCode() {
        final int power = 239;
        int hash = 0;
        for (int i = 0; i < name.length(); ++i) {
            hash = hash * power + (int) name.charAt(i);
        }

        for (int i = 0; i < type.length(); ++i) {
            hash = hash * power + (int) type.charAt(i);
        }
        if (isMale) {
            hash *= 2;
        } else if (!isMale) {
            hash *= 3;
        }
        return hash;
    }

    @Override
    public String toString() {
        return type + " " + name;
    }


}
