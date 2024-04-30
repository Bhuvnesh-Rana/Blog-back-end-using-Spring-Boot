package com.blog.DTO;


import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
    
    private Integer commentId;
    @NotEmpty(message = "Comment content cannot be null or empty.")
    private String content;
}
