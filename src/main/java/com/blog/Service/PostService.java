package com.blog.Service;

import java.util.List;

import com.blog.DTO.PostDTO;

public interface PostService {
    
    PostDTO addPost(PostDTO postDTO,Integer userId, Integer categoryId);
    PostDTO updatePost(PostDTO postDTO, Integer postId);
    String deletePost(Integer postId);
    List<PostDTO> getAllPosts();
    PostDTO getPostById(Integer postId);
    List<PostDTO> getPostByUser(Integer userId);
    List<PostDTO> getPostByCategory(Integer categoryId);
    List<PostDTO> searchPost(String keyword);
}
