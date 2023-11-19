import models.TableModel;
import presenters.BookingPresenter;
import views.BookingView;

import java.util.Date;

public class Program {
    //TODO: Метод changeReservationTable должен заработать!
    public static void main(String[] args) {

        TableModel tableModel = new TableModel();
        BookingView bookingView = new BookingView();
        BookingPresenter bookingPresenter = new BookingPresenter(tableModel, bookingView);
        bookingPresenter.updateTablesUI();
        bookingView.reservationTable(new Date(), 1, "Екатерина");
        bookingView.changeReservationTable(1, new Date(), 3, "Екатерина");

    }
}
