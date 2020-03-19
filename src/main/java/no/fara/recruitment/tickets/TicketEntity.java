package no.fara.recruitment.tickets;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity(name="ticket")
public class TicketEntity {

    public TicketEntity(String name, String uuid, int state, String type) {
        this.name = name;
        this.state = state;
        this.uuid = uuid;
        this.type = TicketType.valueOf(type);
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String uuid;
    @Column
    private String name;
    @Column
    private int state;
    @Column
    @Enumerated
    private TicketType type;


    enum TicketType {
        SINGLE, PERIOD;
    }
}
