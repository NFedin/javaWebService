package com.testtask.javaweb.exception;

public class TicketNotFoundException extends Exception {
    private long id;

    public TicketNotFoundException(long id) {
        super(String.format("Ticket is not found with id : '%s'", id));
    }
}
