package com.testtask.javaweb.entity;

import javax.persistence.*;

@Entity
@Table(name = "note")
public class NoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private String date;

    @Column(name = "author")
    private String author;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ticket_id")
    private TicketEntity ticketEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public TicketEntity getTicketEntity() {
        return ticketEntity;
    }

    public void setTicketEntity(TicketEntity ticketEntity) {
        this.ticketEntity = ticketEntity;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", author=" + author + '}';
    }

}
