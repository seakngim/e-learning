package com.example.spring_data_mongodb.feature.category;


import com.example.spring_data_mongodb.domain.Category;
import com.example.spring_data_mongodb.domain.Course;
import com.example.spring_data_mongodb.feature.category.dto.CategoryRequest;
import com.example.spring_data_mongodb.feature.category.dto.CategoryResponse;
import com.example.spring_data_mongodb.feature.category.dto.CategoryUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public void createCategory(CategoryRequest categoryRequest) {
        Category category = new Category();
        category.setUuid(UUID.randomUUID().toString());
        category.setName(categoryRequest.name());
        category.setIcon(categoryRequest.icon());
        category.setIsDeleted(false);

        categoryRepository.save(category);
    }

    @Override
    public List<CategoryResponse> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(category -> new CategoryResponse(
                        category.getId(),
                        category.getName(),
                        category.getIcon(),
                        null,  // Assuming `description` is not in the Category model, adjust as needed
                        category.getIsDeleted()
                ))
                .collect(Collectors.toList());
    }


    @Override
    public CategoryResponse getCategoryById(String id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.map(cat -> new CategoryResponse(
                cat.getId(),
                cat.getName(),
                cat.getIcon(),
                cat.getDescription(),
                cat.getIsDeleted()
        )).orElseThrow(() -> new RuntimeException("Category not found"));
    }


    @Override
    public void updateCategory(String id, CategoryUpdateRequest categoryUpdateRequest) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        // Update the fields from CategoryUpdateRequest
        category.setName(categoryUpdateRequest.title());
        category.setIcon(categoryUpdateRequest.icon());
        category.setDescription(categoryUpdateRequest.description());

        // Save the updated category
        categoryRepository.save(category);
    }


    @Override
    public void enableCategory(String id, boolean enable) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        // Update the isDeleted field
        category.setIsDeleted(!enable);

        // Save the updated category
        categoryRepository.save(category);
    }

    @Override
    public void disableCategory(String id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        category.setIsDeleted(true);

        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(String id) {
        categoryRepository.deleteById(id);
    }

}
