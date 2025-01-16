package ma.enset.tahasouhailmanna.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class Person {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
