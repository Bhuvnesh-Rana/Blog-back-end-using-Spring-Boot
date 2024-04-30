package com.blog.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.DTO.CommentDTO;
import com.blog.Entity.Comment;
import com.blog.Entity.Post;
import com.blog.Repository.CommentRepository;
import com.blog.Repository.PostRepository;
import com.blog.Service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDTO addComment(CommentDTO commentDTO, Integer postId) {
        Post post = postRepository.findById(postId).get();
        Comment comment = modelMapper.map(commentDTO, Comment.class);
        comment.setPost(post);
        Comment savedComment = commentRepository.save(comment);
        CommentDTO commentDTO2 = modelMapper.map(savedComment, CommentDTO.class);

        return commentDTO2;
    }

    @Override
    public String deleteComment(Integer commentId) {
        Comment comment = commentRepository.findById(commentId).get();
        commentRepository.delete(comment);
        return "Comment deletd with commentId: "+comment.getCommentId();
    }

    @Override
    public List<CommentDTO> getAllComments() {
        List<Comment> comments = commentRepository.findAll();
        List<CommentDTO> commentDTOs = comments.stream().map(com -> modelMapper.map(com, CommentDTO.class)).collect(Collectors.toList());
        return commentDTOs;
    }
    
}
