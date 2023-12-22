package com.wiss.m223.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wiss.m223.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    // Methoden um Kommentare zu finden, z.B. nach Post
}
