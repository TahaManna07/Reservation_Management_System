package ma.enset.tahasouhailmanna.model;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Resource {
    private Long id;
    private String name;
    private String type;
}
