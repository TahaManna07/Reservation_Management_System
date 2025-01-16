package ma.enset.personservice.dtos;

import lombok.*;
import ma.enset.personservice.entities.Person;

import java.util.List;
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDetailsResponse {
    private Person person;
    private List<ReservationResponse> reservations;

    // Getters and Setters
}
