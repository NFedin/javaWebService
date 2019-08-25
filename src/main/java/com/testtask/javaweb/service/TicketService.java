package com.testtask.javaweb.service;

import com.testtask.javaweb.entity.TicketEntity;
import com.testtask.javaweb.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public void createTicket(TicketEntity ticketEntity) {
        ticketRepository.save(ticketEntity);
    }

    public List<TicketEntity> findAll() {
        return ticketRepository.findAll();
    }

    public TicketEntity findById(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }
}
