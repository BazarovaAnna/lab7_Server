package model;

public interface PossibleActions extends KarlsonCome {
    @SuppressWarnings("serial")
    class LogicException extends Exception {
        LogicException(String message) {
            super(message);
        }
    }

    /**
     * Появиться к обеду
     */
    static void comeTo(Personage q, boolean f) {

        if (f) {
            System.out.println(q.getName() + ActionsAndAll.getDo(ActionsAndAll.Does.APPEAR, q.getIsMale()) + " только к обеду.");
        } else {
            System.out.println(q.getName() + " не" + ActionsAndAll.getDo(ActionsAndAll.Does.APPEAR, q.getIsMale()) + " даже к обеду.");
        }
    }

    /**
     * Появиться к другому времени
     */

    static void comeTo(Personage q, String time, boolean f) {
        if (f) {
            System.out.println(q.getName() + ActionsAndAll.getDo(ActionsAndAll.Does.APPEAR, q.getIsMale()) + " только к " + time + ".");
        } else {
            System.out.println(q.getName() + " не" + ActionsAndAll.getDo(ActionsAndAll.Does.APPEAR, q.getIsMale()) + " даже к " + time + ".");
        }
    }

    /**
     * прийти куда-то через что-то
     * или не прийти ;)
     *
     * @throws LogicException летает только карлсон
     */

    static void comeThrough(Personage q, ActionsAndAll.Place place, ActionsAndAll.Does doing, boolean f) throws LogicException {
        if ((!q.getType().equals("Самое жуткое в мире привидение с мотором ")) && doing == ActionsAndAll.Does.FLY)
            throw new LogicException("Летает только Карлсон, ататай");
        if (f) {
            System.out.println(q.getName() + ActionsAndAll.getDo(doing, q.getIsMale()) + ActionsAndAll.getPlace(place) + ".");
        } else {
            System.out.println(q.getName() + " не" + ActionsAndAll.getDo(doing, q.getIsMale()) + ActionsAndAll.getPlace(place) + ".");
        }
    }

    /**
     * Открыть дверь
     */
    static void runToOpen(Personage q, boolean f) {
        if (f) {
            System.out.println(q.getName() + ActionsAndAll.getDo(ActionsAndAll.Does.RUN_TO_OPEN, q.getIsMale()) + ActionsAndAll.getSubj(ActionsAndAll.Subj.DOOR) + ".");
        } else {
            System.out.println(q.getName() + " не" + ActionsAndAll.getDo(ActionsAndAll.Does.RUN_TO_OPEN, q.getIsMale()) + ActionsAndAll.getSubj(ActionsAndAll.Subj.DOOR) + ".");
        }
    }

    /**
     * стоять у плиты
     */
    static void stand(Personage q, boolean f) {
        if (f) {
            System.out.println(q.getName() + ActionsAndAll.getDo(ActionsAndAll.Does.STAND, q.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN1) + ".");
        } else {
            System.out.println(q.getName() + " не" + ActionsAndAll.getDo(ActionsAndAll.Does.STAND, q.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN1) + ".");
        }
    }

    /**
     * печь блины
     */

    static void cookPans(Personage q, ActionsAndAll.Subj food, boolean f) {
        if (f) {
            System.out.println(q.getName() + ActionsAndAll.getDo(ActionsAndAll.Does.COOK_TO_YU, q.getIsMale()) + ActionsAndAll.getSubj(ActionsAndAll.Subj.MORE_EASY) + " чем" + ActionsAndAll.getSubj(food) + ".");
        } else {
            System.out.println(q.getName() + " не" + ActionsAndAll.getDo(ActionsAndAll.Does.COOK_TO_YU, q.getIsMale()) + ActionsAndAll.getSubj(ActionsAndAll.Subj.MORE_EASY) + " чем" + ActionsAndAll.getSubj(food) + ".");
        }
    }

