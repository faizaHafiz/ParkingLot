package Repositories;

import models.Ticket;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TicketRepository {
    Map<Long,Ticket> ticketMap = new HashMap<>();
    public Ticket saveTicket(Ticket ticket){
        Random random = new Random();
        long ticketid = random.nextLong(1000L);
        ticket.setNumber(ticketid);
        ticketMap.put(ticketid,ticket);
        return ticket;
    }
}
