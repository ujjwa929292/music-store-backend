package com.musicstore.themusicstoreapp.service;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import com.musicstore.themusicstoreapp.accessors.models.Category;
import com.musicstore.themusicstoreapp.accessors.repositories.CategoryRepository;
import com.musicstore.themusicstoreapp.exceptions.ResourceNotFoundException;
import com.musicstore.themusicstoreapp.models.CategoryDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public Category createCategory(CategoryDTO categoryDTO) {
        Category category = modelMapper.map(categoryDTO, Category.class);
        return categoryRepository.save(category);
    }

    public Category updateCategory(UUID id, CategoryDTO categoryDTO) {
        Category existingCategory = getCategoryById(id);
        modelMapper.map(categoryDTO, existingCategory);
        return categoryRepository.save(existingCategory);
    }

    public void deleteCategory(UUID id) {
        categoryRepository.deleteById(id);
    }

    public Category getCategoryById(UUID id) {
        return categoryRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}

