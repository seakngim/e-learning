package com.example.spring_data_mongodb.feature.category.dto;

public record CategoryResponse(
        String id,
        String title,

        String icon,

        String description,

        Boolean isDeleted
) {
}
