package com.testtask.javaweb.repository;

import com.testtask.javaweb.entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<NoteEntity, Long> {
    List<NoteEntity> findAll();

    List<NoteEntity> findAllByType(String type);

    List<NoteEntity> findAllByAuthor(String author);
}
