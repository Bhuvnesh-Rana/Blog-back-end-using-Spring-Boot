package com.blog.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.Entity.Category;
import com.blog.Entity.Post;
import com.blog.Entity.User;

public interface PostRepository extends JpaRepository<Post, Integer> {
    
    List<Post> findByCategory(Category category);
    List<Post> findByUser(User user);
    Post findByTitle(String Title);
    List<Post> findByTitleContaining(String title);
}
