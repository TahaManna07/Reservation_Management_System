package ma.enset.tahasouhailmanna.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.enset.tahasouhailmanna.model.Person;
import ma.enset.tahasouhailmanna.model.Resource;

import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String context;
    private LocalDateTime date;
    private int duration;

    private Long personId;
    private Long ressourceId;

    @Transient
    private Person person;
    @Transient
    private Resource ressource;

}