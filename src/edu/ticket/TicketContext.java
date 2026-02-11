package edu.ticket;

import edu.ticket.factory.AssignmentStrategyFactory;
import edu.ticket.factory.ResponseStrategyFactory;
import edu.ticket.log.Logger;

/**
 * Container for application-level collaborators.
 * States can use this context to access strategies/factories and logging.
 */
public class TicketContext {
    private final Logger logger;
    private final AssignmentStrategyFactory assignmentStrategyFactory;
    private final ResponseStrategyFactory responseStrategyFactory;

    public TicketContext(Logger logger,
                         AssignmentStrategyFactory assignmentStrategyFactory,
                         ResponseStrategyFactory responseStrategyFactory) {
        this.logger = logger;
        this.assignmentStrategyFactory = assignmentStrategyFactory;
        this.responseStrategyFactory = responseStrategyFactory;
    }

    public Logger getLogger() {
        return logger;
    }

    public AssignmentStrategyFactory getAssignmentStrategyFactory() {
        return assignmentStrategyFactory;
    }

    public ResponseStrategyFactory getResponseStrategyFactory() {
        return responseStrategyFactory;
    }
}