    /**
     * услышать голос за спиной
     */
    static void hearVoice(Personage q, Personage p, boolean f) {
        if (f) {
            System.out.println(q.getName() + ActionsAndAll.getDo(ActionsAndAll.Does.HEAR, q.getIsMale()) + " голос " + p + ActionsAndAll.getPlace(ActionsAndAll.Place.BACK) + ".");
        } else {
            System.out.println(q.getName() + " не" + ActionsAndAll.getDo(ActionsAndAll.Does.HEAR, q.getIsMale()) + " голос " + p + ActionsAndAll.getPlace(ActionsAndAll.Place.BACK) + ".");
        }
    }

    /**
     * обернуться
     */
    static void turn(Personage q, boolean f) {
        if (f) {
            System.out.println(q.getName() + ActionsAndAll.getDo(ActionsAndAll.Does.TURN, q.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN1) + ActionsAndAll.getPlace(ActionsAndAll.Place.BACK) + ".");
        } else {
            System.out.println(q.getName() + " не" + ActionsAndAll.getDo(ActionsAndAll.Does.TURN, q.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN1) + ActionsAndAll.getPlace(ActionsAndAll.Place.BACK) + ".");
        }
    }

    /**
     * выплеснула тесто
     */
    static void blub(Personage q, boolean f) {
        if (f) {
            System.out.println(q.getName() + ActionsAndAll.getDo(ActionsAndAll.Does.SPLASH, q.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN2) + ActionsAndAll.getSubj(ActionsAndAll.Subj.POL_WITH_CAKE) + ".");
        } else {
            System.out.println(q.getName() + " не" + ActionsAndAll.getDo(ActionsAndAll.Does.SPLASH, q.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN2) + ActionsAndAll.getSubj(ActionsAndAll.Subj.POL_WITH_CAKE) + ".");
        }
    }

    /**
     * выплеснула не тесто
     */
    static void blub(Personage q, boolean f, ActionsAndAll.Subj food) {
        if (f) {
            System.out.println(q.getName() + ActionsAndAll.getDo(ActionsAndAll.Does.SPLASH, q.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN2) + ActionsAndAll.getSubj(food) + ".");
        } else {
            System.out.println(q.getName() + " не" + ActionsAndAll.getDo(ActionsAndAll.Does.SPLASH, q.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN2) + ActionsAndAll.getSubj(food) + ".");
        }
    }

    /**
     * Появиться как-то к обеду
     */
    static void comeTo(Personage q, boolean f, ActionsAndAll.Mood m) {
        if (f) {
            System.out.println(q.getName() + ActionsAndAll.getMood(m) + ActionsAndAll.getDo(ActionsAndAll.Does.APPEAR, q.getIsMale()) + " только к обеду.");
        } else {
            System.out.println(q.getName() + ActionsAndAll.getMood(m) + " не" + ActionsAndAll.getDo(ActionsAndAll.Does.APPEAR, q.getIsMale()) + " даже к обеду.");
        }
    }

    /**
     * Появиться как-то к другому времени
     */

    static void comeTo(Personage q, String time, boolean f, ActionsAndAll.Mood m) {
        if (f) {
            System.out.println(q.getName() + ActionsAndAll.getMood(m) + ActionsAndAll.getDo(ActionsAndAll.Does.APPEAR, q.getIsMale()) + " только к " + time + ".");
        } else {
            System.out.println(q.getName() + ActionsAndAll.getMood(m) + " не" + ActionsAndAll.getDo(ActionsAndAll.Does.APPEAR, q.getIsMale()) + " даже к " + time + ".");
        }
    }

    /**
     * прийти куда-то как-то через что-то
     * или не прийти ;)
     */

    static void comeThrough(Personage q, ActionsAndAll.Place place, ActionsAndAll.Does doing, boolean f, ActionsAndAll.Mood m) {
        if (f) {
            System.out.println(q.getName() + ActionsAndAll.getMood(m) + ActionsAndAll.getDo(doing, q.getIsMale()) + ActionsAndAll.getPlace(place) + ".");
        } else {
            System.out.println(q.getName() + ActionsAndAll.getMood(m) + " не" + ActionsAndAll.getDo(doing, q.getIsMale()) + ActionsAndAll.getPlace(place) + ".");
        }
    }

