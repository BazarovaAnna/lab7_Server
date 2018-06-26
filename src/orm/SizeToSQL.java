package orm;
@Table(name = "SizeToSQL")
public enum SizeToSQL {
    BIG("BIG"),
    MEDIUM("MEDIUM"),
    SMALL("SMALL");

    @PrimaryKey
    @Column(name = "size")
    private String name;
    public String getName() {
        return name;
    }
    SizeToSQL(String name){
        this.name=name;
    }



    @Override
    public String toString() {
        return this.getName();
    }
}