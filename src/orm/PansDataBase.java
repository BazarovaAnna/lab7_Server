package orm;

import model.PansNames;
import model.Size;

@Table(name = "PansCollection")
public class PansDataBase {
    @PrimaryKey
    @Column(name = "id")
    private int id;

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

    public PansDataBase(int id, PansNames name, Size size, String location, String time, String color){
        this.id=id;
        switch(name){
            case PAN:
                this.name=NameToSQL.PAN;
                break;
            case CHOC:
                this.name=NameToSQL.CHOC;
                break;
            case BANANA:
                this.name=NameToSQL.BANANA;
                break;
            case VANILLA:
                this.name=NameToSQL.VANILLA;
                break;
        }
        switch (size){
            case BIG:
                this.size=SizeToSQL.BIG;
                break;
            case SMALL:
                this.size=SizeToSQL.SMALL;
                break;
            case MEDIUM:
                this.size=SizeToSQL.MEDIUM;
                break;
        }
        this.color=color;
        this.location=location;
        this.time=time;


    }

    public NameToSQL getName() {
        return name;
    }

    public SizeToSQL getSize() {
        return size;
    }


}