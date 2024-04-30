package com.blog.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    
    private Integer categoryId;
    @NotEmpty(message = "Category title cannot be null or empty.")
    private String categoryTitle;
    @NotEmpty(message = "Category description cannot be null or empty.")
    private String categoryDescription;
}
