package ie.atu.week7oop.service;

import ie.atu.week7oop.exception.ReservationConflictException;
import ie.atu.week7oop.model.Reservation;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    private List<Reservation> reservations = new ArrayList<>();
    private long nextId = 1;

    public Reservation addReservation(Reservation reservation) {

        reservation.setReservationID(nextId++);


        for (Reservation existing : reservations) {

            if (existing.getEquipmentTag().equals(reservation.getEquipmentTag()) &&
                    existing.getReservationDate().equals(reservation.getReservationDate()))

        }

        int existingStart = existing.getStartHour();
        int existingEnd = existingStart + existing.getDurationHours();

        if (existingStart < newEnd && newStart < existingEnd) {
            reservation.setReservationID(nextId--);
            throw new ReservationConflictException("Time slot already booked");


        }
        reservation.add(reservation);
        return reservation;
    }

    public List<Reservation> getAllReservations() {
        return reservations;
    }


    public @Nullable Reservation getReservationById(Long id) {
    }
}
