package com.group12.factory;


import com.group12.entity.Ticket;
import com.group12.entity.Issue;
import com.group12.util.GenerateID;
import java.time.LocalDate;
import java.time.LocalDateTime;

/** Author: Stefano Ngantweni
 *   Student no: 216 283 132
 *   Date: 02-07-2020
 *   Description: Entity for Ticket
 */


public class TicketFactory {

    public static Ticket createTicket(Ticket newTicket){
        LocalDateTime now = LocalDateTime.now();
        String ticketID= GenerateID.generateID();

        Ticket ticket = new Ticket.Builder()
                .setTicketId(ticketID)
                .setTicketIssue(newTicket.getIssue())
                .setTicketDesc(newTicket.getTicketDesc())
                .setCreatedByUser(newTicket.getCreatedByUser())
                .setTicketDate(now)
                .build();
        return ticket;
    }

}