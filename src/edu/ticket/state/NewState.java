package edu.ticket.state;

import edu.ticket.Ticket;
import edu.ticket.TicketContext;
import edu.ticket.TicketStatus;

public class NewState implements TicketState {
    @Override
    public void handle(Ticket ticket, TicketContext context) {
        context.getLogger().log("Ticket created");

        switch (ticket.getChannel()) {
            case WEB -> context.getLogger().log("Received from web");
            case EMAIL -> context.getLogger().log("Received from email");
        }

        // move to next state
        ticket.setState(new AssignedState(), TicketStatus.ASSIGNED);
    }
}
