package com.testtask.javaweb.service;

import com.testtask.javaweb.entity.NoteEntity;
import com.testtask.javaweb.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public void createNote(NoteEntity noteEntity) {
        noteRepository.save(noteEntity);

    }

    public List<NoteEntity> findAll() {
        return noteRepository.findAll();
    }

    public NoteEntity findById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    public List<NoteEntity> findAllByType(String type) {
        return noteRepository.findAllByType(type);
    }

    public List<NoteEntity> findAllByAuthor(String author) {
        return noteRepository.findAllByAuthor(author);
    }


}
