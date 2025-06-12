package com.pahappa.ccts.services;

import com.pahappa.ccts.models.Ticket;

import java.util.List;
import java.util.Scanner;


public class CCTS_App {

    private static final TicketServices ticketServices = new TicketServices();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        System.out.println("Call Center Ticket System");
        while (true) {
            printMenu();
            int choice = getIntInput("Select option: ");
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createTicket();
                    break;
                case 2:
                    viewAllTickets();
                    break;
                case 3:
                    viewTicketDetails();
                    break;
                case 4:
                    updateTicket();
                    break;
                case 5:
                    deleteTicketByID();
                    break;
                case 6:
                    searchTickets();
                    break;
                case 7:
                    System.out.println("Exiting system...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. Create New Ticket");
        System.out.println("2. View All Tickets");
        System.out.println("3. View Ticket Details");
        System.out.println("4. Update Ticket");
        System.out.println("5. Delete Ticket");
        System.out.println("6. Search Tickets");
        System.out.println("7. Exit System");
    }


    private static void createTicket() {
        System.out.println("\n--- CREATE NEW TICKET ---");
        System.out.print("Customer Name: ");
        String name = scanner.nextLine();

        System.out.print("Contact Info: ");
        String contact = scanner.nextLine();

        System.out.print("Category: ");
        String category = scanner.nextLine();

        System.out.print("Description: ");
        String description = scanner.nextLine();

        Ticket newTicket = ticketServices.createTicket(name, contact, category, description);
        System.out.println("\nTicket created successfully! ID: " + newTicket.getId());
    }


    private static void viewAllTickets() {
        List<Ticket> tickets = ticketServices.getTickets();
        if (tickets.isEmpty()) {
            System.out.println("\nNo tickets found.");
            return;
        }

        System.out.println("--- ALL TICKETS ---");
        System.out.println("ID\tCustomer\t\tCategory\tStatus");
        System.out.println("------------------------------------------------");
        for (Ticket t : tickets) {
            System.out.println(
                    t.getId()+"\t"+
                    t.getCustomerName()+"\t\t"+
                    t.getCategory()+"\t"+
                    t.getStatus());
        }
    }

    private static void viewTicketDetails() {
        int id = getIntInput("\nEnter Ticket ID: ");
        scanner.nextLine();

        Ticket t = ticketServices.getTicketById(id);
        System.out.println((t != null)? "\n" + t : "Ticket not found!");
    }

    private static void updateTicket() {
        int id = getIntInput("\nEnter Ticket ID to update: ");
        scanner.nextLine();

        Ticket t = ticketServices.getTicketById(id);
        if (t == null) {
            System.out.println("Ticket not found!");
            return;
        }

        System.out.println("\nCurrent Status: " + t.getStatus());
        System.out.print("New Status: ");
        String status = scanner.nextLine();

        System.out.println("Current Priority: " + t.getPriorityLevel());
        System.out.print("New Priority: ");
        String priority = scanner.nextLine();

        System.out.print("Additional Comments: ");
        String comment = scanner.nextLine();

        if (!status.isEmpty()){
            t.setStatus(status);
        }
        if (!priority.isEmpty()) {
            t.setPriorityLevel(priority);
        }
        if (!comment.isEmpty()) {
            t.addComment(comment);
        }

        System.out.println("\nTicket updated successfully!");
    }

    private static void deleteTicketByID() {
        int id = getIntInput("\nEnter Ticket ID to delete: ");
        scanner.nextLine();

        //delete ticket and then get a result message:
        String result = ticketServices.deleteTicketById(id);
        System.out.println(result);
    }


    private static void searchTickets() {
        System.out.println("\n--- SEARCH TICKETS ---");

        System.out.print("Customer Name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Category: ");
        String category = scanner.nextLine().trim();

        System.out.print("Status: ");
        String status = scanner.nextLine().trim();

        List<Ticket> results = ticketServices.searchTickets(name, category, status);
        displaySearchResults(results);
    }


    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.nextLine();
            System.out.print(prompt);
        }
        return scanner.nextInt();
    }



    private static void displaySearchResults(List<Ticket> results) {
        if (results.isEmpty()) {
            System.out.println("\nNo matching tickets found.");
            return;
        }

        System.out.println("\n--- SEARCH RESULTS (" + results.size() + " TICKETS) ---");
        System.out.println("ID\tStatus\t\tCategory\tCustomer");
        System.out.println("------------------------------------------------");

        for (Ticket ticket : results) {
            System.out.println(
                    ticket.getId()+"\t"+
                    ticket.getStatus()+"\t\t"+
                    ticket.getCategory()+"\t"+
                    ticket.getCustomerName());
        }

        System.out.println("\nEnter ticket ID to view details, or 0 to return");
        int choice = getIntInput("Selection: ");
        scanner.nextLine();  // Consume newline

        if (choice > 0) {
            viewTicketDetails(choice);
        }
    }


    private static void viewTicketDetails(int id){
        Ticket ticket = ticketServices.getTicketById(id);
        if (ticket != null) {
            System.out.println("\n--- TICKET DETAILS ---");
            System.out.println(ticket);
        } else {
            System.out.println("Invalid ticket ID!");
        }
        scanner.nextLine();
    }


}