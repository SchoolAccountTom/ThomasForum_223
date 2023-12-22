package com.wiss.m223.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wiss.m223.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    // Methoden um Posts zu finden, z.B. nach User
}
