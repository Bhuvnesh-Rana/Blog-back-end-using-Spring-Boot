package com.blog.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.DTO.CommentDTO;
import com.blog.Service.CommentService;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;


    @PostMapping("comment/post/{postId}")
    public CommentDTO addComment(@RequestBody CommentDTO commentDTO,@PathVariable Integer postId){
        return commentService.addComment(commentDTO, postId);
    }
    

    @DeleteMapping("comment/{commentId}")
    public String deleteComment(@PathVariable Integer commentId){
        return commentService.deleteComment(commentId);
    }

    @GetMapping("comment")
    public List<CommentDTO> getAllComments(){
        return commentService.getAllComments();
    }
}
