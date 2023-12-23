package com.wiss.m223.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wiss.m223.model.Post;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByTitleContaining(String title);
}
