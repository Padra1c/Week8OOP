package ie.atu.week7oop.repository;

import ie.atu.week7oop.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepo extends JpaRepository<Reservation, Long> {
    List<Reservation> findByReservationDate(LocalDate reservationdate);
}
