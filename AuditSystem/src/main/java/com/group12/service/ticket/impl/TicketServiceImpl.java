package com.group12.service.ticket.impl;

import com.group12.entity.Issue;
import com.group12.entity.Ticket;
import com.group12.repository.ticket.TicketRepository;

import com.group12.service.ticket.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
        * @author Stefano Ngantweni - 216283132
        * Desc: Service Implementation class for ticket
        * Date: 4 September 2020
        */

@Service
public class TicketServiceImpl implements TicketService {

    private static TicketService service = null;
    @Autowired
    private TicketRepository repository;






    //CRUD
    @Override
    public Ticket create(Ticket t) {
        return this.repository.save(t);
    }

    @Override
    public Ticket read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public Ticket update(Ticket t) {
        if (this.repository.existsById(t.getTicketId())){
            return this.repository.save(t);
    }else {
            return null;
        }
        }

    @Override
    public boolean delete(String s) {
        this.repository.deleteById(s);
        if(this.repository.existsById(s)) {
            return false;
        }else {
            return true;
        }

    }

    @Override
    public Set<Ticket> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    /**
     * Business Logic
     */
    //Business Logic 1: When you want close a ticket when the issue has been resolved
    public boolean closeTicket(String tickId) {
        boolean ticketClose = false;
        Ticket ticket = read(tickId);
        Issue issSolved = new Issue.Builder().copy(ticket.getIssue()).setIssueStatus(true).build();
        Ticket tcktSolved;
        Issue iss = ticket.getIssue();

        if (!(iss.getIssueStatus())) {

            tcktSolved = new Ticket.Builder().copy(ticket).setTicketIssue(issSolved).build();
            update(tcktSolved);
            ticketClose = true;
            System.out.println("Ticket has been closed");
        }
        return ticketClose;
    }


    //Business Logic 2: When you want close a ticket when the issue has been resolved
    public Set<Ticket> getAllOpen(){
        Set<Ticket> openTick = new HashSet<>();

        for(Ticket ticket: getAll()) {
            if (!ticket.getIssue().getIssueStatus()) {
                openTick.add(ticket);
            }
        }
        return openTick;
    }

}

