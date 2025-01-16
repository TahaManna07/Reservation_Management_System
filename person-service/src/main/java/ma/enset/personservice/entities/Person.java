package ma.enset.personservice.entities;


import jakarta.persistence.*;
import lombok.*;
import ma.enset.personservice.dtos.ReservationResponse;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;


}