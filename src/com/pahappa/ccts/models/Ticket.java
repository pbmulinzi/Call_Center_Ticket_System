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
        this.priorityLevel = "Low";
        this.comments = "";

    }



    //getterss -> since the modifier(s) are private
    public int getId() {
        return id;
    }
    public String getCustomerName() {
        return customerName;
    }


    public String getCategory() {
        return category;
    }


    public String getStatus() {
        return status;
    }


    public String getPriorityLevel() {
        return priorityLevel;
    }


    //setterss...
    public void setStatus(String status) {
        this.status = status;
    }
    public void setPriorityLevel(String priorityLevel) {
        this.priorityLevel = priorityLevel;
    }



    //adding new comment(s).
    public void addComment(String comment) {
        if(comments.isEmpty()){
            comments += comment; //add a comment if there are no comments
        }else{
            comments += "\n";
            comments += comment; //still add a comment when there is already an existing comment(s)
        }
    }




    //convert to string for a neater/ clearer ticket display
    @Override
    public String toString(){
        return "ID: "+ id +
                "\nCustomer Name: " + customerName +
                "\nContact Information: " + contactInfo +
                "\nTicket Category: " + category +
                "\nTicket Description: " + description +
                "\nTicket Status: " + status +
                "\nPriority Level: " + priorityLevel +
                "\nComment(s): " + comments;
    }
}

