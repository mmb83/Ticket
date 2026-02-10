package edu.ticket.strategy;

import edu.ticket.Department;
import edu.ticket.Ticket;

public interface AssignmentStrategy {
    Department assignDepartment(Ticket ticket);
}
