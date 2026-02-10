package edu.ticket.state;

import edu.ticket.Department;
import edu.ticket.Ticket;
import edu.ticket.TicketContext;
import edu.ticket.TicketStatus;
import edu.ticket.strategy.AssignmentStrategy;

public class AssignedState implements TicketState {
    @Override
    public void handle(Ticket ticket, TicketContext context) {
        AssignmentStrategy strategy = context.getAssignmentStrategyFactory().get(ticket.getType());
        Department dept = strategy.assignDepartment(ticket);

        switch (dept) {
            case ENGINEERING -> context.getLogger().log("Assigned to engineering");
            case SUPPORT -> context.getLogger().log("Assigned to support");
        }

        ticket.setState(new InProgressState(), TicketStatus.IN_PROGRESS);
    }
}
