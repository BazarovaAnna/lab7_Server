package model;

public interface PossibleActions extends KarlsonCome {
    @SuppressWarnings("serial")
    class LogicException extends Exception {
        LogicException(String message) {
            super(message);
        }
    }

    /**
     * ��������� � �����
     */
    static void comeTo(Personage q, boolean f) {

        if (f) {
            System.out.println(q.getName() + ActionsAndAll.getDo(ActionsAndAll.Does.APPEAR, q.getIsMale()) + " ������ � �����.");
        } else {
            System.out.println(q.getName() + " ��" + ActionsAndAll.getDo(ActionsAndAll.Does.APPEAR, q.getIsMale()) + " ���� � �����.");
        }
    }

    /**
     * ��������� � ������� �������
     */

    static void comeTo(Personage q, String time, boolean f) {
        if (f) {
            System.out.println(q.getName() + ActionsAndAll.getDo(ActionsAndAll.Does.APPEAR, q.getIsMale()) + " ������ � " + time + ".");
        } else {
            System.out.println(q.getName() + " ��" + ActionsAndAll.getDo(ActionsAndAll.Does.APPEAR, q.getIsMale()) + " ���� � " + time + ".");
        }
    }

    /**
     * ������ ����-�� ����� ���-��
     * ��� �� ������ ;)
     *
     * @throws LogicException ������ ������ �������
     */

    static void comeThrough(Personage q, ActionsAndAll.Place place, ActionsAndAll.Does doing, boolean f) throws LogicException {
        if ((!q.getType().equals("����� ������ � ���� ���������� � ������� ")) && doing == ActionsAndAll.Does.FLY)
            throw new LogicException("������ ������ �������, ������");
        if (f) {
            System.out.println(q.getName() + ActionsAndAll.getDo(doing, q.getIsMale()) + ActionsAndAll.getPlace(place) + ".");
        } else {
            System.out.println(q.getName() + " ��" + ActionsAndAll.getDo(doing, q.getIsMale()) + ActionsAndAll.getPlace(place) + ".");
        }
    }

    /**
     * ������� �����
     */
    static void runToOpen(Personage q, boolean f) {
        if (f) {
            System.out.println(q.getName() + ActionsAndAll.getDo(ActionsAndAll.Does.RUN_TO_OPEN, q.getIsMale()) + ActionsAndAll.getSubj(ActionsAndAll.Subj.DOOR) + ".");
        } else {
            System.out.println(q.getName() + " ��" + ActionsAndAll.getDo(ActionsAndAll.Does.RUN_TO_OPEN, q.getIsMale()) + ActionsAndAll.getSubj(ActionsAndAll.Subj.DOOR) + ".");
        }
    }

    /**
     * ������ � �����
     */
    static void stand(Personage q, boolean f) {
        if (f) {
            System.out.println(q.getName() + ActionsAndAll.getDo(ActionsAndAll.Does.STAND, q.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN1) + ".");
        } else {
            System.out.println(q.getName() + " ��" + ActionsAndAll.getDo(ActionsAndAll.Does.STAND, q.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN1) + ".");
        }
    }

    /**
     * ���� �����
     */

    static void cookPans(Personage q, ActionsAndAll.Subj food, boolean f) {
        if (f) {
            System.out.println(q.getName() + ActionsAndAll.getDo(ActionsAndAll.Does.COOK_TO_YU, q.getIsMale()) + ActionsAndAll.getSubj(ActionsAndAll.Subj.MORE_EASY) + " ���" + ActionsAndAll.getSubj(food) + ".");
        } else {
            System.out.println(q.getName() + " ��" + ActionsAndAll.getDo(ActionsAndAll.Does.COOK_TO_YU, q.getIsMale()) + ActionsAndAll.getSubj(ActionsAndAll.Subj.MORE_EASY) + " ���" + ActionsAndAll.getSubj(food) + ".");
        }
    }

