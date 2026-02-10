package edu.ticket.strategy;

import edu.ticket.Ticket;

public class GenericResponseStrategy implements ResponseStrategy {
    @Override
    public String createResponse(Ticket ticket) {
        return "Thanks for reaching out. Our support team will get back to you shortly.";
    }
}
