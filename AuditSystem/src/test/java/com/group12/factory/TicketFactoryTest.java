package com.group12.factory;

import com.group12.entity.*;
import org.junit.Assert;
import org.junit.Test;

public class TicketFactoryTest {

    @Test
    public void createTicket() {
            Ticket ticket = TicketFactory.createTicket(new Ticket.Builder().build());
            Assert.assertNotEquals(null, ticket.getTicketId());//if the ticket has a ticketID it has been created
            System.out.println(ticket);

    }

}