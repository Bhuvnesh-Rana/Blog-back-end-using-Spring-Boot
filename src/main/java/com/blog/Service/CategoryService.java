package com.blog.Service;

import java.util.List;

import com.blog.DTO.CategoryDTO;

public interface CategoryService {
    
    CategoryDTO addCategory(CategoryDTO categoryDTO);
    CategoryDTO updateCategory(CategoryDTO categoryDTO, Integer categoryId);
    CategoryDTO getCategoryById(Integer categoryId);
    List<CategoryDTO> getAllCategory();
    String deletCategory(Integer categoryId);
}
