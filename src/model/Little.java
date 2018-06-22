package model;

public class Little extends Personage {
    String type = "Ребенок ";

    Little(String name) {
        super(name, "Ребенок ", true);

    }

    Little() {
        super("Малыш", "Ребенок ", true);
    }

    /**
     * Открыть дверь
     */
    public void runToOpen(boolean f) {
        if (f) {
            System.out.println(this.getName() + ActionsAndAll.getDo(ActionsAndAll.Does.RUN_TO_OPEN, this.getIsMale()) + ActionsAndAll.getSubj(ActionsAndAll.Subj.DOOR) + ".");
        } else {
            System.out.println(this.getName() + " не" + ActionsAndAll.getDo(ActionsAndAll.Does.RUN_TO_OPEN, this.getIsMale()) + ActionsAndAll.getSubj(ActionsAndAll.Subj.DOOR) + ".");
        }
    }

    /**
     * как-то Открыть дверь
     */
    public void runToOpen(boolean f, ActionsAndAll.Mood m) {
        if (f) {
            System.out.println(this.getName() + ActionsAndAll.getMood(m) + ActionsAndAll.getDo(ActionsAndAll.Does.RUN_TO_OPEN, this.getIsMale()) + ActionsAndAll.getSubj(ActionsAndAll.Subj.DOOR) + ".");
        } else {
            System.out.println(this.getName() + ActionsAndAll.getMood(m) + " не" + ActionsAndAll.getDo(ActionsAndAll.Does.RUN_TO_OPEN, this.getIsMale()) + ActionsAndAll.getSubj(ActionsAndAll.Subj.DOOR) + ".");
        }
    }

    @Override
    public String toString() {
        return this.getName();
    }

    public void think(boolean f, ActionsAndAll.Mood m, String what) {
        if (f) {
            System.out.println(this.getName() + ActionsAndAll.getMood(m) + ActionsAndAll.getDo(ActionsAndAll.Does.RESH, this.getIsMale()) + "'" + what + "'" + ".");
        } else {
            System.out.println(this.getName() + ActionsAndAll.getMood(m) + " не" + ActionsAndAll.getDo(ActionsAndAll.Does.RESH, this.getIsMale()) + "'" + what + "'" + ".");
        }
    }
}
