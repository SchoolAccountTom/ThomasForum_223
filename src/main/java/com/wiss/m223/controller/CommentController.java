package com.wiss.m223.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wiss.m223.service.CommentService;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    // POST-Methode zum Erstellen eines neuen Kommentars
    // GET-Methode zum Abrufen von Kommentaren
    // DELETE-Methode zum Löschen eines Kommentars (sicherstellen, dass dies nur von berechtigten Benutzern durchgeführt werden kann)
}

