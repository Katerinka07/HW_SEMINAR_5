package presenters;

import java.util.Date;

// наблюдает за событиями представления
import java.util.Date;

// наблюдает за событиями представления
public class BookingPresenter implements ViewObserver {

    private final Model model;
    private final View view;

    public BookingPresenter(Model model, View view){
        this.model = model;
        this.view = view;
        this.view.registerObserver(this);
    }
    public void updateTablesUI(){
        view.showTables(model.loadTables());
    }

    /**
     * Реакция наблюдателя на резерв столика
     * @param orderDate дата резерва
     * @param tableNo номер стола
     * @param name имя бронирующего
     */
    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        System.out.println("Презентер реагирует на событие");
        try {
            int reservationNo = model.reservationTable(orderDate, tableNo, name);
            view.showReservationTableResult(reservationNo);
        }
        catch (RuntimeException e){
            view.showReservationTableResult(-1);
        }
    }

    /**
     * Реакция наблюдателя на изменение резерва столика
     * @param oldReservation номер стораго резерва
     * @param orderDate новая дата резерва
     * @param tableNo номер стооика
     * @param name имя бронирующего
     */
    @Override
    public void onChangeReservationTable(int oldReservation, Date orderDate, int tableNo, String name) {
        System.out.println("Презентер реагирует на событие изменения брони");
        try {
            int newReserveNo = model.changeReservationTable(oldReservation, orderDate,tableNo, name);
            view.showReservationTableResult(newReserveNo);
        }
        catch (RuntimeException e){
            view.showChangeReservationTableResult(-1);
        }
    }
}