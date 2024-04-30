package com.blog.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.DTO.CategoryDTO;
import com.blog.Service.CategoryService;

import jakarta.validation.Valid;

@RestController
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;


    @PostMapping("category")
    public CategoryDTO addCategory(@Valid @RequestBody CategoryDTO categoryDTO){
        return categoryService.addCategory(categoryDTO);
    }

    @PutMapping("category/{categoryId}")
    public CategoryDTO updateCategory(@Valid @RequestBody CategoryDTO categoryDTO, @PathVariable Integer categoryId){
        return categoryService.updateCategory(categoryDTO, categoryId);
    }

    @GetMapping("category/{categoryId}")
    public CategoryDTO getCategoryById(@PathVariable Integer categoryId){
        return categoryService.getCategoryById(categoryId);
    }
    
    @GetMapping("category")
    public List<CategoryDTO> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @DeleteMapping("category/{categoryId}")
    public String deleteCategory(@PathVariable ("categoryId") Integer cId){
        return categoryService.deletCategory(cId);
    }

}
