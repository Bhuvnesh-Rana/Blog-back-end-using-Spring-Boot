package com.blog.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.DTO.PostDTO;
import com.blog.Service.PostService;

import jakarta.validation.Valid;

@RestController
public class PostController {

    @Autowired
    private PostService postService;
    
    @PostMapping("post/user/{userId}/category/{categoryId}")
    public PostDTO addPost(@Valid @RequestBody PostDTO postDTO,@PathVariable Integer userId,@PathVariable Integer categoryId){
        System.out.println(userId);
        return postService.addPost(postDTO, userId, categoryId); 
    }

    @PutMapping("/post/{postId}")
    public PostDTO updatePost(@Valid @RequestBody PostDTO postDTO,@PathVariable Integer postId){
        return postService.updatePost(postDTO, postId);
    }

    @DeleteMapping("post/{postId}")
    public String deletePost(@PathVariable Integer postId){
        return postService.deletePost(postId);
    }

    @GetMapping("post")
    public List<PostDTO> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("post/{postId}")
    public PostDTO getPostById(@PathVariable Integer postId){
        return postService.getPostById(postId);
    }

    @GetMapping("post/user/{userId}")
    public List<PostDTO> getPostByUser(@PathVariable Integer userId){
        return postService.getPostByUser(userId);
    }

    @GetMapping("post/category/{categoryId}")
    public List<PostDTO> getPostByCategory(@PathVariable Integer categoryId){
        return postService.getPostByCategory(categoryId);
    }

    @GetMapping("post/search/{keyword}")
    public ResponseEntity<List<PostDTO>> searchByTitle(@PathVariable String keyword){
        List<PostDTO> result = postService.searchPost(keyword);
        return new ResponseEntity<List<PostDTO>>(result,HttpStatus.OK);
    }
}
