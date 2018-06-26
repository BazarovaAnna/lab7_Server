package orm;
@Table(name = "NameToSQL")
public enum NameToSQL {
    PAN("USUAL"),
    CHOC("CHOCOLATE"),
    VANILLA("VANILLA"),
    BANANA("BANANA");

    @PrimaryKey
    @Column(name = "name")
    private String name;
    public String getName() {
        return name;
    }
    NameToSQL(String name){
        this.name=name;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}