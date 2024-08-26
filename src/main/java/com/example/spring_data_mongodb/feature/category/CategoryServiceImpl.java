package com.example.spring_data_mongodb.feature.category;


import com.example.spring_data_mongodb.domain.Category;
import com.example.spring_data_mongodb.domain.Course;
import com.example.spring_data_mongodb.feature.category.dto.CategoryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

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
}
