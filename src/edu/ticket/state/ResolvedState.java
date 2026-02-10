package edu.ticket.state;

import edu.ticket.Ticket;
import edu.ticket.TicketContext;
import edu.ticket.TicketStatus;

public class ResolvedState implements TicketState {
    @Override
    public void handle(Ticket ticket, TicketContext context) {
        context.getLogger().log("Ticket resolved");
        // Transition to terminal state, but keep status as RESOLVED first.
        ticket.setState(new ClosedState(), TicketStatus.RESOLVED);
    }
}
