package com.wiss.m223.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;

    // POST-Methode zum Erstellen eines neuen Beitrags
    // GET-Methode zum Abrufen von Beiträgen
    // DELETE-Methode zum Löschen eines Beitrags (sicherstellen, dass dies nur von berechtigten Benutzern durchgeführt werden kann)
}

