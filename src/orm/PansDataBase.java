package orm;

@Table(name = "PansCollection")
public class PansDataBase {
    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "size")
    private SizeToSQL size;

    @Column(name = "name")
    private NameToSQL name;

    @Column(name = "location")
    public String location;

    @Column(name = "time")
    public String time;

    @Column(name = "color")
    public String color;

    public PansDataBase(int id, PansDataBase pans){
        this.id=id;
        this.name=NameToSQL.PAN;
        this.size=SizeToSQL.SMALL;


    }

    public NameToSQL getName() {
        return name;
    }

    public SizeToSQL getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

}