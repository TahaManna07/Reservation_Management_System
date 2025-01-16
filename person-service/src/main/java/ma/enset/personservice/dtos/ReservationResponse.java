package ma.enset.personservice.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ReservationResponse {
    private Long id;
    private String name;
    private String context;
    private String date;
    private int duration;
}
