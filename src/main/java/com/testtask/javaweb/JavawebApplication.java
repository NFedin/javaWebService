package com.testtask.javaweb;

import com.testtask.javaweb.entity.NoteEntity;
import com.testtask.javaweb.entity.TicketEntity;
import com.testtask.javaweb.service.NoteService;
import com.testtask.javaweb.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

/**
 * 24-08-2019
 * <p>
 * Created by Fedin N.O.
 */

@SpringBootApplication
public class JavawebApplication {
    @Autowired
    private NoteService noteService;

    @Autowired
    private TicketService ticketService;


    public static void main(String[] args) {
        SpringApplication.run(JavawebApplication.class, args);

    }


    @EventListener(ApplicationReadyEvent.class)
    public void testJpaMethods() {

        TicketEntity ticket = new TicketEntity();
        ticket.setAssignee("assignee");
        ticket.setAuthor("Author--------------------------");
        ticket.setCreationDate("2019-08-08");
        ticket.setDescription("Description");
        ticket.setTopic("Topic");


        NoteEntity note = new NoteEntity();
        note.setAuthor("Author_Note");
        note.setDate("2019-08-08_Note");
        note.setDescription("Description__Note");
        note.setType("Type_Note");
        note.setTicketEntity(ticket);
        noteService.createNote(note);

        noteService.findAll().forEach(it -> System.out.println(it));

        System.out.println(ticketService.findById(1L));

        System.out.println(noteService.findAllByAuthor("Author_Note"));

    }
}




