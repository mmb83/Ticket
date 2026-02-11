package edu.ticket.factory;

import edu.ticket.TicketType;
import edu.ticket.strategy.AssignmentStrategy;
import edu.ticket.strategy.BugAssignmentStrategy;
import edu.ticket.strategy.GeneralAssignmentStrategy;

public class AssignmentStrategyFactory {
    public AssignmentStrategy get(TicketType type) {
        return switch (type) {
            case BUG -> new BugAssignmentStrategy();
            case GENERAL -> new GeneralAssignmentStrategy();
        };
    }
}