    /**
     * �������� ����� �� ������
     */
    static void hearVoice(Personage q, Personage p, boolean f) {
        if (f) {
            System.out.println(q.getName() + ActionsAndAll.getDo(ActionsAndAll.Does.HEAR, q.getIsMale()) + " ����� " + p + ActionsAndAll.getPlace(ActionsAndAll.Place.BACK) + ".");
        } else {
            System.out.println(q.getName() + " ��" + ActionsAndAll.getDo(ActionsAndAll.Does.HEAR, q.getIsMale()) + " ����� " + p + ActionsAndAll.getPlace(ActionsAndAll.Place.BACK) + ".");
        }
    }

    /**
     * ����������
     */
    static void turn(Personage q, boolean f) {
        if (f) {
            System.out.println(q.getName() + ActionsAndAll.getDo(ActionsAndAll.Does.TURN, q.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN1) + ActionsAndAll.getPlace(ActionsAndAll.Place.BACK) + ".");
        } else {
            System.out.println(q.getName() + " ��" + ActionsAndAll.getDo(ActionsAndAll.Does.TURN, q.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN1) + ActionsAndAll.getPlace(ActionsAndAll.Place.BACK) + ".");
        }
    }

    /**
     * ���������� �����
     */
    static void blub(Personage q, boolean f) {
        if (f) {
            System.out.println(q.getName() + ActionsAndAll.getDo(ActionsAndAll.Does.SPLASH, q.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN2) + ActionsAndAll.getSubj(ActionsAndAll.Subj.POL_WITH_CAKE) + ".");
        } else {
            System.out.println(q.getName() + " ��" + ActionsAndAll.getDo(ActionsAndAll.Does.SPLASH, q.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN2) + ActionsAndAll.getSubj(ActionsAndAll.Subj.POL_WITH_CAKE) + ".");
        }
    }

    /**
     * ���������� �� �����
     */
    static void blub(Personage q, boolean f, ActionsAndAll.Subj food) {
        if (f) {
            System.out.println(q.getName() + ActionsAndAll.getDo(ActionsAndAll.Does.SPLASH, q.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN2) + ActionsAndAll.getSubj(food) + ".");
        } else {
            System.out.println(q.getName() + " ��" + ActionsAndAll.getDo(ActionsAndAll.Does.SPLASH, q.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN2) + ActionsAndAll.getSubj(food) + ".");
        }
    }

    /**
     * ��������� ���-�� � �����
     */
    static void comeTo(Personage q, boolean f, ActionsAndAll.Mood m) {
        if (f) {
            System.out.println(q.getName() + ActionsAndAll.getMood(m) + ActionsAndAll.getDo(ActionsAndAll.Does.APPEAR, q.getIsMale()) + " ������ � �����.");
        } else {
            System.out.println(q.getName() + ActionsAndAll.getMood(m) + " ��" + ActionsAndAll.getDo(ActionsAndAll.Does.APPEAR, q.getIsMale()) + " ���� � �����.");
        }
    }

    /**
     * ��������� ���-�� � ������� �������
     */

    static void comeTo(Personage q, String time, boolean f, ActionsAndAll.Mood m) {
        if (f) {
            System.out.println(q.getName() + ActionsAndAll.getMood(m) + ActionsAndAll.getDo(ActionsAndAll.Does.APPEAR, q.getIsMale()) + " ������ � " + time + ".");
        } else {
            System.out.println(q.getName() + ActionsAndAll.getMood(m) + " ��" + ActionsAndAll.getDo(ActionsAndAll.Does.APPEAR, q.getIsMale()) + " ���� � " + time + ".");
        }
    }

    /**
     * ������ ����-�� ���-�� ����� ���-��
     * ��� �� ������ ;)
     */

    static void comeThrough(Personage q, ActionsAndAll.Place place, ActionsAndAll.Does doing, boolean f, ActionsAndAll.Mood m) {
        if (f) {
            System.out.println(q.getName() + ActionsAndAll.getMood(m) + ActionsAndAll.getDo(doing, q.getIsMale()) + ActionsAndAll.getPlace(place) + ".");
        } else {
            System.out.println(q.getName() + ActionsAndAll.getMood(m) + " ��" + ActionsAndAll.getDo(doing, q.getIsMale()) + ActionsAndAll.getPlace(place) + ".");
        }
    }

