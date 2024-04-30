package com.blog.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
// import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.DTO.CategoryDTO;
import com.blog.Entity.Category;
import com.blog.Repository.CategoryRepository;
import com.blog.Service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDTO addCategory(CategoryDTO categoryDTO) {
        // Category category = new Category();
        // BeanUtils.copyProperties(categoryDTO, category);
        // categoryRepository.save(category);
        // return categoryDTO;

        Category category2 = modelMapper.map(categoryDTO, Category.class);
        categoryRepository.save(category2);
        CategoryDTO categoryDTO2 = modelMapper.map(category2,CategoryDTO.class);
        return categoryDTO2;


    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Integer categoryId) {
        Category category = categoryRepository.findById(categoryId).get();
        category.setCategoryTitle(categoryDTO.getCategoryTitle());
        category.setCategoryDescription(categoryDTO.getCategoryDescription());
        categoryRepository.save(category);
        
        return modelMapper.map(category, CategoryDTO.class);
    }

    @Override
    public CategoryDTO getCategoryById(Integer categoryId) {
        Category category = categoryRepository.findById(categoryId).get();
        return modelMapper.map(category, CategoryDTO.class);
    }

    @Override
    public List<CategoryDTO> getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDTO> categoryDTOs= categories.stream().map(category1 -> modelMapper.map(category1, CategoryDTO.class)).collect(Collectors.toList());
        return categoryDTOs;
    }

    @Override
    public String deletCategory(Integer categoryId) {
        Category category = categoryRepository.findById(categoryId).get();
        categoryRepository.delete(category);
    
        return "Category deleted with CategoryId: "+category.getCategoryId();
    }
}
