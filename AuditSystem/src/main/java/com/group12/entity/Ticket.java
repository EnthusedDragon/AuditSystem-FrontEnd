package com.group12.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/** Author: Stefano Ngantweni
 *   Student no: 216 283 132
 *   Date: 02-07-2020
 *   Description: Entity for Ticket
 */

@Entity
public class Ticket implements Serializable {
    @Id
    private String ticketId;
    private String ticketDesc;

    @ManyToOne
    private Issue issue;
    @ManyToOne
    private UserAccount createdByUser;

    private LocalDateTime ticketDate;

    protected Ticket(){

    }

    private Ticket(Builder builder) {
        this.ticketId = builder.ticketId;
        this.ticketDesc = builder.ticketDesc;
        this.issue = builder.ticketIssue;
        this.ticketDate = builder.ticketDate;
        this.createdByUser = builder.createdByUser;
    }

    //Getters
    public String getTicketId() { return ticketId; }
    public String getTicketDesc() { return ticketDesc; }
    public Issue getIssue() { return issue; }
    public LocalDateTime getTicketDate() { return ticketDate; }
    public UserAccount getCreatedByUser(){return  createdByUser;}

    @Override
    public String toString() {
        return "Builder{" +
                "ticketId=" + ticketId +
                ", ticketDesc='" + ticketDesc + '\'' +
                ", ticketIssue=" + issue +
                ", ticketDate=" + ticketDate +
                ", createdByUser=" + createdByUser +
                '}';
    }

    //Builder inner-class
    public static class Builder{
        private String ticketId;
        private String ticketDesc;
        private Issue ticketIssue;
        private LocalDateTime ticketDate;
        private UserAccount createdByUser;

        //Setters
        public Builder setTicketId(String ticketId) { this.ticketId = ticketId;
            return this;}
        public Builder setTicketDesc(String ticketDesc) { this.ticketDesc = ticketDesc;
            return this;}
        public Builder setTicketIssue(Issue ticketIssue) { this.ticketIssue = ticketIssue;
            return this;}
        public Builder setTicketDate(LocalDateTime ticketDate) { this.ticketDate = ticketDate;
            return this;}
        public Builder setCreatedByUser(UserAccount createdByUser) { this.createdByUser = createdByUser;
            return this;}
        //build method
        public Ticket build(){return new Ticket(this);}

        //copy method
        public Ticket.Builder copy( Ticket ticket)
        {
            this.ticketId = ticket.ticketId;
            this.ticketDesc = ticket.ticketDesc;
            this.ticketIssue = ticket.issue;
            this.ticketDate = ticket.ticketDate;
            this.createdByUser = ticket.createdByUser;
            return this;
        }
    }
}