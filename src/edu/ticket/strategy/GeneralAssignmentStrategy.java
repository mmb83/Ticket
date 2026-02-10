package edu.ticket.strategy;

import edu.ticket.Department;
import edu.ticket.Ticket;

public class GeneralAssignmentStrategy implements AssignmentStrategy {
    @Override
    public Department assignDepartment(Ticket ticket) {
        return Department.SUPPORT;
    }
}