    /**
     * ������ ���-�� � �����
     */
    static void stand(Personage q, boolean f, ActionsAndAll.Mood m) {
        if (f) {
            System.out.println(q.getName() + ActionsAndAll.getMood(m) + ActionsAndAll.getDo(ActionsAndAll.Does.STAND, q.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN1) + ".");
        } else {
            System.out.println(q.getName() + ActionsAndAll.getMood(m) + " ��" + ActionsAndAll.getDo(ActionsAndAll.Does.STAND, q.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN1) + ".");
        }
    }

    /**
     * ���� ���-�� �����
     */

    static void cookPans(Personage q, ActionsAndAll.Subj food, boolean f, ActionsAndAll.Mood m) {
        if (f) {
            System.out.println(q.getName() + ActionsAndAll.getMood(m) + ActionsAndAll.getDo(ActionsAndAll.Does.COOK_TO_YU, q.getIsMale()) + ActionsAndAll.getSubj(ActionsAndAll.Subj.MORE_EASY) + " ���" + ActionsAndAll.getSubj(food) + ".");
        } else {
            System.out.println(q.getName() + ActionsAndAll.getMood(m) + " ��" + ActionsAndAll.getDo(ActionsAndAll.Does.COOK_TO_YU, q.getIsMale()) + ActionsAndAll.getSubj(ActionsAndAll.Subj.MORE_EASY) + " ���" + ActionsAndAll.getSubj(food) + ".");
        }
    }


    /**
     * ���-�� �������� ����� �� ������
     */
    static void hearVoice(Personage q, Personage p, boolean f, ActionsAndAll.Mood m) {
        if (f) {
            System.out.println(q.getName() + ActionsAndAll.getMood(m) + ActionsAndAll.getDo(ActionsAndAll.Does.HEAR, q.getIsMale()) + " ����� " + p + ActionsAndAll.getPlace(ActionsAndAll.Place.BACK) + ".");
        } else {
            System.out.println(q.getName() + ActionsAndAll.getMood(m) + " ��" + ActionsAndAll.getDo(ActionsAndAll.Does.HEAR, q.getIsMale()) + " ����� " + p + ActionsAndAll.getPlace(ActionsAndAll.Place.BACK) + ".");
        }
    }

    /**
     * ���-�� ����������
     */
    static void turn(Personage q, boolean f, ActionsAndAll.Mood m) {
        if (f) {
            System.out.println(q.getName() + ActionsAndAll.getMood(m) + ActionsAndAll.getDo(ActionsAndAll.Does.TURN, q.getIsMale()) + ".");
        } else {
            System.out.println(q.getName() + ActionsAndAll.getMood(m) + " ��" + ActionsAndAll.getDo(ActionsAndAll.Does.TURN, q.getIsMale()) + ".");
        }
    }

    /**
     * ���-�� ���������� �����
     */
    static void blub(Personage q, boolean f, ActionsAndAll.Mood m) {
        if (f) {
            System.out.println(q.getName() + ActionsAndAll.getMood(m) + ActionsAndAll.getDo(ActionsAndAll.Does.SPLASH, q.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN2) + ActionsAndAll.getSubj(ActionsAndAll.Subj.POL_WITH_CAKE) + ".");
        } else {
            System.out.println(q.getName() + ActionsAndAll.getMood(m) + " ��" + ActionsAndAll.getDo(ActionsAndAll.Does.SPLASH, q.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN2) + ActionsAndAll.getSubj(ActionsAndAll.Subj.POL_WITH_CAKE) + ".");
        }
    }

    /**
     * ���-�� ���������� �� �����
     */
    static void blub(Personage q, boolean f, ActionsAndAll.Subj food, ActionsAndAll.Mood m) {
        if (f) {
            System.out.println(q.getName() + ActionsAndAll.getMood(m) + ActionsAndAll.getDo(ActionsAndAll.Does.SPLASH, q.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN2) + ActionsAndAll.getSubj(food) + ".");
        } else {
            System.out.println(q.getName() + ActionsAndAll.getMood(m) + " ��" + ActionsAndAll.getDo(ActionsAndAll.Does.SPLASH, q.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN2) + ActionsAndAll.getSubj(food) + ".");
        }
    }

}
