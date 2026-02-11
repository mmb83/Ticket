package edu.ticket.factory;

import edu.ticket.TicketType;
import edu.ticket.strategy.BugResponseStrategy;
import edu.ticket.strategy.GenericResponseStrategy;
import edu.ticket.strategy.ResponseStrategy;

public class ResponseStrategyFactory {
    public ResponseStrategy get(TicketType type) {
        return switch (type) {
            case BUG -> new BugResponseStrategy();
            case GENERAL -> new GenericResponseStrategy();
        };
    }
}
