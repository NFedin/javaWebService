package com.testtask.javaweb.repository;

import com.testtask.javaweb.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<TicketEntity, Long> {
    List<TicketEntity> findAll();

    List<TicketEntity> findAllByTopic(String topic);

    List<TicketEntity> findAllByAuthor(String author);
}
