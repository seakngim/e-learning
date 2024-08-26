package com.example.spring_data_mongodb.feature.category;

import com.example.spring_data_mongodb.feature.category.dto.CategoryRequest;

public interface CategoryService {

    void createCategory( CategoryRequest categoryRequest);
}
