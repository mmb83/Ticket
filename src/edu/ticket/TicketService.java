package edu.ticket;

import edu.ticket.factory.AssignmentStrategyFactory;
import edu.ticket.factory.ResponseStrategyFactory;
import edu.ticket.log.ConsoleLogger;
import edu.ticket.log.Logger;

/**
 * Orchestrates ticket processing.
 *
 * After refactor:
 * - Lifecycle transitions are delegated to TicketState (State pattern)
 * - Assignment/Response behaviours are delegated to strategies (Strategy pattern)
 * - Strategy selection is centralized in factories (Factory)
 */
public class TicketService {

    private final TicketContext context;

    public TicketService() {
        Logger logger = new ConsoleLogger();
        this.context = new TicketContext(
                logger,
                new AssignmentStrategyFactory(),
                new ResponseStrategyFactory()
        );
    }

    public TicketService(TicketContext context) {
        this.context = context;
    }

    public void handle(Ticket ticket) {
        // Drive the state machine until CLOSED.
        while (!ticket.isClosed()) {
            ticket.getState().handle(ticket, context);
        }

        // End-of-processing log (explicit requirement in the assignment)
        context.getLogger().log(
                "Logging ticket handling: " + ticket.getId() +
                        " -> " + ticket.getStatus() +
                        (ticket.getResponse() != null ? " | response=\"" + ticket.getResponse() + "\"" : "")
        );
    }
}
