package model;

public class FrekenBok extends Personage {
    String type = "ќтча€нна€ домохоз€йка ";

    FrekenBok(String name) {
        super(name, "ќтча€нна€ домохоз€йка ", false);

    }

    FrekenBok() {
        super("‘рекен Ѕок ", "ќтча€нна€ домохоз€йка ", false);

    }

    /**
     * сто€ть у плиты
     */
    public void stand(boolean f) {
        if (f) {
            System.out.println(this.getName() + ActionsAndAll.getDo(ActionsAndAll.Does.STAND, this.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN1) + ".");
        } else {
            System.out.println(this.getName() + " не" + ActionsAndAll.getDo(ActionsAndAll.Does.STAND, this.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN1) + ".");
        }
    }

    /**
     * печь блины
     */

    public void cookPans(ActionsAndAll.Subj food, boolean f) {
        if (f) {
            System.out.println(this.getName() + ActionsAndAll.getDo(ActionsAndAll.Does.COOK_TO_YU, this.getIsMale()) + ActionsAndAll.getSubj(ActionsAndAll.Subj.MORE_EASY) + " чем" + ActionsAndAll.getSubj(food) + ".");
        } else {
            System.out.println(this.getName() + " не" + ActionsAndAll.getDo(ActionsAndAll.Does.COOK_TO_YU, this.getIsMale()) + ActionsAndAll.getSubj(ActionsAndAll.Subj.MORE_EASY) + " чем" + ActionsAndAll.getSubj(food) + ".");
        }
    }

    /**
     * услышать голос за спиной
     */
    public void hearVoice(Personage p, boolean f) {
        if (f) {
            System.out.println(this.getName() + ActionsAndAll.getDo(ActionsAndAll.Does.HEAR, this.getIsMale()) + " голос " + p + ActionsAndAll.getPlace(ActionsAndAll.Place.BACK) + ".");
        } else {
            System.out.println(this.getName() + " не" + ActionsAndAll.getDo(ActionsAndAll.Does.HEAR, this.getIsMale()) + " голос " + p + ActionsAndAll.getPlace(ActionsAndAll.Place.BACK) + ".");
        }
    }

    /**
     * обернутьс€
     */
    public void turn(boolean f) {
        if (f) {
            System.out.println(this.getName() + ActionsAndAll.getDo(ActionsAndAll.Does.TURN, this.getIsMale()) + ".");
        } else {
            System.out.println(this.getName() + " не" + ActionsAndAll.getDo(ActionsAndAll.Does.TURN, this.getIsMale()) + ".");
        }
    }

    /**
     * выплеснула тесто
     */
    public void blub(boolean f) {
        if (f) {
            System.out.println(this.getName() + ActionsAndAll.getDo(ActionsAndAll.Does.SPLASH, this.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN2) + ActionsAndAll.getSubj(ActionsAndAll.Subj.POL_WITH_CAKE) + ".");
        } else {
            System.out.println(this.getName() + " не" + ActionsAndAll.getDo(ActionsAndAll.Does.SPLASH, this.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN2) + ActionsAndAll.getSubj(ActionsAndAll.Subj.POL_WITH_CAKE) + ".");
        }
    }

    /**
     * выплеснула не тесто
     */
    public void blub(boolean f, ActionsAndAll.Subj food) {
        if (f) {
            System.out.println(this.getName() + ActionsAndAll.getDo(ActionsAndAll.Does.SPLASH, this.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN2) + ActionsAndAll.getSubj(food) + ".");
        } else {
            System.out.println(this.getName() + " не" + ActionsAndAll.getDo(ActionsAndAll.Does.SPLASH, this.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN2) + ActionsAndAll.getSubj(food) + ".");
        }
    }


