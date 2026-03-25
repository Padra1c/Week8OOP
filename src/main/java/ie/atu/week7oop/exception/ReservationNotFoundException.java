package ie.atu.week7oop.exception;

public class ReservationNotFoundException extends RuntimeException {
    public ReservationNotFoundException(String reservationNotFound)
    {
        super(reservationNotFound);
    }
}
