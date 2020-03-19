package no.fara.recruitment.tickets;

import io.restassured.RestAssured;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TicketControllerTest {

    @LocalServerPort
    int port;

    @Autowired
    private TicketService ticketService;

    private Ticket ticketUnderTests;

    @Before
    public void setupDb() {
        ticketUnderTests = addTicket("1 zone ticket", TicketEntity.TicketType.SINGLE.name(), State.ACTIVE);
    }

    @Test
    public void testCreateTicket() {
        Ticket ticket = RestAssured.given().port(port)
            .basePath("api/tickets/{uuid}")
            .pathParam("uuid", ticketUnderTests.getId())
            .get()
            .then()
            .statusCode(HttpStatus.OK.value())
            .extract().as(Ticket.class);
        Assert.assertEquals(ticketUnderTests, ticket);
    }

    private Ticket addTicket(String name, String ticketType, State state) {
        Ticket ticket = new Ticket();
        ticket.setName(name);
        ticket.setType(ticketType);
        ticket.setState(state);
        return ticketService.createTicket(ticket);
    }

}
