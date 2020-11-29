package com.group12.service.ticket;

import com.group12.entity.Issue;
import com.group12.entity.Ticket;
import com.group12.service.IService;
import java.util.Set;

public interface TicketService extends IService<Ticket, String> {
    Set<Ticket> getAll();




}
