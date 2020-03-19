package no.fara.recruitment.tickets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

/**
 * Implement endpoint for filtering tickets by any combination of fields [name, state, type]. Endpoint is going to be used by web portal to manage users.
 */
@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService itemService;

    @GetMapping
    public Collection<Ticket> getTickets() {
        return itemService.getTickets();
    }

    @GetMapping("/{uuid}")
    public Ticket getTicket(@PathVariable("uuid") String uuid) {
        return itemService.getTicket(uuid);
    }

    @PostMapping
    public Ticket createTicket(@RequestBody @Valid Ticket ticket) {
        return itemService.createTicket(ticket);
    }

    @PutMapping("/{uuid}")
    public Ticket updateTicket(@PathVariable("uuid") String uuid, @RequestBody Ticket ticket) {
        return itemService.updateTicket(uuid, ticket);
    }
}
