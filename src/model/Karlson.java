package model;

public class Karlson extends Personage implements KarlsonCome {
    String type = "—амое жуткое в мире привидение с мотором ";

    Karlson(String name) {
        super(name, "—амое жуткое в мире привидение с мотором ", true);
    }

    Karlson() {
        super(" арлсон", "—амое жуткое в мире привидение с мотором ", true);
    }

    /**
     * ѕо€витьс€ к обеду
     */
    public void comeTo(boolean f) {
        if (f) {
            System.out.println(this.getName() + ActionsAndAll.getDo(ActionsAndAll.Does.APPEAR, this.getIsMale()) + " только к обеду.");
        } else {
            System.out.println(this.getName() + " не" + ActionsAndAll.getDo(ActionsAndAll.Does.APPEAR, this.getIsMale()) + " даже к обеду.");
        }
    }

    /**
     * ѕо€витьс€ к другому времени
     */
    @Override
    public void comeTo(String time, boolean f) {
        if (f) {
            System.out.println(this.getName() + ActionsAndAll.getDo(ActionsAndAll.Does.APPEAR, this.getIsMale()) + " только к " + time + ".");
        } else {
            System.out.println(this.getName() + " не" + ActionsAndAll.getDo(ActionsAndAll.Does.APPEAR, this.getIsMale()) + " даже к " + time + ".");
        }
    }

    /**
     * прийти куда-то через что-то
     * или не прийти ;)
     */
    @Override
    public void comeThrough(ActionsAndAll.Place place, ActionsAndAll.Does doing, boolean f) {
        if (f) {
            System.out.println(this.getName() + ActionsAndAll.getDo(doing, this.getIsMale()) + ActionsAndAll.getPlace(place) + ".");
        } else {
            System.out.println(this.getName() + " не" + ActionsAndAll.getDo(doing, this.getIsMale()) + ActionsAndAll.getPlace(place) + ".");
        }
    }


    /**
     * ѕо€витьс€ как-то к обеду
     */
    public void comeTo(boolean f, ActionsAndAll.Mood m) {
        if (f) {
            System.out.println(this.getName() + ActionsAndAll.getMood(m) + ActionsAndAll.getDo(ActionsAndAll.Does.APPEAR, this.getIsMale()) + " только к обеду.");
        } else {
            System.out.println(this.getName() + ActionsAndAll.getMood(m) + " не" + ActionsAndAll.getDo(ActionsAndAll.Does.APPEAR, this.getIsMale()) + " даже к обеду.");
        }
    }

    /**
     * ѕо€витьс€ как-то к другому времени
     */
    @Override
    public void comeTo(String time, boolean f, ActionsAndAll.Mood m) {
        if (f) {
            System.out.println(this.getName() + ActionsAndAll.getMood(m) + ActionsAndAll.getDo(ActionsAndAll.Does.APPEAR, this.getIsMale()) + " только к " + time + ".");
        } else {
            System.out.println(this.getName() + ActionsAndAll.getMood(m) + " не" + ActionsAndAll.getDo(ActionsAndAll.Does.APPEAR, this.getIsMale()) + " даже к " + time + ".");
        }
    }

    /**
     * прийти куда-то как-то через что-то
     * или не прийти ;)
     */
    @Override
    public void comeThrough(ActionsAndAll.Place place, ActionsAndAll.Does doing, boolean f, ActionsAndAll.Mood m) {
        if (f) {
            System.out.println(this.getName() + ActionsAndAll.getMood(m) + ActionsAndAll.getDo(doing, this.getIsMale()) + ActionsAndAll.getPlace(place) + ".");
        } else {
            System.out.println(this.getName() + ActionsAndAll.getMood(m) + " не" + ActionsAndAll.getDo(doing, this.getIsMale()) + ActionsAndAll.getPlace(place) + ".");
        }
    }


    @Override
    public String toString() {
        return this.getName();
    }

    public void getFunOfIt() {
        System.out.println(" ƒавай пошалим?");
    }

}
