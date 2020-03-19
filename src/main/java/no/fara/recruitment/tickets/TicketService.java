package no.fara.recruitment.tickets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Transactional
    public Ticket createTicket(Ticket ticket) {
        TicketEntity ticketEntity = ticketRepository.saveAndFlush(new TicketEntity(ticket.getName(), UUID.randomUUID().toString(), ticket.getState().getStateId(), ticket.getType()));
        return fromTicketEntity(ticketEntity);
    }

    public Ticket updateTicket(String uuid, Ticket ticket) {
        TicketEntity ticketEntity = ticketRepository.findByUuid(uuid);
        return updateTicketInDb(ticketEntity, ticket);
    }

    @Transactional
    public Ticket updateTicketInDb(TicketEntity ticketEntity, Ticket ticket) {
        if (ticket.getName() != null) {
            ticketEntity.setName(ticket.getName());
        }
        if (ticket.getState() != null) {
            ticketEntity.setState(ticket.getState().getStateId());
        }

        ticketEntity = ticketRepository.save(ticketEntity);

        return fromTicketEntity(ticketEntity);
    }

    @Transactional(readOnly = true)
    public Collection<Ticket> getTickets() {
        return ticketRepository.findAll().stream()
            .map(this::fromTicketEntity)
            .collect(Collectors.toList());
    }

    @Transactional
    public Ticket getTicket(String uuid) {
        return fromTicketEntity(ticketRepository.findByUuid(uuid));
    }

    private Ticket fromTicketEntity(TicketEntity ticketEntity) {
        return new Ticket(ticketEntity.getUuid(), ticketEntity.getName(), State.valueOf(ticketEntity.getState()), ticketEntity.getType().name());
    }
}
