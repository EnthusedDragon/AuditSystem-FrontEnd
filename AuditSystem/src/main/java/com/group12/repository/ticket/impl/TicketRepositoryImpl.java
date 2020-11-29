///*
//package com.group12.repository.ticket.impl;
//
//import com.group12.entity.Ticket;
//import com.group12.repository.ticket.TicketRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//*/
///**
// * @author Stefano Ngantweni - 216283132
// * Desc: Repository Implementation class for ticket
// * Date: 28 August 2020
// *//*
//
//
//public class TicketRepositoryImpl implements TicketRepository {
//
//    private static TicketRepository repository = null;
//    private Set<Ticket> ticketDB;
//
//    private TicketRepositoryImpl(){ this.ticketDB = new HashSet<>();}
//
//
//    //to get the repository you want to work on
//    public static TicketRepository getRepository(){
//        if(repository == null) repository = new TicketRepositoryImpl();
//        return  repository;
//    }
//
//    @Override
//    public Ticket create(Ticket t) {//to create the ticket repo add the parsed ticket to the ticketDB Set
//        this.ticketDB.add(t);
//        return t;
//    }
//
//    @Override
//    public Ticket read(String id) {// to read from the ticketDB Set
//        Ticket ticket = this.ticketDB.stream()
//                .filter(t -> t.getTicketId().equalsIgnoreCase(id))
//                .findAny()
//                .orElse(null);
//        return ticket;
//    }
//
//    @Override
//    public Ticket update(Ticket t) {//updates the repo
//        boolean deleteTicket = delete(t.getTicketId());
//        if(deleteTicket){
//            this.ticketDB.add(t);
//            return t;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean delete(String id) {//deletes the ticket from the ticketDB Set
//        Ticket ticket = read(id);
//        //get the ticket
//        if(ticket != null){// ticket exists
//            this.ticketDB.remove(ticket);
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public Set<Ticket> getAll() {
//        return this.ticketDB;
//    }// returns the ticketDB Set
//
//}
//*/
