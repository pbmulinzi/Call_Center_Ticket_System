package com.pahappa.ccts.services;

import com.pahappa.ccts.models.Ticket;
import java.util.ArrayList;
import java.util.List;

public class TicketServices {
    private final List<Ticket> tickets = new ArrayList<>();
    private int nextID = 1;


    //to create new tickets
    public Ticket createTicket(String customerName, String contactInfo, String category, String description) {
        Ticket newTicket = new Ticket(nextID++, customerName, contactInfo, category, description);
        tickets.add(newTicket);
        return newTicket;
    }

    //to read ticket(s)
    public List<Ticket> getTickets() {
        return tickets;
    }


    public Ticket getTicketById(int id) {
        for (Ticket t : tickets) {
            if (t.getId() == id) {     //Do they match?
                return t;
            }
        }
        return null;              // If not found
    }


    //to delete tickets
    public String deleteTicketById(int id) {
        for (Ticket t : tickets) {
            if (t.getId() == id) {
                tickets.remove(t);
                return "Ticket successfully deleted";
            }

        }
        return "Ticket not found";
    }


    //to search...
    public List<Ticket> searchTickets(String customerName, String category, String status) {
        List<Ticket> results = new ArrayList<>();
        for (Ticket t : tickets) {
            boolean nameMatch = customerName.isEmpty() || t.getCustomerName().toLowerCase().contains(customerName.toLowerCase());
            boolean categoryMatch = category.isEmpty()|| t.getCategory().equalsIgnoreCase(category);
            boolean statusMatch = status.isEmpty() || t.getStatus().equalsIgnoreCase(status);

            if (nameMatch && categoryMatch && statusMatch) {
                results.add(t);
            }
        }
        return results;
    }


}


