package com.testtask.javaweb.controller;

import com.testtask.javaweb.entity.TicketEntity;
import com.testtask.javaweb.exception.TicketNotFoundException;
import com.testtask.javaweb.repository.TicketRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TicketController {
    TicketRepository repository;

    public TicketController(TicketRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/ticket")
    public List<TicketDto> getAllTicket() {
        return repository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/ticket")
    public TicketEntity createTicket(@Valid @RequestBody TicketEntity ticketEntity) {
        return repository.save(ticketEntity);
    }

    @GetMapping("/ticket/{id}")
    public TicketEntity getTicketById(@PathVariable(value = "id") Long id) throws TicketNotFoundException {
        return repository.findById(id).orElseThrow(() -> new TicketNotFoundException(id));
    }

    @PutMapping("/ticket/{id}")
    public TicketEntity updateTicket(@PathVariable(value = "id") Long id, @Valid @RequestBody TicketEntity ticketDetails) throws TicketNotFoundException {
        TicketEntity ticket = repository.findById(id)
                .orElseThrow(() -> new TicketNotFoundException(id));

        ticket.setDescription(ticketDetails.getDescription());
        ticket.setTopic(ticketDetails.getTopic());
        ticket.setAssignee(ticketDetails.getAssignee());
        ticket.setAuthor(ticketDetails.getAuthor());
        ticket.setCreationDate(ticketDetails.getCreationDate());

        TicketEntity updateTicket = repository.save(ticket);
        return updateTicket;
    }

    @DeleteMapping("/ticket/{id}")
    public ResponseEntity deleteTicket(@PathVariable(value = "id") Long id) throws TicketNotFoundException {
        TicketEntity ticket = repository.findById(id)
                .orElseThrow(() -> new TicketNotFoundException(id));
        repository.delete(ticket);
        return ResponseEntity.ok().build();
    }

    private TicketDto toDto(TicketEntity entity) {
        TicketDto dto = new TicketDto();
        dto.id = entity.getId();
        dto.description = entity.getDescription();
        dto.assignee = entity.getAssignee();
        dto.author = entity.getAuthor();
        dto.creationDate = entity.getCreationDate();
        dto.topic = entity.getTopic();
        return dto;
    }
}
