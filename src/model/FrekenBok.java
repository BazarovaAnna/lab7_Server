package model;

public class FrekenBok extends Personage {
    String type = "��������� ����������� ";

    FrekenBok(String name) {
        super(name, "��������� ����������� ", false);

    }

    FrekenBok() {
        super("������ ��� ", "��������� ����������� ", false);

    }

    /**
     * ������ � �����
     */
    public void stand(boolean f) {
        if (f) {
            System.out.println(this.getName() + ActionsAndAll.getDo(ActionsAndAll.Does.STAND, this.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN1) + ".");
        } else {
            System.out.println(this.getName() + " ��" + ActionsAndAll.getDo(ActionsAndAll.Does.STAND, this.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN1) + ".");
        }
    }

    /**
     * ���� �����
     */

    public void cookPans(ActionsAndAll.Subj food, boolean f) {
        if (f) {
            System.out.println(this.getName() + ActionsAndAll.getDo(ActionsAndAll.Does.COOK_TO_YU, this.getIsMale()) + ActionsAndAll.getSubj(ActionsAndAll.Subj.MORE_EASY) + " ���" + ActionsAndAll.getSubj(food) + ".");
        } else {
            System.out.println(this.getName() + " ��" + ActionsAndAll.getDo(ActionsAndAll.Does.COOK_TO_YU, this.getIsMale()) + ActionsAndAll.getSubj(ActionsAndAll.Subj.MORE_EASY) + " ���" + ActionsAndAll.getSubj(food) + ".");
        }
    }

    /**
     * �������� ����� �� ������
     */
    public void hearVoice(Personage p, boolean f) {
        if (f) {
            System.out.println(this.getName() + ActionsAndAll.getDo(ActionsAndAll.Does.HEAR, this.getIsMale()) + " ����� " + p + ActionsAndAll.getPlace(ActionsAndAll.Place.BACK) + ".");
        } else {
            System.out.println(this.getName() + " ��" + ActionsAndAll.getDo(ActionsAndAll.Does.HEAR, this.getIsMale()) + " ����� " + p + ActionsAndAll.getPlace(ActionsAndAll.Place.BACK) + ".");
        }
    }

    /**
     * ����������
     */
    public void turn(boolean f) {
        if (f) {
            System.out.println(this.getName() + ActionsAndAll.getDo(ActionsAndAll.Does.TURN, this.getIsMale()) + ".");
        } else {
            System.out.println(this.getName() + " ��" + ActionsAndAll.getDo(ActionsAndAll.Does.TURN, this.getIsMale()) + ".");
        }
    }

    /**
     * ���������� �����
     */
    public void blub(boolean f) {
        if (f) {
            System.out.println(this.getName() + ActionsAndAll.getDo(ActionsAndAll.Does.SPLASH, this.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN2) + ActionsAndAll.getSubj(ActionsAndAll.Subj.POL_WITH_CAKE) + ".");
        } else {
            System.out.println(this.getName() + " ��" + ActionsAndAll.getDo(ActionsAndAll.Does.SPLASH, this.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN2) + ActionsAndAll.getSubj(ActionsAndAll.Subj.POL_WITH_CAKE) + ".");
        }
    }

    /**
     * ���������� �� �����
     */
    public void blub(boolean f, ActionsAndAll.Subj food) {
        if (f) {
            System.out.println(this.getName() + ActionsAndAll.getDo(ActionsAndAll.Does.SPLASH, this.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN2) + ActionsAndAll.getSubj(food) + ".");
        } else {
            System.out.println(this.getName() + " ��" + ActionsAndAll.getDo(ActionsAndAll.Does.SPLASH, this.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN2) + ActionsAndAll.getSubj(food) + ".");
        }
    }


    /**
     * ������ ���-�� � �����
     */
    public void stand(boolean f, ActionsAndAll.Mood m) {
        if (f) {
            System.out.println(this.getName() + ActionsAndAll.getMood(m) + ActionsAndAll.getDo(ActionsAndAll.Does.STAND, this.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN1) + ".");
        } else {
            System.out.println(this.getName() + ActionsAndAll.getMood(m) + " ��" + ActionsAndAll.getDo(ActionsAndAll.Does.STAND, this.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN1) + ".");
        }
    }

