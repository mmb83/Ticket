package edu.ticket.state;

import edu.ticket.Ticket;
import edu.ticket.TicketContext;
import edu.ticket.TicketStatus;

public class ClosedState implements TicketState {
    @Override
    public void handle(Ticket ticket, TicketContext context) {
        // Terminal state (no further transitions)
        context.getLogger().log("Ticket closed");
        ticket.setStatus(TicketStatus.CLOSED);
    }
}
