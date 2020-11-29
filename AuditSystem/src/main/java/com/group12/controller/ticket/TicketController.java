package com.group12.controller.ticket;

import com.group12.entity.Issue;
import com.group12.entity.Ticket;
import com.group12.factory.IssueFactory;
import com.group12.factory.TicketFactory;
import com.group12.service.issue.impl.IssueServiceImpl;
import com.group12.service.ticket.impl.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/ticket")
@CrossOrigin(origins = "*")
public class TicketController {

    @Autowired
    private TicketServiceImpl ticketService;

    @PostMapping("/create")
    public Ticket create(@RequestBody Ticket ticket){
        return ticketService.create(TicketFactory.createTicket(new Ticket.Builder().copy(ticket).build()));
    }

    @GetMapping("/read/{id}")
    public Ticket read(@PathVariable String id){
        return ticketService.read(id);
    }

    @PutMapping("/update")
    public Ticket update(@RequestBody Ticket ticket){
        return ticketService.update(ticket);
    }

    @GetMapping("/all")
    public Set<Ticket> getAll(){return ticketService.getAll();}

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return ticketService.delete(id);

    }

    //Business Logic
    @PostMapping("/closeTicket/{tickId}")
    public boolean closeTicket(@PathVariable String tickId){
        return ticketService.closeTicket(tickId);
    }

    @GetMapping("/openTickets")
    public Set<Ticket> getAllOpen(){
        return  ticketService.getAllOpen();
    }

}