    /**
     * стоять как-то у плиты
     */
    static void stand(Personage q, boolean f, ActionsAndAll.Mood m) {
        if (f) {
            System.out.println(q.getName() + ActionsAndAll.getMood(m) + ActionsAndAll.getDo(ActionsAndAll.Does.STAND, q.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN1) + ".");
        } else {
            System.out.println(q.getName() + ActionsAndAll.getMood(m) + " не" + ActionsAndAll.getDo(ActionsAndAll.Does.STAND, q.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN1) + ".");
        }
    }

    /**
     * печь как-то блины
     */

    static void cookPans(Personage q, ActionsAndAll.Subj food, boolean f, ActionsAndAll.Mood m) {
        if (f) {
            System.out.println(q.getName() + ActionsAndAll.getMood(m) + ActionsAndAll.getDo(ActionsAndAll.Does.COOK_TO_YU, q.getIsMale()) + ActionsAndAll.getSubj(ActionsAndAll.Subj.MORE_EASY) + " чем" + ActionsAndAll.getSubj(food) + ".");
        } else {
            System.out.println(q.getName() + ActionsAndAll.getMood(m) + " не" + ActionsAndAll.getDo(ActionsAndAll.Does.COOK_TO_YU, q.getIsMale()) + ActionsAndAll.getSubj(ActionsAndAll.Subj.MORE_EASY) + " чем" + ActionsAndAll.getSubj(food) + ".");
        }
    }


    /**
     * как-то услышать голос за спиной
     */
    static void hearVoice(Personage q, Personage p, boolean f, ActionsAndAll.Mood m) {
        if (f) {
            System.out.println(q.getName() + ActionsAndAll.getMood(m) + ActionsAndAll.getDo(ActionsAndAll.Does.HEAR, q.getIsMale()) + " голос " + p + ActionsAndAll.getPlace(ActionsAndAll.Place.BACK) + ".");
        } else {
            System.out.println(q.getName() + ActionsAndAll.getMood(m) + " не" + ActionsAndAll.getDo(ActionsAndAll.Does.HEAR, q.getIsMale()) + " голос " + p + ActionsAndAll.getPlace(ActionsAndAll.Place.BACK) + ".");
        }
    }

    /**
     * как-то обернуться
     */
    static void turn(Personage q, boolean f, ActionsAndAll.Mood m) {
        if (f) {
            System.out.println(q.getName() + ActionsAndAll.getMood(m) + ActionsAndAll.getDo(ActionsAndAll.Does.TURN, q.getIsMale()) + ".");
        } else {
            System.out.println(q.getName() + ActionsAndAll.getMood(m) + " не" + ActionsAndAll.getDo(ActionsAndAll.Does.TURN, q.getIsMale()) + ".");
        }
    }

    /**
     * как-то выплеснула тесто
     */
    static void blub(Personage q, boolean f, ActionsAndAll.Mood m) {
        if (f) {
            System.out.println(q.getName() + ActionsAndAll.getMood(m) + ActionsAndAll.getDo(ActionsAndAll.Does.SPLASH, q.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN2) + ActionsAndAll.getSubj(ActionsAndAll.Subj.POL_WITH_CAKE) + ".");
        } else {
            System.out.println(q.getName() + ActionsAndAll.getMood(m) + " не" + ActionsAndAll.getDo(ActionsAndAll.Does.SPLASH, q.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN2) + ActionsAndAll.getSubj(ActionsAndAll.Subj.POL_WITH_CAKE) + ".");
        }
    }

    /**
     * как-то выплеснула не тесто
     */
    static void blub(Personage q, boolean f, ActionsAndAll.Subj food, ActionsAndAll.Mood m) {
        if (f) {
            System.out.println(q.getName() + ActionsAndAll.getMood(m) + ActionsAndAll.getDo(ActionsAndAll.Does.SPLASH, q.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN2) + ActionsAndAll.getSubj(food) + ".");
        } else {
            System.out.println(q.getName() + ActionsAndAll.getMood(m) + " не" + ActionsAndAll.getDo(ActionsAndAll.Does.SPLASH, q.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN2) + ActionsAndAll.getSubj(food) + ".");
        }
    }

}
