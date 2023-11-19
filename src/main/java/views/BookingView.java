package views;

import models.Table;
import presenters.View;
import presenters.ViewObserver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class BookingView implements View {

    private Collection<ViewObserver> observers = new ArrayList<>();
    @Override
    public void registerObserver(ViewObserver observer) {
        observers.add(observer);
    }

    @Override
    public void showTables(Collection<Table> tables) {
        for (Table table: tables) {
            System.out.println(table);
        }
    }

    @Override
    public void showReservationTableResult(int reservationNo) {
        if (reservationNo > 0){
            System.out.printf("Столик успешно забронирован. Номер резерва: #%d\n", reservationNo);
        }
        else {
            System.out.println("Произошла ошибка бронирования. Повторите операцию позже.");
        }
    }

    @Override
    public void showChangeReservationTableResult(int oldReservation) {
        if (oldReservation > 0){
            System.out.printf("Резерв #%d удалён\n", oldReservation);
        }
        else {
            System.out.println("Некорректный номер брони.");
        }
    }


    /**
     * Действие клиента (пользователь нажал на кнопку бронирования), бронирование столика
     * @param orderDate дата бронирования
     * @param tableNo номер столика
     * @param name Имя
     */
    public void reservationTable(Date orderDate, int tableNo, String name){
        System.out.println("Возбуждается событие бронирования столика");
        System.out.println("Происходит уведомление наблюдателей ...");
        for (ViewObserver observer : observers) {
            observer.onReservationTable(orderDate, tableNo, name);
        }

    }

    /**
     * TODO: метод должен заработать!
     * Действие клиента (пользователь нажал на кнопку), изменение бронирования столика
     * @param oldReservation номер старой брони
     * @param orderDate дата бронирования
     * @param tableNo номер столика
     * @param name Имя
     */
    public void changeReservationTable(int oldReservation, Date orderDate, int tableNo, String name){
        System.out.println("Возбуждается событие изменения бронирования столика");
        System.out.println("Происходит уведомление наблюдателей ...");
        for (ViewObserver observer : observers) {
            observer.onChangeReservationTable(oldReservation, orderDate, tableNo, name);
        }
    }
}

