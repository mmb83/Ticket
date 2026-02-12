package edu.ticket;

import edu.ticket.state.NewState;
import edu.ticket.state.TicketState;

/**
 * Domain entity representing a support ticket.
 *
 * Key refactor:
 * - Replaced stringly-typed fields with enums.
 * - Delegated lifecycle behaviour to State objects (State pattern).
 */
public class Ticket {
    private final int id;
    private TicketStatus status;
    private TicketChannel channel;
    private TicketType type;

    private String request;
    private String response;

    // State pattern
    private TicketState state;

    public Ticket(int id, TicketChannel channel, TicketType type) {
        this.id = id;
        this.channel = channel;
        this.type = type;

        // initial state
        this.status = TicketStatus.NEW;
        this.state = new NewState();
    }

    public int getId() {
        return id;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public TicketChannel getChannel() {
        return channel;
    }

    public void setChannel(TicketChannel channel) {
        this.channel = channel;
    }

    public TicketType getType() {
        return type;
    }

    public void setType(TicketType type) {
        this.type = type;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public boolean isClosed() {
        return status == TicketStatus.CLOSED;
    }

    public void setState(TicketState state, TicketStatus status) {
        this.state = state;
        this.status = status;
    }

    public TicketState getState() {
        return state;
    }
}
