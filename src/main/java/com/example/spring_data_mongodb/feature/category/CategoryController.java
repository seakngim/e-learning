package com.example.spring_data_mongodb.feature.category;


import com.example.spring_data_mongodb.feature.category.dto.CategoryRequest;
import com.example.spring_data_mongodb.feature.category.dto.CategoryResponse;
import com.example.spring_data_mongodb.feature.category.dto.CategoryUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public void createCategory(@RequestBody CategoryRequest categoryRequest){
        categoryService.createCategory(categoryRequest);
    }

    @GetMapping
    public List<CategoryResponse> getAllCategories() {
        return categoryService.getAllCategories();
    }
    @GetMapping("/{id}")
    public CategoryResponse getCategoryById(@PathVariable String id) {
        return categoryService.getCategoryById(id);
    }

    @PutMapping("/{id}")
    public void updateCategory(@PathVariable String id, @RequestBody CategoryUpdateRequest categoryUpdateRequest) {
        categoryService.updateCategory(id, categoryUpdateRequest);
    }

    @PutMapping("/{id}/enable")
    public void enableCategory(@PathVariable String id, @RequestParam boolean enable) {
        categoryService.enableCategory(id, enable);
    }

    @PutMapping("/{id}/disable")
    public void disableCategory(@PathVariable String id) {
        categoryService.disableCategory(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable String id) {
        categoryService.deleteCategory(id);
    }

}
