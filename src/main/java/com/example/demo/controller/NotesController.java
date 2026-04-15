package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Note;
import com.example.demo.services.NotesService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000") 
@RestController
@RequestMapping(path = "/notes")
public class NotesController {

    @Autowired
    NotesService notesService;

  
    @GetMapping
    public Iterable<Note> getNotes() {
        return notesService.getNotes();
    }

   
    @PostMapping
    public String createNote(@Valid @RequestBody Note note) {
        notesService.createNotes(note);
        return "Note saved successfully ";
    }
}