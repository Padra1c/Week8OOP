package ie.atu.week7oop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationID;

    @NotBlank(message = "equipmentTag is required")
    private String equipmentTag;

    @NotBlank(message = "studentEmail is required")
    @Email(message = "studentEmail must be a valid one")
    private String studentEmail;

    @NotNull(message = "reservstionDate required")
    private LocalDate reservstionDate;

    @Min(value = 0, message = "startHour must be between 1 and 23")
    @Max(value = 23, message = "startHour must be between 1 and 23")
    private int startHour;

    @Min(value = 1, message = "durationHour must be between 1 and 23")
    @Max(value = 24, message = "durationHour must be between 1 and 23")
    private int durationHour;

    public void add(Reservation reservation) {
        
    }

    public Object getReservationDate() {
        return null;
    }

    public int getDurationHours() {
        return 0;
    }

}
