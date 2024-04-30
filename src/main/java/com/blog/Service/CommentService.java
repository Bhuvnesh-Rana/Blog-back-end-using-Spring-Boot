package com.blog.Service;

import java.util.List;

import com.blog.DTO.CommentDTO;

public interface CommentService {
    CommentDTO addComment(CommentDTO commentDTO, Integer postId);
    String deleteComment(Integer commentId);
    List<CommentDTO> getAllComments();
}
