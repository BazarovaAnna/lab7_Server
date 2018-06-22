package model;

public interface KarlsonCome {
    void comeTo(String time, boolean f);

    void comeTo(boolean f);

    void comeThrough(ActionsAndAll.Place place, ActionsAndAll.Does doing, boolean f);

    void comeThrough(ActionsAndAll.Place place, ActionsAndAll.Does doing, boolean f, ActionsAndAll.Mood m);

    void comeTo(String time, boolean f, ActionsAndAll.Mood m);
}
