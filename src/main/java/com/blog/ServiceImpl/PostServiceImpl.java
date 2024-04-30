package com.blog.ServiceImpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.DTO.PostDTO;
import com.blog.Entity.Category;
import com.blog.Entity.Post;
import com.blog.Entity.User;
import com.blog.Repository.CategoryRepository;
import com.blog.Repository.PostRepository;
import com.blog.Repository.UserRepository;
import com.blog.Service.PostService;

@Service
public class PostServiceImpl implements PostService  {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public PostDTO addPost(PostDTO postDTO, Integer userId, Integer categoryId) {
        Post post = modelMapper.map(postDTO, Post.class);     
        User user= userRepository.findById(userId).get();
        Category category = categoryRepository.findById(categoryId).get();

        Post checkPostTitle = postRepository.findByTitle(post.getTitle());
        if (checkPostTitle!=null) {
            System.out.println("title already exist try new....");
        }

        else{

        post.setImageName("default img");
        post.setDate(new Date());
        post.setUser(user);
        post.setCategory(category);
        // post.setComments(comment);
        Post savedPost = postRepository.save(post);
        PostDTO postDTO2 = modelMapper.map(savedPost, PostDTO.class);
        return postDTO2;
    }
    return null;
}

    @Override
    public PostDTO updatePost(PostDTO postDTO, Integer postId) {
        Post post = postRepository.findById(postId).get();
        // post.setCategory(postDTO.getCategory());        How can i update category??
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());

        Post savedPost = postRepository.save(post);
        PostDTO postDTO2 = modelMapper.map(savedPost, PostDTO.class);

        return postDTO2;
    }

    @Override
    public String deletePost(Integer postId) {
        System.out.println("in first");
        Post post = postRepository.findById(postId).get();
        System.out.println("in second");
        postRepository.delete(post);
        return "Post deleted with post id: "+post.getPostId();
        
    }

    @Override
    public List<PostDTO> getAllPosts() {
        List<Post> post = postRepository.findAll();
       List<PostDTO> postDTOs = post.stream().map(category1 -> modelMapper.map(category1, PostDTO.class)).collect(Collectors.toList());

       return postDTOs;
    }

    @Override
    public PostDTO getPostById(Integer postId) {
        Post post = postRepository.findById(postId).get();
        PostDTO postDTO = modelMapper.map(post, PostDTO.class);

        return postDTO;
    }

    @Override
    public List<PostDTO> getPostByUser(Integer userId) {
        User user = userRepository.findById(userId).get();
        List<Post> posts = postRepository.findByUser(user);
        List<PostDTO> postDTOs= posts.stream().map(category1 -> modelMapper.map(category1, PostDTO.class)).collect(Collectors.toList());

        return postDTOs;
    }

    @Override
    public List<PostDTO> getPostByCategory(Integer categoryId) {
        Category category = categoryRepository.findById(categoryId).get();
        List<Post> posts = postRepository.findByCategory(category);
        List<PostDTO> postDTOs= posts.stream().map(category1 -> modelMapper.map(category1, PostDTO.class)).collect(Collectors.toList());

        return postDTOs;
    }

    @Override
    public List<PostDTO> searchPost(String keyword) {
        List<Post> posts = postRepository.findByTitleContaining(keyword);
        List<PostDTO> postDTOs = posts.stream().map((post) -> modelMapper.map(post, PostDTO.class)).collect(Collectors.toList());
        return postDTOs;
    }
    
}
