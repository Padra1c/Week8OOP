package ie.atu.week7oop.repository;

import ie.atu.week7oop.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepo extends JpaRepository<Reservation, Long> {
}
