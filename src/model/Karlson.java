package model;

public class Karlson extends Personage implements KarlsonCome {
    String type = "����� ������ � ���� ���������� � ������� ";

    Karlson(String name) {
        super(name, "����� ������ � ���� ���������� � ������� ", true);
    }

    Karlson() {
        super("�������", "����� ������ � ���� ���������� � ������� ", true);
    }

    /**
     * ��������� � �����
     */
    public void comeTo(boolean f) {
        if (f) {
            System.out.println(this.getName() + ActionsAndAll.getDo(ActionsAndAll.Does.APPEAR, this.getIsMale()) + " ������ � �����.");
        } else {
            System.out.println(this.getName() + " ��" + ActionsAndAll.getDo(ActionsAndAll.Does.APPEAR, this.getIsMale()) + " ���� � �����.");
        }
    }

    /**
     * ��������� � ������� �������
     */
    @Override
    public void comeTo(String time, boolean f) {
        if (f) {
            System.out.println(this.getName() + ActionsAndAll.getDo(ActionsAndAll.Does.APPEAR, this.getIsMale()) + " ������ � " + time + ".");
        } else {
            System.out.println(this.getName() + " ��" + ActionsAndAll.getDo(ActionsAndAll.Does.APPEAR, this.getIsMale()) + " ���� � " + time + ".");
        }
    }

    /**
     * ������ ����-�� ����� ���-��
     * ��� �� ������ ;)
     */
    @Override
    public void comeThrough(ActionsAndAll.Place place, ActionsAndAll.Does doing, boolean f) {
        if (f) {
            System.out.println(this.getName() + ActionsAndAll.getDo(doing, this.getIsMale()) + ActionsAndAll.getPlace(place) + ".");
        } else {
            System.out.println(this.getName() + " ��" + ActionsAndAll.getDo(doing, this.getIsMale()) + ActionsAndAll.getPlace(place) + ".");
        }
    }


    /**
     * ��������� ���-�� � �����
     */
    public void comeTo(boolean f, ActionsAndAll.Mood m) {
        if (f) {
            System.out.println(this.getName() + ActionsAndAll.getMood(m) + ActionsAndAll.getDo(ActionsAndAll.Does.APPEAR, this.getIsMale()) + " ������ � �����.");
        } else {
            System.out.println(this.getName() + ActionsAndAll.getMood(m) + " ��" + ActionsAndAll.getDo(ActionsAndAll.Does.APPEAR, this.getIsMale()) + " ���� � �����.");
        }
    }

    /**
     * ��������� ���-�� � ������� �������
     */
    @Override
    public void comeTo(String time, boolean f, ActionsAndAll.Mood m) {
        if (f) {
            System.out.println(this.getName() + ActionsAndAll.getMood(m) + ActionsAndAll.getDo(ActionsAndAll.Does.APPEAR, this.getIsMale()) + " ������ � " + time + ".");
        } else {
            System.out.println(this.getName() + ActionsAndAll.getMood(m) + " ��" + ActionsAndAll.getDo(ActionsAndAll.Does.APPEAR, this.getIsMale()) + " ���� � " + time + ".");
        }
    }

    /**
     * ������ ����-�� ���-�� ����� ���-��
     * ��� �� ������ ;)
     */
    @Override
    public void comeThrough(ActionsAndAll.Place place, ActionsAndAll.Does doing, boolean f, ActionsAndAll.Mood m) {
        if (f) {
            System.out.println(this.getName() + ActionsAndAll.getMood(m) + ActionsAndAll.getDo(doing, this.getIsMale()) + ActionsAndAll.getPlace(place) + ".");
        } else {
            System.out.println(this.getName() + ActionsAndAll.getMood(m) + " ��" + ActionsAndAll.getDo(doing, this.getIsMale()) + ActionsAndAll.getPlace(place) + ".");
        }
    }


    @Override
    public String toString() {
        return this.getName();
    }

    public void getFunOfIt() {
        System.out.println(" ����� �������?");
    }

}
