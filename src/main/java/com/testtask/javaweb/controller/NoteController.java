package com.testtask.javaweb.controller;

import com.testtask.javaweb.entity.NoteEntity;
import com.testtask.javaweb.exception.NoteNotFoundException;
import com.testtask.javaweb.repository.NoteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class NoteController {
    NoteRepository repository;

    public NoteController(NoteRepository repository) {
        this.repository = repository;
    }

    @GetMapping("note")
    public List<NoteDto> getAllNote() {
        return repository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/note")
    public NoteEntity createTicket(@Valid @RequestBody NoteEntity noteEntity) {
        return repository.save(noteEntity);
    }

    @GetMapping("/note/{id}")
    public NoteEntity getNoteById(@PathVariable(value = "id") Long id) throws NoteNotFoundException {
        return repository.findById(id).orElseThrow(() -> new NoteNotFoundException(id));
    }

    @PutMapping("/note/{id}")
    public NoteEntity updateNote(@PathVariable(value = "id") Long id, @Valid @RequestBody NoteEntity noteDetails) throws NoteNotFoundException {
        NoteEntity note = repository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException(id));

        note.setType(noteDetails.getType());
        note.setDescription(noteDetails.getDescription());

        note.setDate(noteDetails.getDate());
        note.setAuthor(noteDetails.getAuthor());

        NoteEntity updateNote = repository.save(note);
        return updateNote;
    }

    @DeleteMapping("/note/{id}")
    public ResponseEntity deleteNote(@PathVariable(value = "id") Long id) throws NoteNotFoundException {
        NoteEntity note = repository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException(id));
        repository.delete(note);
        return ResponseEntity.ok().build();
    }

    private NoteDto toDto(NoteEntity entity) {
        NoteDto dto = new NoteDto();
        dto.author = entity.getAuthor();
        dto.description = entity.getDescription();
        dto.id = entity.getId();
        dto.date = entity.getDate();
        dto.type = entity.getType();
        return dto;
    }
}
