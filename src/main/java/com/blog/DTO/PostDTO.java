package com.blog.DTO;

import java.util.ArrayList;
import java.util.Date;
// import java.util.HashSet;
import java.util.List;
// import java.util.Set;


import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    
    private Integer postId;
    @NotEmpty(message = "Title cannot be null or empty.")
    private String title;
    @NotEmpty(message = "Content cannot be null or empty.")
    private String content;
    private String image;
    private Date date;
    private UserDTO user;
    private CategoryDTO category;
    private List<CommentDTO> comments = new ArrayList<>();
}
