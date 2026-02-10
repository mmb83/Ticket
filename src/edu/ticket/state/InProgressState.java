package edu.ticket.state;

import edu.ticket.Ticket;
import edu.ticket.TicketContext;
import edu.ticket.TicketStatus;
import edu.ticket.strategy.ResponseStrategy;

public class InProgressState implements TicketState {
    @Override
    public void handle(Ticket ticket, TicketContext context) {
        context.getLogger().log("Working on ticket");

        ResponseStrategy strategy = context.getResponseStrategyFactory().get(ticket.getType());
        String response = strategy.createResponse(ticket);
        ticket.setResponse(response);

        // Informational log to match the original behaviour
        switch (ticket.getType()) {
            case BUG -> context.getLogger().log("Sending bug response");
            case GENERAL -> context.getLogger().log("Sending generic response");
        }

        ticket.setState(new ResolvedState(), TicketStatus.RESOLVED);
    }
}