    /**
     * ���� ���-�� �����
     */

    public void cookPans(ActionsAndAll.Subj food, boolean f, ActionsAndAll.Mood m) {
        if (f) {
            System.out.println(this.getName() + ActionsAndAll.getMood(m) + ActionsAndAll.getDo(ActionsAndAll.Does.COOK_TO_YU, this.getIsMale()) + ActionsAndAll.getSubj(ActionsAndAll.Subj.MORE_EASY) + " ���" + ActionsAndAll.getSubj(food) + ".");
        } else {
            System.out.println(this.getName() + ActionsAndAll.getMood(m) + " ��" + ActionsAndAll.getDo(ActionsAndAll.Does.COOK_TO_YU, this.getIsMale()) + ActionsAndAll.getSubj(ActionsAndAll.Subj.MORE_EASY) + " ���" + ActionsAndAll.getSubj(food) + ".");
        }
    }


    /**
     * ���-�� �������� ����� �� ������
     */
    public void hearVoice(Personage p, boolean f, ActionsAndAll.Mood m) {
        if (f) {
            System.out.println(this.getName() + ActionsAndAll.getMood(m) + ActionsAndAll.getDo(ActionsAndAll.Does.HEAR, this.getIsMale()) + " ����� " + p + ActionsAndAll.getPlace(ActionsAndAll.Place.BACK) + ".");
        } else {
            System.out.println(this.getName() + ActionsAndAll.getMood(m) + " ��" + ActionsAndAll.getDo(ActionsAndAll.Does.HEAR, this.getIsMale()) + " ����� " + p + ActionsAndAll.getPlace(ActionsAndAll.Place.BACK) + ".");
        }
    }

    /**
     * ���-�� ����������
     */
    public void turn(boolean f, ActionsAndAll.Mood m) {
        if (f) {
            System.out.println(this.getName() + ActionsAndAll.getMood(m) + ActionsAndAll.getDo(ActionsAndAll.Does.TURN, this.getIsMale()) + ".");
        } else {
            System.out.println(this.getName() + ActionsAndAll.getMood(m) + " ��" + ActionsAndAll.getDo(ActionsAndAll.Does.TURN, this.getIsMale()) + ".");
        }
    }

    /**
     * ���-�� ���������� �����
     */
    public void blub(boolean f, ActionsAndAll.Mood m) {
        if (f) {
            System.out.println(this.getName() + ActionsAndAll.getMood(m) + ActionsAndAll.getDo(ActionsAndAll.Does.SPLASH, this.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN2) + ActionsAndAll.getSubj(ActionsAndAll.Subj.POL_WITH_CAKE) + ".");
        } else {
            System.out.println(this.getName() + ActionsAndAll.getMood(m) + " ��" + ActionsAndAll.getDo(ActionsAndAll.Does.SPLASH, this.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN2) + ActionsAndAll.getSubj(ActionsAndAll.Subj.POL_WITH_CAKE) + ".");
        }
    }

    /**
     * ���-�� ���������� �� �����
     */
    public void blub(boolean f, ActionsAndAll.Subj food, ActionsAndAll.Mood m) {
        if (f) {
            System.out.println(this.getName() + ActionsAndAll.getMood(m) + ActionsAndAll.getDo(ActionsAndAll.Does.SPLASH, this.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN2) + ActionsAndAll.getSubj(food) + ".");
        } else {
            System.out.println(this.getName() + ActionsAndAll.getMood(m) + " ��" + ActionsAndAll.getDo(ActionsAndAll.Does.SPLASH, this.getIsMale()) + ActionsAndAll.getPlace(ActionsAndAll.Place.OVEN2) + ActionsAndAll.getSubj(food) + ".");
        }
    }


    @Override
    public String toString() {
        return this.getName();
    }

}
