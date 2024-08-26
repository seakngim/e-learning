package com.example.spring_data_mongodb.feature.category;


import com.example.spring_data_mongodb.feature.category.dto.CategoryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public void createCategory(@RequestBody CategoryRequest categoryRequest){
        categoryService.createCategory(categoryRequest);
    }
}
