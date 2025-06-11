package com.pahappa.ccts.models;

public class Ticket {
    private int id;
    private String customerName;
    private String contactInfo;
    private String category;
    private String description;
    private String status;
    private String priorityLevel;
    private String comments;

    public Ticket(int id, String customerName, String contactInfo, String category, String description) {
        this.id = id;
        this.customerName = customerName;
        this.contactInfo = contactInfo;
        this.category = category;
        this.description = description;
        this.status = "Open";
        this.priorityLevel = "Medium";
        this.comments = "";

    }



    //getterss...
    public int getId() {
        return id;
    }
    public String getCustomerName() {
        return customerName;
    }
    public String getContactInfo() {
        return contactInfo;
    }
    public String getCategory() {
        return category;
    }
    public String getDescription() {
        return description;
    }
    public String getStatus() {
        return status;
    }
    public String getPriority() {
        return priorityLevel;
    }
    public String getComments() {
        return comments;
    }


    //setterss...
    public void setStatus(String status) {
        this.status = status;
    }
    public void setPriorityLevel(String priorityLevel) {
        this.priorityLevel = priorityLevel;
    }



    public void addComment(String comment) {
        if(!comments.isEmpty()){
            comments += "\n"+comment;
        }
    }



    @Override
    public String toString(){
        return "ID: "+ id +
                "\nCustomer Name: " + customerName +
                "\nContact Information: " + contactInfo +
                "\nTicket Category: " + category +
                "\nTicket Description: " + description +
                "\nTicket Status: " + status +
                "\nPriority Level: " + priorityLevel +
                "\nComments: " + comments;
    }
}

