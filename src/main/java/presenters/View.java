package presenters;

import models.Table;

import java.util.Collection;

public interface View {

    void registerObserver(ViewObserver observer);

    void showTables(Collection<Table> tables);
    void showReservationTableResult(int reservationNo);
    void showChangeReservationTableResult(int oldReservation);

}
