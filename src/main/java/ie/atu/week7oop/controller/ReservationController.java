package ie.atu.week7oop.controller;


import ie.atu.week7oop.model.Reservation;
import ie.atu.week7oop.service.ReservationService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {


    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ResponseEntity<Reservation> create(@Valid @RequestBody Reservation reservation) {
        Reservation saved = reservationService.addReservation(reservation);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getAll() {
        return ResponseEntity.ok((List<Reservation>) reservationService.getAllReservations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getById(@PathVariable long id) {
        return ResponseEntity.ok(reservationService.getReservationById(id));
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<Reservation>> getByDate(@PathVariable LocalDate date) {
        return ResponseEntity.ok(reservationService.getAllReservationsByDate(date));
    }
}
