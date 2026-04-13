package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Note;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Note;
import com.example.demo.services.NotesService;
@RestController
@RequestMapping(path="/notes")

public class NotesController {
	@Autowired
	NotesService notesService;
	
@GetMapping
Note getNotes()
{
	return notesService.getNotes();
}

@PostMapping
void setNotes(@RequestParam Note note)
{
	notesService.createNotes(note);
}
}
