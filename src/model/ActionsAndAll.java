package model;

public interface ActionsAndAll {
    enum Does {
        FLY, APPEAR, RING, RUN_TO_OPEN, STAND, COOK_TO_YU, HEAR, TURN, SPLASH, RESH

    }

    enum Mood {
        BESH, REZ, PRO_SEBYA
    }

    enum Place {
        WINDOW, DOOR, OVEN1, OVEN2, BACK

    }

    enum Subj {
        CHICK, POL_WITH_CAKE, MORE_EASY, DOOR
    }

    static String getDo(Does runToOpen, boolean male) {
        switch (runToOpen) {
            case FLY: {
                if (male) {
                    return (" влетел");
                } else {
                    return (" влетела");
                }

            }
            case APPEAR: {
                if (male) {
                    return (" появился");
                } else {
                    return (" появилась");
                }

            }
            case RING: {
                if (male) {
                    return (" затрезвонил");
                } else {
                    return (" затрезвонила");
                }

            }
            case RUN_TO_OPEN: {
                if (male) {
                    return (" побежал открывать");
                } else {
                    return (" побежала открывать");
                }

            }
            case STAND: {
                if (male) {
                    return (" стоял");
                } else {
                    return (" стояла");
                }

            }
            case COOK_TO_YU: {
                if (male) {
                    return (" пек блины, чтобы подать дяде Юлиусу");
                } else {
                    return (" пекла блины, чтобы подать дяде Юлиусу");
                }

            }

            case HEAR: {
                if (male) {
                    return (" услышал");
                } else {
                    return (" услышала");
                }

            }
            case TURN: {
                if (male) {
                    return (" обернулся");
                } else {
                    return (" обернулась");
                }

            }
            case SPLASH: {
                if (male) {
                    return (" выплеснул");
                } else {
                    return (" выплеснула");
                }

            }
            default: {
                if (male) {
                    return (" сделал что-то");
                } else {
                    return (" сделала что-то");
                }
            }
            case RESH: {
                if (male) {
                    return (" решил");
                } else {
                    return (" решила");
                }

            }
        }
    }

    static String getSubj(Subj pl) {
        switch (pl) {
            case MORE_EASY: {
                return (" чего-то более легкого");

            }
            case DOOR: {
                return (" входную дверь");

            }
            case POL_WITH_CAKE: {
                return (" целый половник жидкого теста");

            }
            case CHICK: {
                return (" цыпленок");

            }

            default: {
                return (" что-то");
            }
        }
    }

    static String getPlace(Place pl) {
        switch (pl) {
            case WINDOW: {
                return (" в окно");

            }
            case DOOR: {
                return (" во входную дверь");

            }
            case OVEN1: {
                return (" у плиты");

            }
            case OVEN2: {
                return (" на плиту");

            }
            case BACK: {
                return (" за спиной");

            }
            default: {
                return (" где-то");
            }
        }
    }

    static String getMood(Mood pl) {
        switch (pl) {
            case REZ: {
                return (" резко");

            }
            case BESH: {
                return (" бешено");

            }
            case PRO_SEBYA: {
                return (" про себя");

            }

            default: {
                return (" как-то");
            }
        }
    }

}
