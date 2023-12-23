package com.wiss.m223.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wiss.m223.model.Post;
import com.wiss.m223.repository.PostRepository;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    // Methode, um alle Posts zu finden, deren Titel den gegebenen String enthält
    public List<Post> findPostsByTitleContaining(String title) {
        return postRepository.findByTitleContaining(title);
    }

    // Methode, um einen neuen Post zu erstellen
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    // Methode, um alle Posts zu erhalten
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // Methode, um einen Post zu löschen
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
