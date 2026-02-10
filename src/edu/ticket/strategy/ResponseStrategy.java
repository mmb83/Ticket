package edu.ticket.strategy;

import edu.ticket.Ticket;

public interface ResponseStrategy {
    String createResponse(Ticket ticket);
}
