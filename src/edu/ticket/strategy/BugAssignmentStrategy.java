package edu.ticket.strategy;

import edu.ticket.Department;
import edu.ticket.Ticket;

public class BugAssignmentStrategy implements AssignmentStrategy {
    @Override
    public Department assignDepartment(Ticket ticket) {
        return Department.ENGINEERING;
    }
}
