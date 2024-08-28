package com.example.spring_data_mongodb.feature.category.dto;

public record CategoryUpdateRequest(
        String title,
        String icon,
        String description
) {
}
