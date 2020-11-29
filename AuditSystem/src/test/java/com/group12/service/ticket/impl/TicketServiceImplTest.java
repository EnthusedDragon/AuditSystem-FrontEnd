package com.group12.service.ticket.impl;

import com.group12.entity.Issue;
import com.group12.entity.Ticket;
import com.group12.entity.UserAccount;
import com.group12.factory.IssueFactory;
import com.group12.factory.TicketFactory;
import com.group12.service.ticket.TicketService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
/**
 * @author Stefano Ngantweni - 216283132
 * Desc: Repository Implementation test for ticket
 * Date: 05 September 2020
 */
public class TicketServiceImplTest {

    @Autowired
    private static TicketService service;//
    private static Issue issue = IssueFactory.createIssue("Health","First aid kits need replacing", "1234-1234",new UserAccount.Builder().build());
    private static Ticket ticket = TicketFactory.createTicket(new Ticket.Builder().build());
    private static Issue newIss = new Issue.Builder().copy(issue).setIssueStatus(true).build();


    /* Business Logic Tests*/
    // This is the test for business logic 1. closes a ticket that has a resolved issue status
    @Test
    public void g_closeTicket() {
    }

    //This is the test for business logic 2. Returns all open tickets
    @Test
    public void f_getAllOpen() {
    }

    /* CRUD Tests*/

    //This is a test for the create method in the TicketServiceImpl
    @Test
    public void a_create() {
        try {
            // creates a userAccount in the repository, service calls it from the Repository
            Ticket created = service.create(ticket);
            Assert.assertEquals(ticket.getTicketId(), created.getTicketId());
            System.out.println("Created: "+created);

        }catch(Exception e)
        {
            Assert.fail();
        }
    }

    @Test
    public void b_read() {
        try {
            Ticket read = service.read(ticket.getTicketId());
            Assert.assertEquals(ticket, read);
            System.out.println("Read: " + read);
        }catch (Exception e){
            Assert.fail();

        }
    }

    @Test
    public void c_update() {
        Ticket updated = new Ticket.Builder()
                .copy(ticket)
                .setTicketIssue(newIss)
                .build();
        updated = service.update(updated);
        Assert.assertEquals(newIss.getIssueID(),updated.getIssue());
        System.out.println("Updated: "+ updated);
    }

    @Test
    public void e_delete() {
        boolean deleted = service.delete(ticket.getTicketId());
        assertTrue(deleted);
    }

    @Test
    public void d_getAll() {
        System.out.println("All Tickets: " + service.getAll());
        assertEquals(1, service.getAll().size());
    }
}