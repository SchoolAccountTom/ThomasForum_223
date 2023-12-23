package com.wiss.m223.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wiss.m223.model.Post;
import com.wiss.m223.service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;

    // POST-Methode zum Erstellen eines neuen Beitrags
    @PostMapping
public ResponseEntity<Post> createPost(@RequestBody Post post) {
    Post savedPost = postService.createPost(post);
    return ResponseEntity.ok(savedPost);
}
    // GET-Methode zum Abrufen von Beiträgen
    @GetMapping
public ResponseEntity<List<Post>> getAllPosts() {
    List<Post> posts = postService.getAllPosts();
    return ResponseEntity.ok(posts);
}
    // DELETE-Methode zum Löschen eines Beitrags (sicherstellen, dass dies nur von berechtigten Benutzern durchgeführt werden kann)
    @DeleteMapping("/{id}")
public ResponseEntity<String> deletePost(@PathVariable Long id) {
    postService.deletePost(id);
    return ResponseEntity.ok("Post gelöscht");
}
}

