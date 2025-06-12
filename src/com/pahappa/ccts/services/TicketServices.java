package com.pahappa.ccts.services;

import com.pahappa.ccts.models.Ticket;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

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

        Iterator<Ticket> iterator = tickets.iterator();
        while (iterator.hasNext()) {
            Ticket t = iterator.next();
            if (t.getId() == id) {
                iterator.remove();  //"safe deletion."
                return "Ticket " +id+  " successfully deleted";
            }
        }
        return "Error: Ticket " +id+  " not found. Deletion failed.";
    }


    //to search...
    public List<Ticket> searchTickets(String customerName, String category, String status) {
        List<Ticket> results = new ArrayList<>();
        for (Ticket t : tickets) {
            boolean nameMatch = t.getCustomerName().toLowerCase().contains(customerName.toLowerCase()); //1. Case-insensitive(if exact match) 2. If customer name contains search text
            boolean categoryMatch = t.getCategory().equalsIgnoreCase(category); //Category -- exact match? (case-insensitive)
            boolean statusMatch = t.getStatus().equalsIgnoreCase(status); //Case-insensitive(if exact match)

            if (nameMatch && categoryMatch && statusMatch) {
                results.add(t);            //Add to the ticket arraylist if the particular ticket passes all the3 checks; above.
            }
        }
        return results;
    }


}


