package edu.ticket.state;

import edu.ticket.Ticket;
import edu.ticket.TicketContext;

public interface TicketState {
    void handle(Ticket ticket, TicketContext context);
}
