package com.wiss.m223.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wiss.m223.model.Comment;
import com.wiss.m223.service.CommentService;



@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentService CommentService;

    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        Comment newComment = CommentService.createComment(comment);
        return ResponseEntity.ok(newComment);
    }

    
}



