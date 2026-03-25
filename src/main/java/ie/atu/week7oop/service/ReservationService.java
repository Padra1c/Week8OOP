package ie.atu.week7oop.service;

import ie.atu.week7oop.exception.ReservationConflictException;
import ie.atu.week7oop.exception.ReservationNotFoundException;
import ie.atu.week7oop.model.Reservation;
import ie.atu.week7oop.repository.ReservationRepo;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepo reservationRepo;
    private List<Reservation> reservations = new ArrayList<>();
    private long nextId = 1;

    public ReservationService(ReservationRepo reservationRepo) {
        this.reservationRepo = reservationRepo;
    }

    public Reservation addReservation(Reservation reservation) {

        reservation.setReservationID(nextId++);

        int newStart = reservation.getStartHour();
        int newEnd = newStart + reservation.getDurationHour();

        for (Reservation existing : reservations) {

            if (existing.getEquipmentTag().equals(reservation.getEquipmentTag()) &&
                    existing.getReservationDate().equals(reservation.getReservationDate())) {
                int existingStart = existing.getStartHour();
                int existingEnd = existingStart + existing.getDurationHours();

                if (existingStart < newEnd && newStart < existingEnd) {
                    reservation.setReservationID(nextId--);
                    throw new ReservationConflictException("Time slot already booked");
                }
            }
        }
        reservationRepo.save(reservation);
        return reservation;
    }
    public List<Reservation> getAllReservations() {
        return reservations;
    }

    public Reservation getReservationById(long id) {
        return reservationRepo.findById(id).orElseThrow(() -> new ReservationNotFoundException("Reservation not found"));
    }

    public List<Reservation> getAllReservationsByDate(LocalDate reservationdate) {
        return reservationRepo.findByReservationDate(reservationdate);
    }
}