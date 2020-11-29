//package com.group12.repository.ticket.impl;
//
//import com.group12.entity.Issue;
//import com.group12.entity.Ticket;
//import com.group12.factory.IssueFactory;
//import com.group12.factory.TicketFactory;
//import com.group12.repository.ticket.TicketRepository;
//import org.junit.Assert;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Set;
//import java.util.stream.Collectors;
//
//import static org.junit.Assert.*;
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
///**
// * @author Stefano Ngantweni - 216283132
// * Desc: Repository Implementation test for ticket
// * Date: 28 August 2020
// */
//
//public class TicketRepositoryImplTest {
//    @Autowired
//    private static TicketRepository repository;//
//    private static Issue issue = IssueFactory.createIssue("Health","First aid kits need replacing");
//    private static Ticket ticket = TicketFactory.createTicket(issue);
//    private static Issue newIss = IssueFactory.createIssue("Health","First aid kits need replacing");
//
//   //This checks if the ticketId of the ticket created is the same as the one parsed into the method
//    @Test
//    public void a_create() {
//        Ticket created = repository.save(ticket);
//        Assert.assertEquals(ticket.getTicketId(), created.getTicketId());
//        System.out.println("Created: "+created);
//    }
//
//    //This checks if the read method returns the correct ticket
//    @Test
//    public void b_read() {
//        Ticket read = repository.findById(ticket.getTicketId()).orElse(null);
//        Assert.assertEquals(ticket, read);
//        System.out.println("Read: "+ read);
//    }
//
//    //This method checks if you can update a Ticket in the repository
//    @Test
//    public void c_update() {
//
//        Ticket updated = new Ticket.Builder()
//                .copy(ticket)
//                .setTicketIssue(newIss)
//                .build();
//        updated = repository.save(updated);
//        Assert.assertEquals(newIss.getIssueID(),updated.getTicketId());
//        System.out.println("Updated: "+ updated);
//
//    }
//
//    //This method checks if you can delete a Ticket in the repository
//    @Test
//    public void e_delete() {
//        boolean deleted;
//        String id = ticket.getTicketId();
//        repository.deleteById(id);
//        if(this.repository.existsById(id))
//            deleted = false;
//        else deleted = true;
//        assertTrue(deleted);
//    }
//
//    //This method checks if you can return all the Tickets in the repository
//    @Test
//    public void d_getAll() {
//        Set tcks = repository.findAll().stream().collect(Collectors.toSet());
//        System.out.println("All Tickets: " + tcks);
//        assertEquals(1, tcks.size());
//    }
//}