    /**
     * сто€ть как-то у плиты
     */
    public void stand(boolean f, ActionsAndAll.Mood m) {
        if (f) {
            System.out.println(this.getName() + ActionsAndAll.getMood(m) + ActionsAndAll.getDo(ActionsAndAll.Does.STAND, this.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN1) + ".");
        } else {
            System.out.println(this.getName() + ActionsAndAll.getMood(m) + " не" + ActionsAndAll.getDo(ActionsAndAll.Does.STAND, this.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN1) + ".");
        }
    }

    /**
     * печь как-то блины
     */

    public void cookPans(ActionsAndAll.Subj food, boolean f, ActionsAndAll.Mood m) {
        if (f) {
            System.out.println(this.getName() + ActionsAndAll.getMood(m) + ActionsAndAll.getDo(ActionsAndAll.Does.COOK_TO_YU, this.getIsMale()) + ActionsAndAll.getSubj(ActionsAndAll.Subj.MORE_EASY) + " чем" + ActionsAndAll.getSubj(food) + ".");
        } else {
            System.out.println(this.getName() + ActionsAndAll.getMood(m) + " не" + ActionsAndAll.getDo(ActionsAndAll.Does.COOK_TO_YU, this.getIsMale()) + ActionsAndAll.getSubj(ActionsAndAll.Subj.MORE_EASY) + " чем" + ActionsAndAll.getSubj(food) + ".");
        }
    }


    /**
     * как-то услышать голос за спиной
     */
    public void hearVoice(Personage p, boolean f, ActionsAndAll.Mood m) {
        if (f) {
            System.out.println(this.getName() + ActionsAndAll.getMood(m) + ActionsAndAll.getDo(ActionsAndAll.Does.HEAR, this.getIsMale()) + " голос " + p + ActionsAndAll.getPlace(ActionsAndAll.Place.BACK) + ".");
        } else {
            System.out.println(this.getName() + ActionsAndAll.getMood(m) + " не" + ActionsAndAll.getDo(ActionsAndAll.Does.HEAR, this.getIsMale()) + " голос " + p + ActionsAndAll.getPlace(ActionsAndAll.Place.BACK) + ".");
        }
    }

    /**
     * как-то обернутьс€
     */
    public void turn(boolean f, ActionsAndAll.Mood m) {
        if (f) {
            System.out.println(this.getName() + ActionsAndAll.getMood(m) + ActionsAndAll.getDo(ActionsAndAll.Does.TURN, this.getIsMale()) + ".");
        } else {
            System.out.println(this.getName() + ActionsAndAll.getMood(m) + " не" + ActionsAndAll.getDo(ActionsAndAll.Does.TURN, this.getIsMale()) + ".");
        }
    }

    /**
     * как-то выплеснула тесто
     */
    public void blub(boolean f, ActionsAndAll.Mood m) {
        if (f) {
            System.out.println(this.getName() + ActionsAndAll.getMood(m) + ActionsAndAll.getDo(ActionsAndAll.Does.SPLASH, this.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN2) + ActionsAndAll.getSubj(ActionsAndAll.Subj.POL_WITH_CAKE) + ".");
        } else {
            System.out.println(this.getName() + ActionsAndAll.getMood(m) + " не" + ActionsAndAll.getDo(ActionsAndAll.Does.SPLASH, this.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN2) + ActionsAndAll.getSubj(ActionsAndAll.Subj.POL_WITH_CAKE) + ".");
        }
    }

    /**
     * как-то выплеснула не тесто
     */
    public void blub(boolean f, ActionsAndAll.Subj food, ActionsAndAll.Mood m) {
        if (f) {
            System.out.println(this.getName() + ActionsAndAll.getMood(m) + ActionsAndAll.getDo(ActionsAndAll.Does.SPLASH, this.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN2) + ActionsAndAll.getSubj(food) + ".");
        } else {
            System.out.println(this.getName() + ActionsAndAll.getMood(m) + " не" + ActionsAndAll.getDo(ActionsAndAll.Does.SPLASH, this.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN2) + ActionsAndAll.getSubj(food) + ".");
        }
    }


    @Override
    public String toString() {
        return this.getName();
    }

}
