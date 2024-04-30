package com.blog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.Entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    
}
