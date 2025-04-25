package com.musicstore.themusicstoreapp.service.impl;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.musicstore.themusicstoreapp.accessors.models.Category;
import com.musicstore.themusicstoreapp.models.CategoryDTO;
import com.musicstore.themusicstoreapp.service.CategoryService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public Category createCategory(CategoryDTO categoryDTO) {
        Category category = modelMapper.map(categoryDTO, Category.class);
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(UUID id, CategoryDTO categoryDTO) {
        if (!categoryRepository.existsById(id)) {
            throw new IllegalArgumentException("Category not found");
        }
        Category category = modelMapper.map(categoryDTO, Category.class);
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(UUID id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category getCategoryById(UUID id) {
        return categoryRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Category not found"));
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
