package edu.ticket;

public class TicketService {


    public void handle(Ticket ticket) {
        String currentStatus = ticket.status;
        String type = ticket.type;
        String channel = ticket.channel;

        if (currentStatus.equals("NEW")) {
            System.out.println("Ticket created");

            if (channel.equals("WEB")) {
                System.out.println("Received from web");
            } else if (channel.equals("EMAIL")) {
                System.out.println("Received from email");
            }

            ticket.setStatus("ASSIGNED");
        }

        if (currentStatus.equals("ASSIGNED")) {
            if (type.equals("BUG")) {
                System.out.println("Assigned to engineering");
            } else {
                System.out.println("Assigned to support");
            }
            ticket.setStatus("IN_PROGRESS");
        }

        if (currentStatus.equals("IN_PROGRESS")) {
            System.out.println("Working on ticket");

            if (type.equals("BUG")) {
                System.out.println("Sending bug response");
            } else {
                System.out.println("Sending generic response");
            }

            ticket.setStatus("RESOLVED");
        }

        if (currentStatus.equals("RESOLVED")) {
            System.out.println("Ticket resolved");
            ticket.setStatus("CLOSED") ;
        }

        if (currentStatus.equals("CLOSED")) {
            System.out.println("Ticket closed");
        }

        System.out.println("Logging ticket handling : " + ticket.getId() + " -> " + ticket.status);
    }
}
