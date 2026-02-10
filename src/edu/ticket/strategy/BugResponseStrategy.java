package edu.ticket.strategy;

import edu.ticket.Ticket;

public class BugResponseStrategy implements ResponseStrategy {
    @Override
    public String createResponse(Ticket ticket) {
        return "Thanks for reporting the bug. Our engineering team is investigating.";
    }
}
