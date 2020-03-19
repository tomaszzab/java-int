package no.fara.recruitment.tickets;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

    private String id;
    private String name;
    private State state;
    private String type;



}
