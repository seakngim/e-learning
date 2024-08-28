package com.example.spring_data_mongodb.feature.category;

import com.example.spring_data_mongodb.feature.category.dto.CategoryRequest;
import com.example.spring_data_mongodb.feature.category.dto.CategoryResponse;
import com.example.spring_data_mongodb.feature.category.dto.CategoryUpdateRequest;

import java.util.List;

public interface CategoryService {
    void createCategory( CategoryRequest categoryRequest);
    List<CategoryResponse> getAllCategories();
    CategoryResponse getCategoryById(String id);
    void updateCategory(String id, CategoryUpdateRequest categoryUpdateRequest);
    void enableCategory(String id, boolean enable);
    void disableCategory(String id);
    void deleteCategory(String id);
}
